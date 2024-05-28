package com.saucedemo.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.saucedemo.pages.base.BasePage;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='user-name']")
    WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//input[@id='login-button']")
    WebElement btnLogin;

    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement error;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String strUsername) {
        waitForElementToBeVisible(username);
        username.sendKeys(strUsername);
    }

    public void enterPassword(String strPassword) {
        waitForElementToBeVisible(password);
        password.sendKeys(strPassword);
    }

    public void clickLoginButton() {
        btnLogin.click();
    }

    public String getErrorMessage() {
        return error.getText();
    }

    public boolean isErrorMessageDisplayed() {
        return isElementDisplayed(error);
    }
}
