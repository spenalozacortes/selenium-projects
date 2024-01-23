package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    static ConfigReader configReader = new ConfigReader();
    static int defaultDuration = configReader.getWait();

    public static void waitForElementToAppear(By findBy, int duration) {
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public static void waitForElementToDisappear(By findBy, int duration) {
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
    }

    public static void waitForElementToAppear(By findBy) {
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(defaultDuration));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public static void waitForElementToDisappear(By findBy) {
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), Duration.ofSeconds(defaultDuration));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
    }
}