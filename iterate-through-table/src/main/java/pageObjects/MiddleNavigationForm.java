package pageObjects;

import org.openqa.selenium.By;
import utils.Browser;
import utils.Identifier;
import utils.Link;
import utils.WaitUtils;

public class MiddleNavigationForm extends BaseForm {

    private Link mostPlayed = new Link(By.xpath("//*[@id='noteworthy_flyout']//*[@class='popup_menu_item'][2]"));
    By noteworthyTabBy = By.id("noteworthy_tab");
    By noteworthyFlyoutBy = By.xpath("//*[@id='noteworthy_flyout']");

    public MiddleNavigationForm() {
        super(new Identifier(By.id("store_nav_area")));
    }

    public void clickMostPlayed() {
        Browser.moveToElement(noteworthyTabBy);
        WaitUtils.waitForElementToAppear(noteworthyFlyoutBy);
        mostPlayed.click();
    }
}
