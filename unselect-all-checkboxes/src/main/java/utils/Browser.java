package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        ConfigReader configReader = new ConfigReader();
        String browser = configReader.getBrowser();

        if (driver == null) {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--lang=en-US");
                driver = new ChromeDriver(options);
            } // ... logic for other browsers
        }
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
        driver = null;
    }
}