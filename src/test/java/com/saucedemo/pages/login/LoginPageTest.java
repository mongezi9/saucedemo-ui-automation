package com.saucedemo.pages.login;

import com.saucedemo.base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {


    @DataProvider(name = "positiveLoginData")
    public Object[][] positiveLoginDataProvider() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
                {"error_user", "secret_sauce"},
                {"visual_user", "secret_sauce"}
        };
    }

    @DataProvider(name = "negativeLoginData")
    public Object[][] negativeLoginDataProvider() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"username", "password", "Epic sadface: Username and password do not match any user in this service"},
                {"", "", "Epic sadface: Username is required"}
        };
    }
    @Test(dataProvider = "positiveLoginData",
            description = "As a user, I want to be able to successfully log in with different user accounts.")
    public void testValidLogin(String strUsername, String strPassword) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(strUsername);
        loginPage.enterPassword(strPassword);
        loginPage.clickLoginButton();

        assertUtils.assertUrlContains("/inventory.html", "Login was successful and redirected to inventory page.");

    }

    @Test(dataProvider = "negativeLoginData",
            description = "As a user, I want to ensure that I cannot log in with invalid test data.")
    public void testInvalidLogin(String strUsername, String strPassword, String errMessage){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(strUsername);
        loginPage.enterPassword(strPassword);
        loginPage.clickLoginButton();

        // Verify the error message is displayed
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message is displayed for missing username.");
        Assert.assertEquals(loginPage.getErrorMessage(), errMessage);
    }
}