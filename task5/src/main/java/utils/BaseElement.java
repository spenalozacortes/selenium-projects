package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class BaseElement {
    private By locator;

    public BaseElement(By locator) {
        this.locator = locator;
    }

    public void click() {
        getElement().click();
    }

    public String getText() {
        return getElement().getText();
    }

    public boolean isDisplayed() {
        WaitUtils.waitForElementToAppear(locator);
        return getElement().isDisplayed();
    }

    protected WebElement getElement() {
        return Browser.getDriver().findElement(locator);
    }
}