package test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.BaseElement;
import util.Browser;
import util.RandomUtils;

import java.time.Duration;

public class Tests {
    WebDriverWait wait;
    String url = "https://store.steampowered.com/";

    @BeforeMethod
    public void setup() {
        // Navigate to main page
        Browser.getDriver().get(url);
        Browser.getDriver().manage().window().maximize();

        wait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(5));
    }

    @Test
    public void loginTest() {
        // Main page is displayed
        BaseElement homePageContent = new BaseElement(By.cssSelector(".home_page_content"));
        Assert.assertTrue(homePageContent.isDisplayed(), "Main page is not opened!");

        // Click login link
        BaseElement loginLink = new BaseElement(By.cssSelector("a.global_action_link"));
        loginLink.click();

        // Login page is open
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class,'SubmitButton')]")));
        BaseElement loginButton = new BaseElement(By.xpath("//button[contains(@class,'SubmitButton')]"));
        Assert.assertTrue(loginButton.isDisplayed(), "Login page is not opened!");

        // Input random strings as credentials
        String randomUsername = RandomUtils.generateRandomString(8);
        BaseElement usernameField = new BaseElement(By.xpath("//input[@type='text']"));
        usernameField.sendKeys(randomUsername);

        String randomPassword = RandomUtils.generateRandomString(8);
        BaseElement passwordField = new BaseElement(By.xpath("//input[@type='password']"));
        passwordField.sendKeys(randomPassword);

        // Click sign in button
        BaseElement signInButton = new BaseElement(By.xpath("//button[@type='submit']"));
        signInButton.click();

        // Loading element is displayed
        BaseElement spinner = new BaseElement(By.xpath("//*[contains(@class,'LoadingSpinner')]"));
        Assert.assertTrue(spinner.isDisplayed(), "Loading element is not displayed!");

        // Error text is displayed (after loading element disappearing)
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(@class,'LoadingSpinner')]")));
        BaseElement errorText = new BaseElement(By.xpath("//*[contains(@class,'FormError')]"));
        Assert.assertTrue(errorText.isDisplayed(), "Error text is not displayed!");
    }

    @AfterMethod
    public void teardown() {
        Browser.quitDriver();
    }
}
