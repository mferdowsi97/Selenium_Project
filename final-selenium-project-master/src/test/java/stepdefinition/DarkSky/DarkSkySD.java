package stepdefinition.DarkSky;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.DarkSky.DarkSkyApiPage;
import framework.webPages.DarkSky.DarkSkyHomePage;
import framework.webPages.DarkSky.DarkSkyRegistrationPage;
import org.testng.Assert;
import util.DateUtil;

import java.util.List;

public class DarkSkySD {

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
        int currentTemperature = darkSkyHomePage.getCurrentTemperature();
        int maximumTemperature = darkSkyHomePage.getMaximumTimelineTemperature();
        int minimumTemperature = darkSkyHomePage.getMinimumTimelineTemperature();

        boolean inRange = darkSkyHomePage.isCurrentTemperatureInBetweenRange(currentTemperature, maximumTemperature, minimumTemperature);

        Assert.assertTrue(inRange,
                "Current Temperature " + currentTemperature + " is not in between " + maximumTemperature + " and " + minimumTemperature);
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
        String minTimelineTemp = darkSkyHomePage.getMinimumTimelineTemperatureOfToday();
        String maxTimelineTemp = darkSkyHomePage.getMaximumTimelineTemperatureOfToday();
        String lowestTemp = darkSkyHomePage.getLowestTemperatureOfToday();
        String highestTemp = darkSkyHomePage.getHighestTemperatureOfToday();


        Assert.assertTrue(minTimelineTemp.equals(lowestTemp),
                "Timeline min temp " + minTimelineTemp +" does't match with lowest temp " + lowestTemp);

        Assert.assertTrue(maxTimelineTemp.equals(highestTemp),
                "Timeline max temp " + maxTimelineTemp +" does't match with highest temp " + highestTemp);
    }

    @When("^I click on the Dark Sky API link at home page$")
    public void clickOnDarkSkyApiLink(){
        darkSkyApiPage = darkSkyHomePage.clickOnDarkSkyApiLink();
    }

    @When("^I click on the Sign Up button at the Dark Sky API page$")
    public void clickOnSighUpButton() throws InterruptedException {
        Thread.sleep(2000);
        darkSkyRegistrationPage = darkSkyApiPage.clickOnSignUpButton();
    }

    @When("^I click on the Register button at the registration page$")
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
