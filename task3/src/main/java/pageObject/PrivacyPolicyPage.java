package pageObject;

import org.openqa.selenium.By;
import util.BaseElement;

public class PrivacyPolicyPage {

    private BaseElement privacyImg = new BaseElement(By.cssSelector("img[src*='title_privacy']"));
    private BaseElement languageList = new BaseElement(By.id("languages"));
    private BaseElement revisionDate = new BaseElement(By.xpath("//*[@id='newsColumn']//*[contains(text(), '2023')]"));

    public String getRevisionDate() {
        return revisionDate.getText();
    }

    public boolean isPrivacyPageOpened() {
        return privacyImg.isDisplayed();
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