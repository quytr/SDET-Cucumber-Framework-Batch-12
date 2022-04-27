Feature: US-12345 Search an employee in HRMS
  Scenario: Search an employee by ID
    * user is navigated to HRMS application
    * user enters valid admin credentials
    * clicks on login button
    * navigates to employee list page
    * user enters valid employee ID
    * clicks on search button
    * user is able to see employee information

  Scenario: Search an employee by name
    Given user is navigated to HRMS application
    When user enters valid admin credentials
    And clicks on login button
    And navigates to employee list page
    When user enters valid employee name
    And clicks on search button
    Then user is able to see employee information

