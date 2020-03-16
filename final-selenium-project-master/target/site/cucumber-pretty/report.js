$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("DarkSky.feature");
formatter.feature({
  "line": 2,
  "name": "DarkSky feature",
  "description": "",
  "id": "darksky-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@web"
    },
    {
      "line": 1,
      "name": "@darkSky"
    }
  ]
});
formatter.before({
  "duration": 3717186630,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I am on dark sky homepage",
  "keyword": "Given "
});
formatter.match({
  "location": "DarkSkyHomePageSD.onDarkSkyHomePage()"
});
formatter.result({
  "duration": 433950907,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 7,
      "value": "#1"
    }
  ],
  "line": 9,
  "name": "Verify Current Temperature should not be greater or less than the Temperature from Daily Timeline",
  "description": "",
  "id": "darksky-feature;verify-current-temperature-should-not-be-greater-or-less-than-the-temperature-from-daily-timeline",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 8,
      "name": "@darkSkyCurrentTemp"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "I verify current temp is not greater or less then temps from daily timeline",
  "keyword": "Then "
});
formatter.match({
  "location": "DarkSkyHomePageSD.verifyCurrentTempIsInBetweenMinimumMaximumTemps()"
});
formatter.result({
  "duration": 648494669,
  "status": "passed"
});
formatter.after({
  "duration": 127994134,
  "status": "passed"
});
formatter.before({
  "duration": 2526976691,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I am on dark sky homepage",
  "keyword": "Given "
});
formatter.match({
  "location": "DarkSkyHomePageSD.onDarkSkyHomePage()"
});
formatter.result({
  "duration": 45056705,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 12,
      "value": "#2"
    }
  ],
  "line": 14,
  "name": "Verify timeline is displayed in correct format",
  "description": "",
  "id": "darksky-feature;verify-timeline-is-displayed-in-correct-format",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 13,
      "name": "@darkSkyTimelineHours"
    }
  ]
});
formatter.step({
  "line": 15,
  "name": "I verify timeline is displayed with 2 hours incremented",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 36
    }
  ],
  "location": "DarkSkyHomePageSD.verifyIncrementedTimeline(int)"
});
formatter.result({
  "duration": 823344815,
  "status": "passed"
});
formatter.after({
  "duration": 149542527,
  "status": "passed"
});
formatter.before({
  "duration": 2582715845,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I am on dark sky homepage",
  "keyword": "Given "
});
formatter.match({
  "location": "DarkSkyHomePageSD.onDarkSkyHomePage()"
});
formatter.result({
  "duration": 18151547,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 17,
      "value": "#3"
    }
  ],
  "line": 19,
  "name": "Verify individual day temp timeline",
  "description": "",
  "id": "darksky-feature;verify-individual-day-temp-timeline",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 18,
      "name": "@darkSkyTodayTimeline"
    }
  ]
});
formatter.step({
  "line": 20,
  "name": "I expand today\u0027s timeline",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "I verify lowest and highest temp is displayed correctly",
  "keyword": "Then "
});
formatter.match({
  "location": "DarkSkyHomePageSD.expandTodayTimeline()"
});
formatter.result({
  "duration": 2172389040,
  "status": "passed"
});
formatter.match({
  "location": "DarkSkyHomePageSD.verifyLowestAndHighestTemp()"
});
formatter.result({
  "duration": 2157461555,
  "status": "passed"
});
formatter.after({
  "duration": 132683012,
  "status": "passed"
});
formatter.before({
  "duration": 2290094466,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "I am on dark sky homepage",
  "keyword": "Given "
});
formatter.match({
  "location": "DarkSkyHomePageSD.onDarkSkyHomePage()"
});
formatter.result({
  "duration": 17329760,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 23,
      "value": "#4"
    }
  ],
  "line": 25,
  "name": "Verify invalid sign up error message",
  "description": "",
  "id": "darksky-feature;verify-invalid-sign-up-error-message",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 24,
      "name": "@darkSkyRegistration"
    }
  ]
});
formatter.step({
  "line": 26,
  "name": "I click on Dark Sky API link at home page",
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "I click on Sign Up button at the Dark Sky API page",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "I click on Register button at the registration page",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "I verify I am on Register page by asserting Register header",
  "keyword": "Then "
});
formatter.match({
  "location": "DarkSkyHomePageSD.clickOnDarkSkyApiLink()"
});
formatter.result({
  "duration": 338442986,
  "status": "passed"
});
formatter.match({
  "location": "DarkSkyHomePageSD.clickOnSighUpButton()"
});
formatter.result({
  "duration": 2129860608,
  "status": "passed"
});
formatter.match({
  "location": "DarkSkyHomePageSD.clickToRegister()"
});
formatter.result({
  "duration": 124719527,
  "status": "passed"
});
formatter.match({
  "location": "DarkSkyHomePageSD.verifyStillOnRegisterPage()"
});
formatter.result({
  "duration": 92557991,
  "status": "passed"
});
formatter.after({
  "duration": 138279205,
  "status": "passed"
});
});