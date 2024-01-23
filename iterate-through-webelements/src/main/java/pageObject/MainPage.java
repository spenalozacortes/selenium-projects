package pageObject;

import org.openqa.selenium.By;
import util.Browser;
import util.Link;

public class MainPage {
    private Link privacyLink = new Link(By.cssSelector("#footer_text a[href*=privacy_agreement]"));

    public void clickPrivacyLink() {
        privacyLink.click();

        // Switches to new tab
        Browser.switchTab();
    }
}
