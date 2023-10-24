package saucedemo.cucumber.stepDef;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class checkout{

    WebDriver driver;
    String baseurl = "https://www.saucedemo.com/";
    @Given("click the Add to Cart button on one of the products")
    public void add_to_cart_one_of_product(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseurl);

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

     }
     @When("Click the Cart icon in the top right corner")
     public void click_the_cart_icon(){
        driver.findElement(By.xpath("//*[@id=\'shopping_cart_container\']/a")).click();
     }

     @And("Click the Checkout button")
    public void click_checkout_button(){
        driver.findElement(By.id("checkout")).click();
     }

     @And("Enter first name")
    public void first_name(){
        driver.findElement(By.id("first-name")).sendKeys("Sheila");
     }

     @And("Enter last name")
    public void last_name(){
         driver.findElement(By.id("last-name")).sendKeys("Malik");
     }

     @And("Enter postal code")
    public void postal_code(){
         driver.findElement(By.id("postal-code")).sendKeys("12345");
     }

     @And("Click the Continue button")
    public void click_continue_button(){
        driver.findElement(By.id("continue")).click();
     }

     @Then("Click the Finish button")
    public void click_finish_button(){
        driver.findElement(By.id("finish")).click();
     }
}