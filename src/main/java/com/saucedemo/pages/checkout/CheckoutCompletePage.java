package com.saucedemo.pages.checkout;

import com.saucedemo.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CheckoutCompletePage extends BasePage {

    @FindBy(className = "complete-header")
    WebElement successfulOrder;

    @FindBy(id="back-to-products")
    WebElement backHome;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public String getOrderSuccessful(){
        return successfulOrder.getText();

    }

    public void clickBackHome(){
        waitForElementToBeVisible(backHome);
        backHome.click();
    }

}
