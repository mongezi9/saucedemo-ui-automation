package com.saucedemo.e2e;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.cart.CartPage;
import com.saucedemo.pages.checkout.CheckoutCompletePage;
import com.saucedemo.pages.checkout.CheckoutStepOnePage;
import com.saucedemo.pages.checkout.CheckoutStepTwoPage;
import com.saucedemo.pages.inventory.InventoryPage;
import com.saucedemo.pages.login.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EndToEndTest extends BaseTest {

    @Test(description = "As a user, I want to be able to log in, add an item to the cart, proceed to checkout, " +
            "and successfully complete an order.")
    public void testEndToEnd() {
        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        assertUtils.assertUrlContains("/inventory.html", "Login was successful and redirected to inventory page.");

        // Add item to cart
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addItemToCart("Sauce Labs Fleece Jacket");
        inventoryPage.goToCart();


        // Go to cart
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getTotalItemsOnCart(), 1, "Success only 1 item added on cart");
        cartPage.clickCheckout();

        // Enter user details
        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepOnePage.enterFirstName("Mongezi");
        checkoutStepOnePage.enterLastName("Mthi");
        checkoutStepOnePage.enterPostalCodeField("1234");
        checkoutStepOnePage.clickContinue();


        // Verify total and items
        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        String expectDescription = "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.";
        Assert.assertTrue(checkoutStepTwoPage.getTitle().contains("Sauce Labs Fleece Jacket"));
        Assert.assertTrue(checkoutStepTwoPage.getItemDescription().contains(expectDescription));
        Assert.assertTrue(checkoutStepTwoPage.getItemTotal().contains("Item total"));
        Assert.assertTrue(checkoutStepTwoPage.getTax().contains("Tax"));
        Assert.assertTrue(checkoutStepTwoPage.getTotal().contains("Total"));
        checkoutStepTwoPage.clickFinish();

        // Verify successful order
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        Assert.assertTrue(checkoutCompletePage.getOrderSuccessful().contains("Thank you for your order!"));
        checkoutCompletePage.clickBackHome();

        //Assert after successfully making an order, it should clear cart items
        Assert.assertEquals(inventoryPage.getShoppingCartBadgeTotalItems(), 0);
    }
}