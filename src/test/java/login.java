import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
    @Test //untuk running script dibawah ini
    public static void main(String[] args){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        String title = driver.getTitle();
        System.out.println(title);

        /**Example Get Form
        WebElement element1 = driver.findElement(By.id("user-name"));
        WebElement element2 = driver.findElement(By.className("submit-button btn_action"));
        element1.click();
        element1.sendKeys("standard_user");
        element1.getText();
        element2.isDisplayed();
        element2.click(); **/

        driver.close();
    }
}
