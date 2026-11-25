package test_for_login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test_cass_comp_for_email {
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
    public void test_login_comp() throws InterruptedException {
        Thread.sleep(5000);
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("customer@practicesoftwaretesting.com");
        Thread.sleep(10000);
        WebElement login = driver.findElement(By.className("btnSubmit"));
        login.click();
    }
    @Test
    public void test_login_comp2() throws InterruptedException {
        Thread.sleep(5000);
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("customer@practicesoftwaretesting.");
        Thread.sleep(10000);
        WebElement login = driver.findElement(By.className("btnSubmit"));
        login.click();
    }
    @Test
    public void test_login_comp3() throws InterruptedException {
        Thread.sleep(5000);
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("12342@");
        Thread.sleep(10000);
        WebElement login = driver.findElement(By.className("btnSubmit"));
        login.click();
    }
    @Test
    public void test_login_comp4() throws InterruptedException {
        Thread.sleep(5000);
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("       ");
        Thread.sleep(10000);
        WebElement login = driver.findElement(By.className("btnSubmit"));
        login.click();
    }
    @Test
    public void test_login_comp5() throws InterruptedException {
        Thread.sleep(5000);
        WebElement username = driver.findElement(By.id("email"));
        username.sendKeys("ahmed@ahmed");
        Thread.sleep(10000);
        WebElement login = driver.findElement(By.className("btnSubmit"));
        login.click();
    }
}
