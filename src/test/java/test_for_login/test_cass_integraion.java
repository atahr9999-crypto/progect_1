package test_for_login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test_cass_integraion {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver=new ChromeDriver();
        driver.navigate().to("https://practicesoftwaretesting.com/auth/login");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void loginTest() throws InterruptedException {
        Thread.sleep(5000);
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("customer@practicesoftwaretesting.com");
        WebElement pass=driver.findElement(By.id("password"));
        pass.sendKeys("welcome01");
        Thread.sleep(5000);
        WebElement login = driver.findElement(By.className("btnSubmit"));
        login.click();
        Thread.sleep(5000);
        Assert.assertTrue(driver.getCurrentUrl().contains("/account"),
                "User should be redirected to the account page");
    }



    @Test
    public void loginTest2() throws InterruptedException {
        Thread.sleep(5000);
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("customer@practicesoftwaretesting.com");
        WebElement pass=driver.findElement(By.id("password"));
        pass.sendKeys("invaledpassword");
        Thread.sleep(5000);
        WebElement login = driver.findElement(By.className("btnSubmit"));
        login.click();
        Thread.sleep(5000);
        Assert.assertTrue(driver.getCurrentUrl().contains("/auth/login"),
                "User should stay on the login page");

    }
    @Test
    public void loginTest3() throws InterruptedException {
        Thread.sleep(5000);
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("customer");
        WebElement pass=driver.findElement(By.id("password"));
        pass.sendKeys("welcome01");
        Thread.sleep(5000);
        WebElement login = driver.findElement(By.className("btnSubmit"));
        login.click();
        Thread.sleep(5000);
        Assert.assertTrue(driver.getCurrentUrl().contains("/auth/login"),
                "User should stay on the login page");
    }
    @Test
    public void loginTest4() throws InterruptedException {
        Thread.sleep(5000);
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("customer");
        WebElement pass=driver.findElement(By.id("password"));
        pass.sendKeys("welcome");
        Thread.sleep(5000);
        WebElement login = driver.findElement(By.className("btnSubmit"));
        login.click();
        Thread.sleep(5000);
        Assert.assertTrue(driver.getCurrentUrl().contains("/auth/login"),
                "User should stay on the login page");
    }
    @Test
    public void loginTest5() throws InterruptedException {
        Thread.sleep(5000);
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("");
        WebElement pass=driver.findElement(By.id("password"));
        pass.sendKeys("");
        Thread.sleep(5000);
        WebElement login = driver.findElement(By.className("btnSubmit"));
        login.click();
        Thread.sleep(5000);
        Assert.assertTrue(driver.getCurrentUrl().contains("/auth/login"),
                "User should stay on the login page");
    }
    @Test
    public void loginTest6() throws InterruptedException {
        Thread.sleep(5000);
        WebElement gogal = driver.findElement(By.className("google-sign-in-button"));
        gogal.click();
    }
    @Test
    public void loginTest7() throws InterruptedException {
        Thread.sleep(5000);
        WebElement forgetpassword = driver.findElement(By.className("ForgetPwd"));
        forgetpassword.click();
        WebElement youeremail = driver.findElement(By.id("email"));
        youeremail.sendKeys("customer@practicesoftwaretesting.com");
        Thread.sleep(5000);
        WebElement resetpassword = driver.findElement(By.className("btnSubmit"));
        resetpassword.click();
    }
}