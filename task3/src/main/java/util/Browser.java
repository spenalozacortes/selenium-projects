package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
}