package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.LoginPage;
import pageObject.MainPage;
import util.Browser;
import util.RandomUtils;

public class Tests {
    String url = "https://store.steampowered.com/";

    @BeforeMethod
    public void setup() {
        // Navigate to main page
        Browser.getDriver().get(url);
        Browser.getDriver().manage().window().maximize();
    }

    @Test
    public void loginTest() {
        // Main page is displayed
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isMainPageOpened(), "Main page is not opened!");

        // Click login link
        mainPage.clickLoginLink();

        // Login page is open
        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.isLoginPageOpened(), "Login page is not opened!");

        // Input random strings as credentials
        String randomUsername = RandomUtils.generateRandomString(8);
        loginPage.setUsernameField(randomUsername);

        String randomPassword = RandomUtils.generateRandomString(8);
        loginPage.setPasswordField(randomPassword);

        // Click sign in button
        loginPage.clickLoginButton();

        // Loading element is displayed
        Assert.assertTrue(loginPage.isSpinnerDisplayed(), "Loading element is not displayed!");

        // Error text is displayed (after loading element disappearing)
        String expectedMessage = "Comprueba tu contraseña y nombre de cuenta e inténtalo de nuevo.";
        Assert.assertTrue(loginPage.isErrorTextCorrect(expectedMessage), "Error message is wrong!");
    }

    @AfterMethod
    public void teardown() {
        Browser.quitDriver();
    }
}