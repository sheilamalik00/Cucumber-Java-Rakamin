package saucedemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class failed_login {
    @Test
    public void failed_login() {
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        //apply chrome driver setup
        //open login page
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        //input username
        driver.findElement(By.id("user-name")).sendKeys("standard_userrr");
        //input password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //click button
        driver.findElement(By.id("login-button")).click();

        //Assert pasca login 2
        //driver.wait(100);
        driver.findElement(By.className("error-button")).isDisplayed();

        //close the brower
        driver.quit();
    }
}