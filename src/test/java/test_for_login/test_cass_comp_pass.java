package test_for_login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test_cass_comp_pass {
    WebDriver driver ;

    @BeforeMethod
    public void beforeMethod() {
        driver=new ChromeDriver();
        driver.navigate().to("https://practicesoftwaretesting.com/auth/login");
    }
    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
    @Test
    public void test_for_login_pass() throws InterruptedException {
        Thread.sleep(5000);
        WebElement pass=driver.findElement(By.id("password"));
        pass.sendKeys("welcome01");
        Thread.sleep(10000);
        WebElement login = driver.findElement(By.className("btnSubmit"));
        login.click();
    }
    @Test
    public void test_for_login_pass2() throws InterruptedException {
        Thread.sleep(5000);
        WebElement pass=driver.findElement(By.id("password"));
        pass.sendKeys("     ");
        Thread.sleep(10000);
        WebElement login = driver.findElement(By.className("btnSubmit"));
        login.click();
    }
    @Test
    public void test_for_login_pass3() throws InterruptedException {
        Thread.sleep(5000);
        WebElement pass=driver.findElement(By.id("password"));
        pass.sendKeys("12");
        Thread.sleep(10000);
        WebElement login = driver.findElement(By.className("btnSubmit"));
        login.click();
    }
    @Test
    public void test_for_login_pass4() throws InterruptedException {
        Thread.sleep(5000);
        WebElement pass=driver.findElement(By.id("password"));
        pass.sendKeys("1234567890");
        Thread.sleep(10000);
        WebElement login = driver.findElement(By.className("btnSubmit"));
        login.click();
    }
    @Test
    public void test_for_login_pass5() throws InterruptedException {
        Thread.sleep(5000);
        WebElement pass=driver.findElement(By.id("password"));
        pass.sendKeys("");
        Thread.sleep(5000);
        WebElement login = driver.findElement(By.className("btnSubmit"));
        login.click();
    }

}
