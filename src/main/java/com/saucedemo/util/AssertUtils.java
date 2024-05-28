package com.saucedemo.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;

public class AssertUtils {
    private WebDriver driver;
    private WaitUtils waitUtils;

    public AssertUtils(WebDriver driver, Duration timeout) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver, timeout);
    }

    public void assertElementIsClickable(WebElement element, String message) {
        try {
            waitUtils.waitForElementClickable(element);
            Assert.assertTrue(true, message);
        } catch (Exception e) {
            Assert.fail(message + " - Element is not clickable: " + element.getText());
        }
    }

    public void assertElementIsVisible(WebElement element, String message) {
        try {
            waitUtils.waitForElementToBeVisible(element);
            Assert.assertTrue(true, message);
        } catch (Exception e) {
            Assert.fail(message + " - Element is not visible: " + element.getText());
        }
    }

    public void assertTextIsPresentInElement(WebElement element, String text, String message) {
        try {
            boolean isTextPresent = waitUtils.waitForTextToBePresentInElement(element, text);
            Assert.assertTrue(isTextPresent, message);
        } catch (Exception e) {
            Assert.fail(message + " - Text '" + text + "' not present in element: " + element.getText());
        }
    }

    public void assertUrlContains(String fraction, String message) {
        try {
            boolean isUrlContains = waitUtils.waitForUrlToContain(fraction);
            Assert.assertTrue(isUrlContains, message);
        } catch (Exception e) {
            Assert.fail(message + " - URL does not contain: " + fraction);
        }
    }

    public void assertElementIsInvisible(WebElement locator, String message) {
        try {
            boolean isElementInvisible = waitUtils.waitForElementToBeInvisible(locator);
            Assert.assertTrue(isElementInvisible, message);
        } catch (Exception e) {
            Assert.fail(message + " - Element is not invisible: " + locator);
        }
    }
}