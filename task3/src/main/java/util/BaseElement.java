package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseElement {
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
        return getElement().isDisplayed();
    }

    public void sendKeys(String text) {
        getElement().sendKeys(text);
    }

    protected WebElement getElement() {
        return Browser.getDriver().findElement(locator);
    }
}