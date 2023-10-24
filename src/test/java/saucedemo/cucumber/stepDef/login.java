package saucedemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseurl = "https://www.saucedemo.com/";


    @Given("user launch the website app in  www.saucedemo.com")
    public void launch_website_saucedemo(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);
        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseurl);
    }

    @When("user input a registered username")
    public void input_registered_username(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("user input a registered password")
    public void input_registered_password(){
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("user click log in button")
    public void click_login_button(){
        driver.findElement(By.id("login-button")).click();
    }

    @Then("home page should be displayed")
    public void home_page_displayed(){
        String namabrng = driver.findElement(By.xpath("//*[@id=\'item_4_title_link\']/div")).getText();
        Assert.assertEquals(namabrng, "Sauce Labs Backpack");
        driver.quit();
    }

    @Given("user open the website app in  www.saucedemo.com")
    public void userOpenTheWebsiteAppInWwwSaucedemoCom() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);
        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseurl);
    }

    @When("user input an unregistered username")
    public void userInputAnUnregisteredUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_userrr");
    }

    @And("user input an unregistered password")
    public void userInputAnUnregisteredPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_5auce");
    }

    @And("user tap log in button")
    public void userTapLogInButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user get error message")
    public void userGetErrorMessage() {
        driver.findElement(By.className("error-button")).isDisplayed();
    }
}