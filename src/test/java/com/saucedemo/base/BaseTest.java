package com.saucedemo.base;

import com.saucedemo.util.AssertUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected AssertUtils assertUtils;

    @BeforeMethod
    @Parameters({"browser", "url"})
    public void setUp(String browser, String url) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/com/saucedemo/chromedriver");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/com/saucedemo/chromedriver");
            driver = new FirefoxDriver();
        }

        assertUtils = new AssertUtils(driver,  Duration.ofSeconds(60));
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
