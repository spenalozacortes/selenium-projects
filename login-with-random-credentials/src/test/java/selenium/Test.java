package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import util.RandomUtils;

public class Test {
    public static void main(String[] args) {
        // Set up driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Load web page
        driver.get("http://uitestingplayground.com/sampleapp");

        // Sample App page is displayed
        WebElement pageName = driver.findElement(By.xpath("//div[@class='container']//*[text()='Sample App']"));
        Assert.assertTrue(pageName.isDisplayed(), "Sample App page is not displayed!");

        // Send values to fields
        String randomUsername = RandomUtils.generateRandomString(6);
        WebElement loginField = driver.findElement(By.xpath("//input[@name='UserName']"));
        loginField.sendKeys(randomUsername);
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='Password']"));
        passwordField.sendKeys("pwd");

        // Click button and check welcome message
        WebElement button = driver.findElement(By.id("login"));
        button.click();
        WebElement message = driver.findElement(By.id("loginstatus"));
        String actualMessage = message.getText();
        String expectedMessage = "Welcome, " + randomUsername + "!";
        Assert.assertEquals(actualMessage, expectedMessage, "Welcome message is incorrect!");

        // Click button and check log out message
        button.click();
        actualMessage = message.getText();
        expectedMessage = "User logged out.";
        Assert.assertEquals(actualMessage, expectedMessage, "Log out message is incorrect!");

        // Close browser
        driver.quit();
    }
}