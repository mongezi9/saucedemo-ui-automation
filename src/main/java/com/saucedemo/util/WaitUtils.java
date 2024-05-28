package com.saucedemo.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class WaitUtils {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public WaitUtils(WebDriver driver, Duration timeout) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeout.getSeconds());
    }

    protected WebElement waitForElementClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean waitForTextToBePresentInElement(WebElement element, String text) {
        return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public boolean waitForUrlToContain(String fraction) {
        return wait.until(ExpectedConditions.urlContains(fraction));
    }

    public boolean waitForElementToBeInvisible(WebElement element) {
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public WebElement waitForElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}