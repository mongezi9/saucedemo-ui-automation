@EndToEndTest
Feature: End to End Test

  Scenario: As a user, I want to be able to log in, add an item to the cart, proceed to checkout, and successfully complete an order.
    Given I launch the Saucedemo login page
    When I input username "standard_user" and password "secret_sauce"
    And I click login button
    Then I should be redirected to the inventory page

    When I add "Sauce Labs Fleece Jacket" to the cart
    And I go to the cart
    Then I should see 1 item in the cart

    When I proceed to checkout
    And I enter first name "Mongezi", last name "Mthi", and postal code "1234"
    And I continue to the next checkout step
    Then I should see the item details for "Sauce Labs Fleece Jacket"

    When I finish the checkout process
    Then I should see a confirmation message "Thank you for your order!"
    And the cart should be empty