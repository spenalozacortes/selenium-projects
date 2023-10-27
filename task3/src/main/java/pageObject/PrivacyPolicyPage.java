package pageObject;

import org.openqa.selenium.By;
import util.BaseElement;
import util.Container;
import util.Text;

public class PrivacyPolicyPage {

    private Container languageList = new Container(By.id("languages"));
    private Text revisionDate = new Text(By.xpath("//*[@id='newsColumn']//*[contains(text(), '2023')]"));

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
        String[] languagesNeeded = {"english", "spanish", "french", "german", "italian", "russian", "japanese", "portuguese", "brazilian"};

        for(String language : languagesNeeded) {
            try {
                BaseElement img = new BaseElement(By.xpath("//a[contains(@href, '" + language + "')]//img"));
                img.click();
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }
}