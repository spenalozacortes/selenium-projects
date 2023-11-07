package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Browser;
import utils.ConfigReader;

public class Tests {

    @BeforeMethod
    public void setup() {
        ConfigReader configReader = new ConfigReader();
        Browser.getDriver().get(configReader.getBaseUrl());
        Browser.getDriver().manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        Browser.quitDriver();
    }

    @Test
    public void test() {
        System.out.println("Hola");
    }
}
