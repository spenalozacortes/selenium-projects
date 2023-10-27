package pageObject;

import org.openqa.selenium.By;

import util.Browser;
import util.Link;

import java.util.Set;

public class MainPage {
    private Link privacyLink = new Link(By.cssSelector("#footer_text a[href*=privacy_agreement]"));

    public void clickPrivacyLink() {
        privacyLink.click();

        // Switches to new tab
        String firstWindow = Browser.getDriver().getWindowHandle();
        Set<String> allWindows = Browser.getDriver().getWindowHandles(); // order of handles in set is arbitrary
        allWindows.remove(firstWindow);
        Browser.getDriver().switchTo().window(allWindows.iterator().next());
    }
}
