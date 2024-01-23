package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Browser {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        ConfigReader configReader = new ConfigReader();
        String browser = configReader.getBrowser();

        if (driver == null) {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } // ... logic for other browsers
        }
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
        driver = null;
    }

    public static void switchTab() {
        String firstWindow = getDriver().getWindowHandle();
        Set<String> allWindows = getDriver().getWindowHandles();
        allWindows.remove(firstWindow);
        getDriver().switchTo().window(allWindows.iterator().next());
    }
}