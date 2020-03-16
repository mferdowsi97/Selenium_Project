package stepdefinition.facebook;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.facebook.FacebookLandingPage;
import org.testng.Assert;

public class FacebookSignUpSD {

    FacebookLandingPage facebookLandingPage = new FacebookLandingPage();

    @Given("^I am on facebook landing page$")
    public void iAmOnFacebookLandingPage(){
        String expectedURL = "https://www.facebook.com/";
        String actualURL = facebookLandingPage.getURL();

        Assert.assertEquals(expectedURL, actualURL, "Error: Not in Facebook landing pge.");
    }

    @When("^I enter (.+) into (firstName|lastName|password|mobileNumberOrEmail|newPassword) text field on sign up form$")
    public void enterValueIntoTextField(String value, String textField){

        switch (textField){
            case "firstName":
                facebookLandingPage.enterFirstName(value);
                break;
            case "lastName":
                facebookLandingPage.enterLastName(value);
                break;
            case "password":
                facebookLandingPage.enterPassword(value);
                break;
            case "mobileNumberOrEmail":
                facebookLandingPage.enterMobileNumberOrEmail(value);
                break;
            case "newPassword":
                facebookLandingPage.enterNewPassWord(value);
                break;
            default:
                System.out.println("Not a text field.");
                break;
        }
    }

    @When("^I select gender (Male|Female) if not already selected on sign up form$")
    public void selectGenderIfNotAlreadySelected(String gender){

        if(!facebookLandingPage.isGenderSelected(gender)){

            facebookLandingPage.selectGender(gender);
        }
    }

    @When("^I click on Sign Up button on sign up form$")
    public void clickOnSignUpBtn(){
        facebookLandingPage.clickOnSignUpButton();
    }

    @Then("^I verify that the gender (Male|Female) is selected$")
    public void verifyGenderIsSelected(String gender){

        Assert.assertTrue(facebookLandingPage.isGenderSelected(gender), "Gender " + gender+ " is not selected");
    }
}
