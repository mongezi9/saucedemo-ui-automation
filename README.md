# Saucedemo UI Automation

## Overview

This Test Automation Framework is designed to automate the testing of the [Saucedemo website](https://www.saucedemo.com/) using a combination of Java, Selenium WebDriver, TestNG, Maven, and the Page Object Model (POM) design pattern. The primary goal is to create a maintainable, reusable, and readable codebase for web application testing.

## Project Structure

The project is structured as follows:

```console
saucedemo-ui-automation/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/saucedemo/pages/
│   │   └── resources/
│   ├── test/
│   │   ├── java/
│   │   │   └── com/saucedemo/tests/
│   │   └── resources/
├── pom.xml
├── JenkinsFile
├── README.md
└── testng.xml

```

* **src/main/java/com/saucedemo/pages/**: Contains the Page Object Model (POM) classes representing the web pages.
* **src/test/java/com/saucedemo/tests/**: Contains the TestNG test classes.
* **pom.xml**: Maven configuration file for managing dependencies.
* **testng.xml**: Configuration file for TestNG test suite.

## Prerequisites
To run this project, you need to have the following installed:

* Java Development Kit (JDK) 8 or higher
* Apache Maven
* An IDE like IntelliJ IDEA or Eclipse
* WebDriver for the browser you intend to test (ChromeDriver, GeckoDriver for Firefox, etc.)

## Setup Instructions

**1. Clone the repository:**

```console
git clone https://github.com/mongezi9/saucedemo-ui-automation.git
cd saucedemo-ui-automation
```
**2. Install dependencies:**

Run the following command in the project directory to download the necessary dependencies:

```console
mvn clean install
```

**3. Configure WebDriver:**

Ensure that the appropriate WebDriver executable is available in your system's PATH or specify its path in your test classes.

**4. Run the tests:**

You can run the tests using Maven or directly through your IDE. To run the tests using Maven, execute:

```console
mvn test
```

## Writing Tests
### Page Object Model (POM)
Create a separate Java class for each page of the Saucedemo website. For example, **LoginPage.java** might look like this:


```console
package com.saucedemo.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.saucedemo.pages.base.BasePage;
import org.openqa.selenium.support.PageFactory;

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
        //waitForElementToBeVisible(username);
        username.sendKeys(strUsername);
    }

    public void enterPassword(String strPassword) {
        waitForElementToBeVisible(password);
        password.sendKeys(strPassword);
    }

    public void clickLoginButton() {
        btnLogin.click();
    }

}

```

### Writing Test Cases
Create test classes under src/test/java/com/saucedemo/tests/. Here's an example test case for logging in:

```console
package com.saucedemo.pages.login;

import com.saucedemo.base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test(dataProvider = "test-data",
            description = "As as user I want to be able to successfully login with different users.")
    public void testValidLogin(String strUsername, String strUsername) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("strUsername");
        loginPage.enterPassword("strUsername");
        loginPage.clickLoginButton();

        assertUtils.assertUrlContains("/inventory.html", "Login was successful and redirected to inventory page.");

    }

}

```

## Refactoring Tests
Regularly refactor tests to improve readability and maintainability:

* Use descriptive method names and comments.
* Extract common setup or teardown code into utility methods.
* Use appropriate TestNG annotations for test configuration and data-driven testing.
