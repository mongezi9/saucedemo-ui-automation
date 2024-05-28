package com.saucedemo.pages.base;

import com.saucedemo.util.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class BasePage extends WaitUtils {

	public BasePage(WebDriver driver) {
		super(driver, Duration.ofSeconds(60));
	}

	protected WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	protected void click(WebElement element) {
		waitForElementClickable(element).click();
	}

	protected void type(WebElement element, String text) {
	    waitForElementToBeVisible(element);
		element.clear();
		element.sendKeys(text);
	}

	protected String getText(WebElement element) {
		return waitForElementToBeVisible(element).getText();
	}

	protected boolean isElementDisplayed(WebElement element) {
		try {
			return waitForElementToBeVisible(element).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	protected void navigateTo(String url) {
		driver.get(url);
	}
}