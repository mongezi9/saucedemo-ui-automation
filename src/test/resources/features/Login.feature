@LoginTest
Feature: Login feature

    Scenario Outline: Login scenario
        Given I open the Saucedemo login page
        When I enter username "<username>" and password "<password>"
        And I click the login button
        Then I should see "<result>"

        Examples:
            | username                | password     | result                    |
            | standard_user           | secret_sauce | success                   |
            | problem_user            | secret_sauce | success                   |
            | performance_glitch_user | secret_sauce | success                   |
            | invalid_user            | secret_sauce | error message "Username and password do not match any user in this service" |
            | standard_user           | wrong_pass   | error message "Username and password do not match any user in this service" |
            |                        | secret_sauce | error message "Username is required" |
            | standard_user           |              | error message "Password is required" |