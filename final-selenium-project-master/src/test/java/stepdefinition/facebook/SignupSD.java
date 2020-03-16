package stepdefinition.facebook;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import framework.webPages.facebook.FacebookLandingPage;

public class SignupSD {

    private FacebookLandingPage homePage = new FacebookLandingPage();

    @Then("^I verify gender (female|male) is selected$")
    public void genderValidation(String gender) {

        if (gender.equals("female")) {
            if (!homePage.isGenderFemaleSelected()) {
                homePage.selectGenderFemale();
            }
            Assert.assertTrue(homePage.isGenderFemaleSelected());
        } else if (gender.equals("male")) {
            if (!homePage.isGenderMaleSelected()) {
                homePage.selectGenderMale();
            }
            Assert.assertTrue(homePage.isGenderMaleSelected());


        }
    }
}
