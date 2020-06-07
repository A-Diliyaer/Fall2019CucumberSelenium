@view_calendar_events
Feature: View all calendar events
  As user, i want to be able to see all calendar events as a table

  Scenario: User premissions
    Given user is on the login page
    When user logs in as a sales manager
    When user navigates to "Activities" and "Calendar Events"
    Then View Per Page menu should have following options
      |10 |
      |25 |
      |50 |
      |100 |