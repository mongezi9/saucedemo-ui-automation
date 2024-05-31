package com.saucedemo.tests.stepdefinitions;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.login.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class LoginSteps extends BaseTest {
        LoginPage loginPage;

        @Before
        public void setUpScenario() {
                setUp();
                loginPage = new LoginPage(driver);
        }

        @After
        public void tearDownScenario() {
                tearDown();
        }

        @Given("I open the Saucedemo login page")
        public void iOpenTheSaucedemoLoginPage() {
                driver.get(url);
        }

        @When("I enter username {string} and password {string}")
        public void iEnterUsernameAndPassword(String username, String password) {
                loginPage.enterUsername(username);
                loginPage.enterPassword(password);
        }

        @When("I click the login button")
        public void iClickTheLoginButton() {
                loginPage.clickLoginButton();
        }

        @Then("I should be logged in successfully")
        public void iShouldBeLoggedInSuccessfully() {
                assertUtils.assertUrlContains("/inventory.html", "Login was successful and redirected to inventory page.");
        }

        @Then("I should see {string}")
        public void iShouldSee(String result) {
                if (result.equals("success")) {
                        assertUtils.assertUrlContains("/inventory.html", "Login was successful and redirected to inventory page.");
                } else {
                        Assert.assertEquals(loginPage.getErrorMessage(), result);
                }
        }
}
