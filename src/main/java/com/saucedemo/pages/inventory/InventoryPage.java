package com.saucedemo.pages.inventory;

import com.saucedemo.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BasePage {

    @FindBy(id = "shopping_cart_container")
    WebElement cart;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void addItemToCart(String itemName) {
        WebElement addButton = driver.findElement(By.xpath("//*[text()='" + itemName + "']/../../../div/button"));
        waitForElementToBeVisible(addButton);
        addButton.click();

    }

    public void goToCart(){
        waitForElementToBeVisible(cart);
        cart.click();
    }

    public int getShoppingCartBadgeTotalItems(){
        return driver.findElements(By.xpath("//span[@class='shopping_cart_badge']")).size();
    }

}
