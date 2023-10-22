package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.BaseElement;
import util.Browser;

import java.time.Duration;

public class LoginPage {

    private BaseElement loginButton = new BaseElement(By.xpath("//button[@type='submit']"));
    private BaseElement usernameField = new BaseElement(By.xpath("//input[@type='text']"));
    private BaseElement passwordField = new BaseElement(By.xpath("//input[@type='password']"));
    private BaseElement spinner = new BaseElement(By.xpath("//*[contains(@class,'LoadingSpinner')]"));
    private BaseElement errorText = new BaseElement(By.xpath("//*[contains(@class,'FormError')]"));

    WebDriverWait wait;

    public LoginPage() {
        wait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(5));
    }

    public boolean isLoginPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(@class,'LoadingSpinner')]")));
        String actualMessage = errorText.getText();
        return actualMessage.equals(expectedMessage);
    }
}
