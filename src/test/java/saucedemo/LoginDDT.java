package saucedemo;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginDDT {
    //login with TDD feature
    @Test
    public void login_DDT() {
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);
        String csvDir = System.getProperty("user, dir") + "/rc/test/data/test-data.csv";
        try (CSVReader reader = new CSVReader(new FileReader(csvDir))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null){
                String email = nextLine[0]; // read column 1 for email
                String password = nextLine[1]; // read column 2 for password
                String status = nextLine[2]; // read column 3 for expected login status

                driver = new ChromeDriver(opt);
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                driver.get(baseUrl);

                //input username
                driver.findElement(By.id("user-name")).sendKeys("standard_user");
                //input password
                driver.findElement(By.id("password")).sendKeys("secret_sauce");
                //click button
                driver.findElement(By.id("login-button")).click();

                //assertion
                if (status.equals("success")){
                    driver.findElement(By.id("react-burger-menu-btn"));
                    String namabrng = driver.findElement(By.xpath("//*[@id=\'item_4_title_link\']/div")).getText();
                    Assert.assertEquals(namabrng, "Sauce Labs Backpack");
                } else {
                    String loginerror;
                    loginerror = driver.findElement(By.id("login-button")).getText();
                    Assert.assertEquals(loginerror, "Epic sadface: Username and password do not match any user in this service");
                }
                driver.close();
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
