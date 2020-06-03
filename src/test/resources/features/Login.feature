Feature: Login
  As user, I want to be able to login with username and password

  Scenario: Login as sales manager and verify that title is dashboard
    Given user is on the landing page
    When user logs in as a sales manager
    Then user should verify that title is Dashboard


  Scenario: Login as store manager and verify that title is dashboard
    Given user is on the landing page
    When user logs in as a store manager
    Then user should verify that title is Dashboard

