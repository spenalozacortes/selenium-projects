package util;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    public static void waitForElementToAppear(By findBy, int duration) {
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public static void waitForElementToDisappear(By findBy, int duration) {
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
    }
}
