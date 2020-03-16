package stepdefinition.Hotels;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.HotelsHomePage.HotelsHomePage;
import org.testng.Assert;

public class HotelsHomePageSD {

    private HotelsHomePage homePage = new HotelsHomePage();

    @Given("^I am on hotels homepage page$")
    public void iAmOnHotelsHomePage(){
        String expectedURL = "https://www.hotels.com/";
        String actualURL = homePage.getURL();
        Assert.assertEquals(expectedURL, actualURL, "Error: Invalid Home Page");
    }

    @When("^I select ([1-8]) in rooms$")
    public void selectRooms(String noOfRooms) {
        homePage.selectRoomsFromDropDown(noOfRooms);
    }

    @When("^I select ([1-9]|1\\d|20) in adults$")
    public void selectAdults(String noOfAdults) {
        homePage.selectAdultsFromDropDown(noOfAdults);
    }

    @When("^I select ([0-6]) in children$")
    public void selectChildren(String noOfChildren) {
        homePage.selectChildrenFromDropDown(noOfChildren);
    }

    @Then("^I verify that I get (\\d+) children dropdown$")
    public void verifyChildrenDropdown(int expectedNoOfChildDropDown) {
        int actualNoOfChildDropDown = homePage.getNoOfChildDropDowns();

        Assert.assertEquals(expectedNoOfChildDropDown, actualNoOfChildDropDown, "Actual child drop downs: " + actualNoOfChildDropDown);
    }
}
