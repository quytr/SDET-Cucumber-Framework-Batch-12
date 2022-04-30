Feature: Validation of Login scenarios

  @smoke
  Scenario: Admin Login
    Given user is navigated to HRMS application
    When user enters valid admin credentials
    And clicks on login button
    Then admin user is successfully logged in

  @regression
  Scenario: ESS Login
    Given user is navigated to HRMS application
    When user enters valid ESS username and password
    And clicks on login button
    Then ESS user is successfully logged in

  @regression
  Scenario: Invalid Login
    Given user is navigated to HRMS application
    When user enters invalid username and password
    And clicks on login button
    Then user sees error message on the screen
