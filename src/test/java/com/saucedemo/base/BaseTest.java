package com.saucedemo.base;

import com.saucedemo.util.AssertUtils;
import com.saucedemo.util.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected AssertUtils assertUtils;
    protected Utility utility = new Utility();
    protected String browser;
    protected String url;

    public BaseTest(){
        utility.propertyInit();
        browser = utility.getProperty("BROWSER");
        url = utility.getProperty("URL");
    }

    public void setUp() {

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/com/saucedemo/chromedriver");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/com/saucedemo/chromedriver");
            driver = new FirefoxDriver();
        }

        assertUtils = new AssertUtils(driver,  Duration.ofSeconds(60));
        driver.manage().window().maximize();
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
