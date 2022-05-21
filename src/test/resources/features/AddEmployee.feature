Feature: Adding the employees in HRMS Application

  Background:
    When user enters valid admin credentials
    And clicks on login button
    Then admin user is successfully logged in
    When user clicks on PIM option
    And user clicks on add employee option

  @regression @safiul
  Scenario: Adding one employee from feature file
    #Given user is navigated to HRMS application
    And user enters firstName middleName and lastName
    And user clicks on save button
    Then employee is added successfully

  @test123
  Scenario: Adding one employee using cucumber feature file
    And user enters "zuhoor" "Mujeed" and "Silvia"
    And user clicks on save button
    Then employee is added successfully

  @test
  Scenario Outline: Adding multiple employees
    And user provides "<firstName>" "<middleName>" and "<lastName>"
    And user clicks on save button
    Then employee is added successfully
    Examples:
    |firstName|middleName|lastName|
    |asel     |MS        |tolga   |
    |yazgul   |MS        |kishan  |
    |tarik    |MS        |mujeeb  |
    |nassir   |MS        |volkan  |

  @test @datatable
  Scenario: Add employee using data table
    When user provides multiple employees data and verify they are added
      |firstName|middleName|lastName|
      |asel     |MS        |tolga   |
      |yazgul   |MS        |kishan  |
      |tarik    |MS        |mujeeb  |

  @excel1
  Scenario: Adding multiple employees from excel file
    When user adds multiple employees from excel file using "EmployeeData" sheet and verify the employee added



