package tests;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.NewsPage;
import pageObjects.StorePage;
import utils.Browser;
import utils.ConfigReader;
import utils.DataReader;

public class Tests {

    @BeforeMethod
    public void setup() {
        ConfigReader configReader = new ConfigReader();

        // Navigate to store page
        Browser.getDriver().get(configReader.getBaseUrl());
        Browser.getDriver().manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        Browser.quitDriver();
    }

    @DataProvider
    public Object[][] getData() {
        JsonArray testData = DataReader.readTestData();
        assert testData != null;
        return new Object[][] { {testData.get(0)} };
    }

    @Test(dataProvider = "getData")
    public void test(JsonObject data) {
        // Store page is open
        StorePage storePage = new StorePage();
        Assert.assertTrue(storePage.isPageOpen(), "Store page is not open!");

        // Click on News button
        storePage.middleNavigationForm.clickNewsButton();

        // News page is open
        NewsPage newsPage = new NewsPage();
        Assert.assertTrue(newsPage.isPageOpen(), "News page is not open!");

        // Click Options and Filters
        newsPage.leftMenuForm.clickOptionsAndFiltersButton();

        // Untick all options in 'show these types of posts' part
        newsPage.leftMenuForm.untickAllCheckboxes();

        // Message 'No posts found. Try selecting different search criteria in the sidebar.' is displayed
        String expectedMessage = data.get("message").getAsString();
        Assert.assertTrue(expectedMessage.equalsIgnoreCase(newsPage.getMessage()), "Expected message is incorrect!");
    }
}
