Feature: Login
  As user, I want to be able to login with username and password

  @sales_manager
  Scenario: Login as sales manager and verify that title is dashboard
    Given user is on the login page
    When user logs in as a sales manager
    Then user should verify that title is Dashboard

  @store_manager
  Scenario: Login as store manager and verify that title is dashboard
    Given user is on the login page
    When user logs in as a store manager
    Then user should verify that title is Dashboard

  @driver
  Scenario: Login as driver and verify that title is Dashboard
    Given user is on the login page
    When user logs in as a driver
    Then user should verify that title is Dashboard