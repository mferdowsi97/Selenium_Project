package framework.webPages.facebook;

import framework.webPages.BasePages.BasePage;

import org.openqa.selenium.By;

public class MessengerPage extends BasePage {
    //locators
    private By signUpButton = By.id("loginbutton");

    //methods
    public MessengerLoginPage clickOnSignUpButton(){
        clickOn(signUpButton);
        return new MessengerLoginPage();
    }
}
