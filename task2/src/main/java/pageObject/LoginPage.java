package pageObject;

import org.openqa.selenium.By;
import util.BaseElement;

public class LoginPage {

    private BaseElement loginButton = new BaseElement(By.xpath("//button[@type='submit']"));
    private BaseElement usernameField = new BaseElement(By.xpath("//input[@type='text']"));
    private BaseElement passwordField = new BaseElement(By.xpath("//input[@type='password']"));
    private BaseElement spinner = new BaseElement(By.xpath("//*[contains(@class,'LoadingSpinner')]"));
    private BaseElement errorText = new BaseElement(By.xpath("//*[contains(@class,'FormError')]"));

    public boolean isLoginPageOpened() {
        return loginButton.isDisplayed();
    }

    public void setUsernameField(String userName) {
        usernameField.sendKeys(userName);
    }

    public void setPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean isSpinnerDisplayed() {
        return spinner.isDisplayed();
    }

    public boolean isErrorTextCorrect(String expectedMessage) {
        String actualMessage = errorText.getText();
        return actualMessage.equals(expectedMessage);
    }
}
