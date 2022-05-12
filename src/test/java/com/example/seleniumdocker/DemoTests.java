package com.example.seleniumdocker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DemoTests {

    WebDriver driver;
    private static final String APP_URL = "https://qa-automation-practice.netlify.app/";
    private static final String HOST_URL = "http://localhost:4444/wd/hub";

    @BeforeEach
    public void setUp() {
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--verbose");
        try {
            driver = new RemoteWebDriver(new URL(HOST_URL), opt);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(APP_URL);
    }

    @Test
    public void assertTitle() {

        Assertions.assertTrue(driver.getTitle().contains("Learn"));
    }

    @AfterEach
    public void tearDown() {
        if(driver != null) driver.quit();
    }
}
