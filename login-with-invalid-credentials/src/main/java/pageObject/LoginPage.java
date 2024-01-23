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

    public void setUsernameField(String userName) {
        usernameField.sendKeys(userName);
    }

    public void setPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean isLoginPageOpened() {
        WaitUtils.waitForElementToAppear(loginButtonBy, 5);
        return loginButton.isDisplayed();
    }

    public boolean isSpinnerDisplayed() {
        WaitUtils.waitForElementToAppear(spinnerBy, 5);
        return spinner.isDisplayed();
    }

    public boolean isErrorMessageDisplayed() {
        WaitUtils.waitForElementToDisappear(spinnerBy, 5);
        return errorText.isDisplayed();
    }
}