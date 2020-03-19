@web @darkSky
Feature: DarkSky feature

  Background:
    Given I am on dark sky homepage


  @Scenario-1-darkSkyCurrentTemp
  Scenario: Verify Current Temperature should not be greater or less than the Temperature from Daily Timeline
    Then I verify current temp is not greater or less then temps from daily timeline

  @dScenario-2-darkSkyTimelineHours
  Scenario: Verify timeline is displayed in correct format
    Then I verify timeline is displayed with 2 hours incremented


  @Scenario-3-darkSkyTodayTimeline
  Scenario: Verify individual day temp timeline
    When I expand today's timeline
    Then I verify lowest and highest temp is displayed correctly

  @Scenario-4-darkSkyRegistration
  Scenario: Verify invalid sign up error message
    When I click on the Dark Sky API link at home page
    And I click on the Sign Up button at the Dark Sky API page
    And I click on the Register button at the registration page
    Then I verify I am on Register page by asserting Register header