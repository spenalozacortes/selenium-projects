package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.MainPage;
import pageObject.PrivacyPolicyPage;
import util.Browser;

public class Tests {
    String url = "https://store.steampowered.com/";

    @BeforeMethod
    public void setup() {
        // Navigate to main page
        Browser.getDriver().get(url);
        Browser.getDriver().manage().window().maximize();
    }

    @Test
    public void test() {
        // Scroll* and open privacy policy
        MainPage mainPage = new MainPage();
        PrivacyPolicyPage privacyPolicyPage = mainPage.clickPrivacyLink();

        // Privacy policy page is open in new tab
        Assert.assertTrue(privacyPolicyPage.isPrivacyPageOpened(), "Privacy policy page is not opened!");

        // Switch language elements list displayed
        Assert.assertTrue(privacyPolicyPage.getLanguageList().isDisplayed(), "Language list is not displayed!");

        // Supported languages: English, Spanish, French, German
        // Italian, Russian, Japanese, Portuguese, Brazilian
        Assert.assertTrue(privacyPolicyPage.isLanguageListComplete(), "Language list is not complete!");

        // Policy revision signed in 2023
        Assert.assertTrue(privacyPolicyPage.getRevisionDate().getText().contains("2023"), "Revision date is wrong!");
    }

    @AfterMethod
    public void teardown() {
        Browser.quitDriver();
    }
}
