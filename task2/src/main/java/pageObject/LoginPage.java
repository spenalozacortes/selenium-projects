package pageObject;

import org.openqa.selenium.By;
import util.BaseElement;
import util.WaitUtils;

public class LoginPage {

    By loginButtonBy = By.xpath("//button[@type='submit']");
    By spinnerBy = By.xpath("//*[contains(@class,'LoadingSpinner')]");
    private BaseElement loginButton = new BaseElement(loginButtonBy);
    private BaseElement usernameField = new BaseElement(By.xpath("//input[@type='text']"));
    private BaseElement passwordField = new BaseElement(By.xpath("//input[@type='password']"));
    private BaseElement spinner = new BaseElement(spinnerBy);
    private BaseElement errorText = new BaseElement(By.xpath("//*[contains(@class,'FormError')]"));

    public BaseElement getSpinner() {
        WaitUtils.waitForElementToAppear(spinnerBy, 5);
        return spinner;
    }

    public BaseElement getErrorText() {
        WaitUtils.waitForElementToDisappear(spinnerBy, 5);
        return errorText;
    }

    public boolean isLoginPageOpened() {
        WaitUtils.waitForElementToAppear(loginButtonBy, 5);
        return loginButton.isDisplayed();
    }

    public void login(String userName, String password) {
        usernameField.sendKeys(userName);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}