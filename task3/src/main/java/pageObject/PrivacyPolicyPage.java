package pageObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.openqa.selenium.By;
import util.Container;
import util.DataReader;
import util.Link;
import util.Text;

public class PrivacyPolicyPage {

    private Container languageList = new Container(By.id("languages"));
    private Text revisionDate = new Text(By.xpath("//*[@id='main']//*[contains(text(), '2023')]"));

    JsonArray testData = DataReader.readTestData();
    JsonObject dataJson = testData.get(0).getAsJsonObject();
    JsonArray languageArrayData = dataJson.get("languages").getAsJsonArray();
    String revisionDateData = dataJson.get("revisionDate").getAsString();

    public String getRevisionDate() {
        return revisionDate.getText();
    }

    public boolean isPrivacyPageOpened() {
        return languageList.isDisplayed();
    }

    public boolean isLanguageListDisplayed() {
        return languageList.isDisplayed();
    }

    public boolean isLanguageListComplete() {
        for (JsonElement language : languageArrayData) {
            Link img = new Link(By.xpath("//a[contains(@href, " + language + ")]//img"));
            img.click(); // throws exception if it doesn't find the element
        }
        return true;
    }

    public boolean isPrivacySignedCorrectly() {
        for (JsonElement language : languageArrayData) {
            Link img = new Link(By.xpath("//a[contains(@href, " + language + ")]//img"));
            img.click();

            if(!revisionDate.getText().contains(revisionDateData)) {
                return false;
            }
        }
        return true;
    }
}