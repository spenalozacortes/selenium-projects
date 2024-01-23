package pageObject;

import org.openqa.selenium.By;
import util.BaseElement;

public class MainPage {

    private BaseElement homePageContent = new BaseElement(By.cssSelector(".home_page_content"));
    private BaseElement loginLink = new BaseElement(By.cssSelector("a.global_action_link"));

    public boolean isMainPageOpened() {
        return homePageContent.isDisplayed();
    }

    public void clickLoginLink() {
        loginLink.click();
    }
}
