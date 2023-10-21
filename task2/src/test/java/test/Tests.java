package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.RandomUtils;

import java.time.Duration;

public class Tests {

    WebDriver driver;
    WebDriverWait wait;
    String url = "https://store.steampowered.com/";

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void loginTest() {
        // Navigate to main page
        driver.get(url);

        // Main page is displayed
        WebElement homePageContent = driver.findElement(By.cssSelector(".home_page_content"));
        Assert.assertTrue(homePageContent.isDisplayed(), "Main page is not opened!");

        // Click login link
        WebElement loginLink = driver.findElement(By.cssSelector("a.global_action_link"));
        loginLink.click();

        // Login page is open
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class,'SubmitButton')]")));
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(@class,'SubmitButton')]"));
        Assert.assertTrue(loginButton.isDisplayed(), "Login page is not opened!");

        // Input random strings as credentials
        String randomUsername = RandomUtils.generateRandomString(8);
        WebElement usernameField = driver.findElement(By.xpath("//input[@type='text']"));
        usernameField.sendKeys(randomUsername);

        String randomPassword = RandomUtils.generateRandomString(8);
        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.sendKeys(randomPassword);

        // Click sign in button
        WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit']"));
        signInButton.click();

        // Loading element is displayed
        WebElement spinner = driver.findElement(By.xpath("//*[contains(@class,'LoadingSpinner')]"));
        Assert.assertTrue(spinner.isDisplayed(), "Loading element is not displayed!");

        // Error text is displayed (after loading element disappearing)
        wait.until(ExpectedConditions.invisibilityOf(spinner));
        WebElement errorText = driver.findElement(By.xpath("//*[contains(@class,'FormError')]"));
        Assert.assertTrue(errorText.isDisplayed(), "Error text is not displayed!");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
