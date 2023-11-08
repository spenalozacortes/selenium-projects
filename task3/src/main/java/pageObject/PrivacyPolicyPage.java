package pageObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.openqa.selenium.By;
import util.Container;
import util.Link;
import util.Text;

public class PrivacyPolicyPage {

    private Container languageList = new Container(By.id("languages"));
    private Text revisionDate;

    public void setRevisionDateText(String revisionDate) {
        this.revisionDate = new Text(By.xpath("//*[@id='main']//*[contains(text(), '" + revisionDate + "')]"));
    }

    public String getRevisionDate() {
        return revisionDate.getText();
    }

    public boolean isPrivacyPageOpened() {
        return languageList.isDisplayed();
    }

    public boolean isLanguageListDisplayed() {
        return languageList.isDisplayed();
    }

    public boolean isLanguageListComplete(JsonArray languageArray) {
        for (JsonElement language : languageArray) {
            Link img = new Link(By.xpath("//a[contains(@href, " + language + ")]//img"));
            img.click(); // throws exception if it doesn't find the element
        }
        return true;
    }

    public boolean isPrivacySignedCorrectly(JsonArray languageArray, String revisionDateData) {
        for (JsonElement language : languageArray) {
            Link img = new Link(By.xpath("//a[contains(@href, " + language + ")]//img"));
            img.click();

            if(!revisionDate.getText().contains(revisionDateData)) {
                return false;
            }
        }
        return true;
    }
}