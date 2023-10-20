package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests {

    WebDriver driver;
    String url = "https://store.steampowered.com/";

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void loginTest() {
        driver.get(url);

        // Main page is displayed
        String actualTitle = driver.getTitle();
        String expectedTitle = "Bienvenidos a Steam";
        Assert.assertEquals(actualTitle, expectedTitle, "Landed on wrong page!");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
