package com.saucedemo.pages.cart;

import com.saucedemo.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(id = "checkout")
    WebElement checkout;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public int getTotalItemsOnCart() {
        List<WebElement> itemCount = driver.findElements(By.className("cart_item"));
        return itemCount.size();

    }

    public void clickCheckout(){
        waitForElementToBeVisible(checkout);
        checkout.click();
    }

}
