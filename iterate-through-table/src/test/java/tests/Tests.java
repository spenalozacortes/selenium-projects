package tests;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.MainPage;
import pageObjects.MostPlayedPage;
import utils.Browser;
import utils.ConfigReader;
import utils.DataReader;

import java.text.ParseException;

public class Tests {
    
    @BeforeMethod
    public void setup() {
        // Navigate to main page
        ConfigReader configReader = new ConfigReader();
        String url = configReader.getBaseUrl();
        Browser.getDriver().get(url);
        Browser.getDriver().manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        Browser.quitDriver();
    }

    @DataProvider
    public Object[][] getData() {
        JsonArray data = DataReader.readTestData();
        return new Object[][] { { data.get(0) } };
    }

    @Test(dataProvider = "getData")
    public void playedGames(JsonObject data) throws ParseException {
        // Main page is open
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpen(), "Main page is not open!");

        // Move cursor to new and noteworthy and click 'most played' in a dropdown
        mainPage.middleNavigationForm.clickMostPlayed();

        // Most played page is open
        MostPlayedPage mostPlayedPage = new MostPlayedPage();
        Assert.assertTrue(mostPlayedPage.isPageOpen(), "Most played page is not open!");

        // Retrieve number of current players for 1st and 2nd game
        JsonArray games = data.getAsJsonArray("ranks");
        int players1stgame = mostPlayedPage.getNumberOfCurrentPlayers(games.get(0).getAsInt());
        int players2ndgame = mostPlayedPage.getNumberOfCurrentPlayers(games.get(1).getAsInt());

        // 1st game in the list has more current players than 2nd
        Assert.assertTrue(players1stgame > players2ndgame, "2nd game has more players than 1st!");

        // Retrieve number of current players for 3rd game
        int players3rdgame = mostPlayedPage.getNumberOfCurrentPlayers(games.get(2).getAsInt());

        // 2nd game in the list has more current players than 3rd
        Assert.assertTrue(players2ndgame > players3rdgame, "3rd game has more players than 2nd!");
    }
}
