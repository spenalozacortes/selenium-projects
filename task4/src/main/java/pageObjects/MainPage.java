package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utils.Browser;
import utils.Container;
import utils.Link;
import utils.WaitUtils;

public class MainPage {
    private Container homePageContent = new Container(By.cssSelector(".home_page_content"));
    private Link mostPlayed = new Link(By.xpath("//*[@id='noteworthy_flyout']//*[@class='popup_menu_item'][2]"));
    By noteworthyTabBy = By.id("noteworthy_tab");
    By noteworthyFlyoutBy = By.xpath("//*[@id='noteworthy_flyout']");

    public boolean isMainPageOpened() {
        return homePageContent.isDisplayed();
    }

    public void clickMostPlayed() {
        Actions a = new Actions(Browser.getDriver());
        a.moveToElement(Browser.getDriver().findElement(noteworthyTabBy)).build().perform();
        WaitUtils.waitForElementToAppear(noteworthyFlyoutBy, 5);
        mostPlayed.click();
    }
}
