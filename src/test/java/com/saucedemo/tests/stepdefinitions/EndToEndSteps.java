package com.saucedemo.tests.stepdefinitions;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.cart.CartPage;
import com.saucedemo.pages.checkout.CheckoutCompletePage;
import com.saucedemo.pages.checkout.CheckoutStepOnePage;
import com.saucedemo.pages.checkout.CheckoutStepTwoPage;
import com.saucedemo.pages.inventory.InventoryPage;
import com.saucedemo.pages.login.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class EndToEndSteps extends BaseTest {
        LoginPage loginPage;
        InventoryPage inventoryPage;
        CartPage cartPage;
        CheckoutStepOnePage checkoutStepOnePage;
        CheckoutStepTwoPage checkoutStepTwoPage;
        CheckoutCompletePage checkoutCompletePage;

        @Before
        public void setUpScenario() {
                setUp();
                loginPage = new LoginPage(driver);
                inventoryPage = new InventoryPage(driver);
                cartPage = new CartPage(driver);
                checkoutStepOnePage = new CheckoutStepOnePage(driver);
                checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
                checkoutCompletePage = new CheckoutCompletePage(driver);
        }

        @After
        public void tearDownScenario() {
                tearDown();
        }

        @Given("I launch the Saucedemo login page")
        public void launchSaucedemoLoginPage() {
                driver.get(url);
        }

        @When("I input username {string} and password {string}")
        public void enterUsernameAndPassword(String username, String password) {
                loginPage.enterUsername(username);
                loginPage.enterPassword(password);
        }

        @When("I click login button")
        public void clickTheLoginButton() {
                loginPage.clickLoginButton();
        }

        @Then("I should be redirected to the inventory page")
        public void verifyLandingPage() {
                assertUtils.assertUrlContains("/inventory.html", "Login was successful and redirected to inventory page.");
        }

        @When("I add {string} to the cart")
        public void addToTheCart(String itemName) {
                inventoryPage.addItemToCart(itemName);
        }

        @When("I go to the cart")
        public void goToTheCart() {
                inventoryPage.goToCart();
        }

        @Then("I should see {int} item in the cart")
        public void itemInTheCart(int itemCount) {
                Assert.assertEquals(cartPage.getTotalItemsOnCart(), itemCount);
        }

        @When("I proceed to checkout")
        public void proceedToCheckout() {
                cartPage.clickCheckout();
        }

        @When("I enter first name {string}, last name {string}, and postal code {string}")
        public void enterShippingDetails(String firstName, String lastName, String postalCode) {
                checkoutStepOnePage.enterFirstName(firstName);
                checkoutStepOnePage.enterLastName(lastName);
                checkoutStepOnePage.enterPostalCodeField(postalCode);
        }

        @When("I continue to the next checkout step")
        public void continueToCheckout() {
                checkoutStepOnePage.clickContinue();
        }

        @Then("I should see the item details for {string}")
        public void checkItemDetails(String itemName) {
                String expectDescription = "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.";

                Assert.assertTrue(checkoutStepTwoPage.getTitle().contains(itemName));
                Assert.assertTrue(checkoutStepTwoPage.getItemDescription().contains(expectDescription));
                Assert.assertTrue(checkoutStepTwoPage.getItemTotal().contains("Item total"));
                Assert.assertTrue(checkoutStepTwoPage.getTax().contains("Tax"));
                Assert.assertTrue(checkoutStepTwoPage.getTotal().contains("Total"));
        }

        @When("I finish the checkout process")
        public void clickFinishCheckoutProcess() {
                checkoutStepTwoPage.clickFinish();
        }

        @Then("I should see a confirmation message {string}")
        public void verifyConfirmationMessage(String message) {
                Assert.assertTrue(checkoutCompletePage.getOrderSuccessful().contains(message));
                checkoutCompletePage.clickBackHome();
        }

        @Then("the cart should be empty")
        public void verifyEmptyCart() {
                Assert.assertEquals(inventoryPage.getShoppingCartBadgeTotalItems(), 0);
        }
}
