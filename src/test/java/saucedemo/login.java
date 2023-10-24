package saucedemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
    @Test
    public void success_login(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        //apply chrome driver setup
        //open login page
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        /** //Assert pasca login
        String LoginPageAssert = driver.findElement(By.class('app_logo'));
        Assert.assertEquals(LoginPageAssert, "app_logo"); **/

        //input username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //input password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //click button
        driver.findElement(By.id("login-button")).click();

        //Assert pasca login 2
        //driver.wait(100);
        String namabrng = driver.findElement(By.xpath("//*[@id=\'item_4_title_link\']/div")).getText();
        Assert.assertEquals(namabrng, "Sauce Labs Backpack");

        //close the brower
        driver.quit();
    }
}
