package stepdefinition.darkSkyAPI;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.darkskyAPI.DarkSkyApiPage;
import framework.webPages.darkskyAPI.DarkSkyHomePage;
import framework.webPages.darkskyAPI.DarkSkyRegistrationPage;
import org.testng.Assert;
import util.DateUtil;

import java.util.List;

public class DarkSkyHomePageSD {

    private DarkSkyHomePage darkSkyHomePage = new DarkSkyHomePage();
    private DarkSkyApiPage darkSkyApiPage = new DarkSkyApiPage();
    private DarkSkyRegistrationPage darkSkyRegistrationPage = new DarkSkyRegistrationPage();

    @Given("^I am on dark sky homepage$")
    public void onDarkSkyHomePage(){
        darkSkyHomePage = new DarkSkyHomePage();

        String expectedURL = "https://darksky.net/";
        String actualURL = darkSkyHomePage.getURL();
        boolean onDarkSkyHomePage = actualURL.startsWith(expectedURL);

        String expectedTitle = "Dark Sky";
        String actualTitle = darkSkyHomePage.getPageTitle();
        boolean containsTitle = actualTitle.startsWith(expectedTitle);

        Assert.assertTrue(onDarkSkyHomePage,"Not on DarkSky homepage: " + actualURL);
        Assert.assertTrue(containsTitle, "Title does not match: " + actualTitle);
    }

    @Then("^I verify current temp is not greater or less then temps from daily timeline$")
    public void verifyCurrentTempIsInBetweenMinimumMaximumTemps(){
        int currentTemp = darkSkyHomePage.getCurrentTemperature();
        int maxTemp = darkSkyHomePage.getMaxTimelineTemperature();
        int minTemp = darkSkyHomePage.getMinTimelineTemperature();

        boolean inRange = darkSkyHomePage.isCurrentTemperatureInBetween(currentTemp, maxTemp, minTemp);

        Assert.assertTrue(inRange,
                "Current Temp " + currentTemp + " is not in between " + maxTemp + " and " + minTemp);
    }

    @Then("^I verify timeline is displayed with (\\d+) hours incremented$")
    public void verifyIncrementedTimeline(int timeIntervalInHours){
        List<String > timelineHours = darkSkyHomePage.getTimelineHours();
        List<String> hoursFromSystem = DateUtil.getTimelineIncrementedByHours(timeIntervalInHours,timelineHours.size());
        System.out.println(timelineHours);
        System.out.println(hoursFromSystem);

        Assert.assertEquals(timelineHours, hoursFromSystem,
                "Timeline is not incremented by " + timeIntervalInHours);
    }

    @When("^I expand today's timeline$")
    public void expandTodayTimeline() throws InterruptedException {
        darkSkyHomePage.clickOnTodayTimeline();
    }

    @Then("^I verify lowest and highest temp is displayed correctly$")
    public void verifyLowestAndHighestTemp() throws InterruptedException {
        darkSkyHomePage.clickOnTodayTimeline();
        String minTimelineTemp = darkSkyHomePage.getMinimumTimelineTempOfToday();
        String maxTimelineTemp = darkSkyHomePage.getMaximumTimelineTempOfToday();
        String lowestTemp = darkSkyHomePage.getLowestTempOfToday();
        String highestTemp = darkSkyHomePage.getHighestTempOfToday();


        Assert.assertTrue(minTimelineTemp.equals(lowestTemp),
                "Timeline min temp " + minTimelineTemp +" does't match with lowest temp " + lowestTemp);

        Assert.assertTrue(maxTimelineTemp.equals(highestTemp),
                "Timeline max temp " + maxTimelineTemp +" does't match with highest temp " + highestTemp);
    }

    @When("^I click on Dark Sky API link at home page$")
    public void clickOnDarkSkyApiLink(){
        darkSkyApiPage = darkSkyHomePage.clickOnDarkSkyApiLink();
    }

    @When("^I click on Sign Up button at the Dark Sky API page$")
    public void clickOnSighUpButton() throws InterruptedException {
        Thread.sleep(2000);
        darkSkyRegistrationPage = darkSkyApiPage.clickOnSignUpButton();
    }

    @When("^I click on Register button at the registration page$")
    public void clickToRegister() {
        darkSkyRegistrationPage.clickOnRegisterButton();
    }

    @Then("^I verify I am on Register page by asserting Register header$")
    public void verifyStillOnRegisterPage(){

        String expectedRegisterHeader = "Register";
        String actualRegisterHeader = darkSkyRegistrationPage.getRegistrationFormHeaderText();

        Assert.assertEquals(expectedRegisterHeader, actualRegisterHeader,
                "Expected header text: " + expectedRegisterHeader +" " +
                "doesn't match with actual header text: " + actualRegisterHeader);
    }
}
