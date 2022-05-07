Feature: Validation of Login scenarios

  Background:
    #Given user is navigated to HRMS application


  @smoke @regression @batch12 @sprint12 @latest
  Scenario: Admin Login
    #Given user is navigated to HRMS application
    When user enters valid admin credentials
    And clicks on login button
    Then admin user is successfully logged in

  @regression @smoke @sprint12
  Scenario: ESS Login
    #Given user is navigated to HRMS application
    When user enters valid ESS username and password
    And clicks on login button
    Then ESS user is successfully logged in

  @regression @smoke
  Scenario: Invalid Login
    #Given user is navigated to HRMS application
    When user enters invalid username and password
    And clicks on login button
    Then user sees error message on the screen

  @hw
  Scenario: Login with empty username
    When user enters valid password and empty username
    And clicks on login button
    Then user sees error message on the screen

  @hw
  Scenario: Login with empty password
    When user enters valid username and empty password
    And clicks on login button
    Then user sees error message on the screen

  @hw
  Scenario: Login with invalid username
    When user enters valid password and invalid username
    And clicks on login button
    Then user sees error message on the screen

  @hw
  Scenario: Login with invalid password
    When user enters valid username and invalid password
    And clicks on login button
    Then user sees error message on the screen
