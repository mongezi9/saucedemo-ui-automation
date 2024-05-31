@LoginTest
Feature: Login feature

    Scenario Outline: Login scenario
        Given I open the Saucedemo login page
        When I enter username "<username>" and password "<password>"
        And I click the login button
        Then I should see "<result>"

        Examples:
            | username                | password     | result                                                      |
            | standard_user           | secret_sauce | success                                                     |
            | problem_user            | secret_sauce | success                                                     |
            | performance_glitch_user | secret_sauce | success                                                     |
            | error_user              | secret_sauce | success                                                     |
            | visual_user             | secret_sauce | success                                                     |
            | invalid_user            | secret_sauce | Username and password do not match any user in this service |
            | standard_user           | wrong_pass   | Username and password do not match any user in this service |
            |                         | secret_sauce | Username is required                                        |
            | standard_user           |              | Password is required                                        |
            | locked_out_user         | secret_sauce | Sorry, this user has been locked out.                       |