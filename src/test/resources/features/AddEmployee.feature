Feature: Add Employee to HRMS

  Background:
    Given admin user is logged into HRMS
    And admin navigates to Add Employee page

  @employee
  Scenario: Add employee without providing employee ID
    When admin enters first name "John"
    And admin enters middle name "Michael"
    And admin enters last name "Smith"
    And admin saves the employee
    Then employee should be added successfully
    And employee ID should be generated automatically
    And employee record should exist in database

  @employee
  Scenario: Add employee with employee ID
    When admin enters first name "David"
    And admin enters middle name "A"
    And admin enters last name "Brown"
    And admin enters employee ID "900123"
    And admin saves the employee
    Then employee should be added successfully


  @employee
  Scenario: Add employee with missing required fields
    When admin saves the employee
    Then required error messages should be displayed