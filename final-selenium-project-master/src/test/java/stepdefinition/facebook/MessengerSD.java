package stepdefinition.facebook;

import cucumber.api.java.en.Given;
import framework.webPages.facebook.FacebookLandingPage;
import framework.webPages.facebook.MessengerLoginPage;
import framework.webPages.facebook.MessengerPage;
import org.testng.Assert;
import stepdefinition.SharedSD.SharedSD;

public class MessengerSD {

    private FacebookLandingPage homePage = new FacebookLandingPage();
    private MessengerPage messengerPage = new MessengerPage();
    private MessengerLoginPage messengerLoginPage = new MessengerLoginPage();

    @Given("^I am on messenger page$")
    public void setMessengerPage() {
        homePage.clickOnMessengerLink();
        Assert.assertEquals(SharedSD.getDriver().getCurrentUrl(), "https://www.messenger.com/");
    }


}
