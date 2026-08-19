Feature: Login Validation for HRMS Portal


  @login
  Scenario: Login with empty username

    Given user is on the login page
    And user leaves username empty
    And user enters valid password
    When user clicks on login button
    Then user should see "Required" message for username


  @login
  Scenario: Login with empty password
    Given user is on the login page
    And user enters valid username
    And user leaves password empty
    When user clicks on login button
    Then user should see "Required" message for password


  @login
  Scenario: Login with incorrect credentials
    Given user is on the login page
    And user enters username "wrongUser"
    And user enters password "wrongPassword"
    When user clicks on login button
    Then user should see "Invalid credentials" message