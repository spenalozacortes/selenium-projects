package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Test {
    public static void main(String[] args) {
        // Set up driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Load web page
        driver.get("http://uitestingplayground.com/sampleapp");

        // Send values to fields
        String username = "stephanie";
        WebElement loginField = driver.findElement(By.xpath("//input[@name='UserName']"));
        loginField.sendKeys(username);
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='Password']"));
        passwordField.sendKeys("pwd");

        // Click button and check welcome message
        WebElement button = driver.findElement(By.id("login"));
        button.click();
        WebElement message = driver.findElement(By.id("loginstatus"));
        String actualMessage = message.getText();
        String expectedMessage = "Welcome, " + username + "!";
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