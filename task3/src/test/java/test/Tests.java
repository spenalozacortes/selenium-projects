package test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.MainPage;
import pageObject.PrivacyPolicyPage;
import util.Browser;
import util.ConfigReader;
import util.DataReader;

public class Tests {
    ConfigReader configReader = new ConfigReader();
    String url = configReader.getBaseUrl();

    @BeforeMethod
    public void setup() {
        // Navigate to main page
        Browser.getDriver().get(url);
        Browser.getDriver().manage().window().maximize();
    }

    @Test(dataProvider = "getData")
    public void test(JsonObject input) {
        JsonArray languages = input.get("languages").getAsJsonArray();
        String revisionDate = input.get("revisionDate").getAsString();

        // Scroll and open privacy policy
        MainPage mainPage = new MainPage();
        mainPage.clickPrivacyLink();

        // Privacy policy page is open in new tab
        PrivacyPolicyPage privacyPolicyPage = new PrivacyPolicyPage();
        Assert.assertTrue(privacyPolicyPage.isPrivacyPageOpened(), "Privacy policy page is not opened!");

        // Switch language elements list displayed
        Assert.assertTrue(privacyPolicyPage.isLanguageListDisplayed(), "Language list is not displayed!");

        // Supported languages: English, Spanish, French, German
        // Italian, Russian, Japanese, Portuguese, Brazilian
        Assert.assertTrue(privacyPolicyPage.isLanguageListComplete(languages), "Language list is not complete!");

        // Policy revision signed in 2023
        Assert.assertTrue(privacyPolicyPage.isPrivacySignedCorrectly(languages, revisionDate), "Revision date is wrong!");
    }

    @AfterMethod
    public void teardown() {
        Browser.quitDriver();
    }

    @DataProvider
    public Object[][] getData() {
        JsonArray testData = DataReader.readTestData();
        return new Object[][] { {testData.get(0).getAsJsonObject()} };
    }
}
