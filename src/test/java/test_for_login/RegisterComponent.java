package test_for_login;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterComponent {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        driver.navigate().to("https://practicesoftwaretesting.com/auth/register");
        Thread.sleep(2000);
    }

    @Test
    public void testCase1() throws InterruptedException {
        WebElement firstName = driver.findElement(By.cssSelector("input[data-test='first-name']"));
        firstName.sendKeys("Youssef");
        firstName.sendKeys(Keys.TAB);
        Thread.sleep(2000);

        List<WebElement> errors = driver.findElements(By.cssSelector("form[data-test='register-form'] .alert.alert-danger"));
        Assert.assertTrue(errors.isEmpty(), "BUG: First name field did not accept 7 letters.");
    }

    @Test
    public void testCase2() throws InterruptedException {
        WebElement dob = driver.findElement(By.cssSelector("input[data-test='dob']"));
        dob.click();
        dob.sendKeys(Keys.TAB);
        Thread.sleep(2000);

        List<WebElement> errors = driver.findElements(By.cssSelector("form[data-test='register-form'] .alert.alert-danger"));
        Assert.assertFalse(errors.isEmpty(), "BUG: Leaving the date of birth empty did not show a mandatory field error.");
    }

    @Test
    public void testCase3() throws InterruptedException {
        WebElement phone = driver.findElement(By.cssSelector("input[data-test='phone']"));
        phone.sendKeys("phoneNumber");
        phone.sendKeys(Keys.TAB);
        Thread.sleep(2000);

        List<WebElement> errors = driver.findElements(By.cssSelector("form[data-test='register-form'] .alert.alert-danger"));
        Assert.assertFalse(errors.isEmpty(), "BUG: Phone field accepted letters instead of numbers.");
    }

    @Test
    public void testCase4() throws InterruptedException {
        WebElement email = driver.findElement(By.cssSelector("input[data-test='email']"));
        email.sendKeys("ismailislam@");
        email.sendKeys(Keys.TAB);
        Thread.sleep(2000);

        List<WebElement> errors = driver.findElements(By.cssSelector("form[data-test='register-form'] .alert.alert-danger"));
        Assert.assertFalse(errors.isEmpty(), "BUG: Email field accepted an email with a missing domain.");
    }

    @Test
    public void testCase5() throws InterruptedException {
        WebElement password = driver.findElement(By.cssSelector("input[data-test='password']"));
        password.sendKeys("Aa1$aaa");
        password.sendKeys(Keys.TAB);
        Thread.sleep(2000);

        List<WebElement> errors = driver.findElements(By.cssSelector("form[data-test='register-form'] .alert.alert-danger"));
        Assert.assertFalse(errors.isEmpty(), "BUG: Password field accepted a password with less than 8 characters.");
    }

    @AfterMethod
    public void afterMethod() {
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
