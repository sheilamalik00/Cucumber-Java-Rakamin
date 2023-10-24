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

public class deleteproduct {
    WebDriver driver;
    String baseurl = "https://www.saucedemo.com/";

    @Given("user enters product into cart")
    public void enters_product_into_cart() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);
        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseurl);

        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
    }

    @When("the product that the user enters into the cart, clicks on the product")
    public void enters_into_the_cart
    {
        driver.findElement(By.ByXPath("//*[@id='item_1_title_link']/div")).click();

    }
    @And("user clicks the Remove button")
    public void click_remove_button
    {
        driver.findElement(By.ById("remove-sauce-labs-bolt-t-shirt")).click();
    }
    @Then("the product was successfully deleted")
    public void product_was_deleted{
        String yourcart = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(yourcart, "Your Cart");
    }
}
