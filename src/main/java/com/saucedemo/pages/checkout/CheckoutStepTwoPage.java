package com.saucedemo.pages.checkout;

import com.saucedemo.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutStepTwoPage extends BasePage {

    @FindBy(className = "inventory_item_name")
    WebElement itemTitle;

    @FindBy(className = "inventory_item_desc")
    WebElement itemDescription;

    @FindBy(className = "summary_subtotal_label")
    WebElement lblItemTotal;

    @FindBy(className = "summary_tax_label")
    WebElement tax;

    @FindBy(className = "summary_total_label")
    WebElement total;

    @FindBy(id = "finish")
    WebElement finishButton;

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle(){

        return itemTitle.getText();
    }

    public String getItemDescription(){

        return itemDescription.getText();
    }

    public String getItemTotal(){
        //TODO: Add regex to get the total
        return lblItemTotal.getText();
    }

    public String getTax(){
        //TODO: Add regex to get the tax
        return tax.getText();
    }

    public String getTotal(){
        //TODO: Add regex to get the total
        return total.getText();
    }

    public void clickFinish(){
        waitForElementToBeVisible(finishButton);
        finishButton.click();
    }

}
