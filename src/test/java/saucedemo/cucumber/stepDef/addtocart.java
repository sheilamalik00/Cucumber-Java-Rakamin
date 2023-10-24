package saucedemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.chrono.ChronoPeriod;
import java.util.concurrent.TimeUnit;

public class addtocart {
    WebDriver driver;
    String baseurl = "https://www.saucedemo.com/";
    @Given("user login to user account")
    public void login_to_user_account(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);
        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseurl);

    }

    @When("user choose the product")
    public void choose_the_product(){

    }

    @And("user click Add To Cart button")
    public void click_add_to_cart_button(){

    }

    @Then("the product successfully entered to Your Cart page")
    public void product_entered_to_your_cart_page(){

    }

}
