package test_for_login;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterIntegration {

    WebDriver driver;
    String email;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        driver.navigate().to("https://practicesoftwaretesting.com/auth/register");
        email = "qa.automation." + System.currentTimeMillis() + "@example.com";
        Thread.sleep(2000);
    }

    public void fillForm(String badField, String badValue) {
        String[][] data = {{"first-name", "Youssef"}, {"last-name", "Shaker"}, {"dob", "1998-05-15"},
                {"postal_code", "32511"}, {"house_number", "42"}, {"street", "El Galaa Street"},
                {"city", "Shebin El Kom"}, {"state", "Monufia"}, {"phone", "01012345678"},
                {"email", email}, {"password", "ValidP@ss123"}};
        new Select(driver.findElement(By.cssSelector("select[data-test='country']"))).selectByValue("EG");
        for (String[] d : data) {
            String value = d[0].equals(badField) ? badValue : d[1];
            driver.findElement(By.cssSelector("input[data-test='" + d[0] + "']")).sendKeys(value);
        }
    }

    @Test
    public void testCase1() throws InterruptedException {
        fillForm("password", "Aa1aaaaa");
        driver.findElement(By.cssSelector("button[data-test='register-submit']")).click();
        Thread.sleep(2000);

        List<WebElement> errors = driver.findElements(By.cssSelector("form[data-test='register-form'] .alert.alert-danger"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/auth/register"), "BUG: Registration succeeded with an invalid password.");
        Assert.assertFalse(errors.isEmpty(), "BUG: No error was shown for the invalid password.");
    }

    @Test
    public void testCase2() throws InterruptedException {
        fillForm("email", "ismailislam424@@gmail.com");
        driver.findElement(By.cssSelector("button[data-test='register-submit']")).click();
        Thread.sleep(2000);

        List<WebElement> errors = driver.findElements(By.cssSelector("form[data-test='register-form'] .alert.alert-danger"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/auth/register"), "BUG: Registration succeeded with an invalid email.");
        Assert.assertFalse(errors.isEmpty(), "BUG: No error was shown for the invalid email.");
    }

    @Test
    public void testCase3() throws InterruptedException {
        fillForm("phone", "01312345678");
        driver.findElement(By.cssSelector("button[data-test='register-submit']")).click();
        Thread.sleep(2000);

        List<WebElement> errors = driver.findElements(By.cssSelector("form[data-test='register-form'] .alert.alert-danger"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/auth/register"), "BUG: Registration succeeded with an invalid phone prefix (013).");
        Assert.assertFalse(errors.isEmpty(), "BUG: No error was shown for the invalid phone prefix.");
    }

    @Test
    public void testCase4() throws InterruptedException {
        fillForm("dob", "2050-05-18");
        driver.findElement(By.cssSelector("button[data-test='register-submit']")).click();
        Thread.sleep(2000);

        List<WebElement> errors = driver.findElements(By.cssSelector("form[data-test='register-form'] .alert.alert-danger"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/auth/register"), "BUG: Registration succeeded with an upcoming date of birth.");
        Assert.assertFalse(errors.isEmpty(), "BUG: No error was shown for the upcoming date of birth.");
    }

    @Test
    public void testCase5() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        fillForm("", "");
        driver.findElement(By.cssSelector("button[data-test='register-submit']")).click();
        Assert.assertTrue(wait.until(ExpectedConditions.urlContains("/auth/login")), "BUG: Registration did not redirect to the login page.");

        driver.findElement(By.cssSelector("input[data-test='email']")).sendKeys(email);
        driver.findElement(By.cssSelector("input[data-test='password']")).sendKeys("ValidP@ss123");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[data-test='login-submit']")).click();
        Assert.assertTrue(wait.until(ExpectedConditions.urlContains("/account")), "BUG: Login with the new account did not reach the account page.");
    }

    @AfterMethod
    public void afterMethod() {
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
