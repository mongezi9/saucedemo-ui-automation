package com.saucedemo.pages.checkout;

import com.saucedemo.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutStepOnePage extends BasePage {

    @FindBy(id = "continue")
    WebElement btnContinue;

    @FindBy(id = "first-name")
    WebElement firstNameField;

    @FindBy(id = "last-name")
    WebElement lastNameField;

    @FindBy(id = "postal-code")
    WebElement postalCodeField;

    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName(String fname){
        waitForElementToBeVisible(firstNameField);
        firstNameField.sendKeys(fname);
    }

    public void enterLastName(String lname){
        waitForElementToBeVisible(lastNameField);
        lastNameField.sendKeys(lname);
    }

    public void enterPostalCodeField(String postalCode){
        waitForElementToBeVisible(postalCodeField);
        postalCodeField.sendKeys(postalCode);
    }

    public void clickContinue(){
        waitForElementToBeVisible(btnContinue);
        btnContinue.click();
    }

}
