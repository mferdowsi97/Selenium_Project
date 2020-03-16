package framework.webPages.facebook;

import framework.webPages.BasePages.BasePage;

import org.openqa.selenium.By;

public class FacebookLoginPage extends BasePage {
    //Locators
    private By loginError = By.xpath("//a[text()='Forgot Password?']");
    private By incorrectPasswordErrorMessage = By.xpath("//div[starts-with(text(), 'The password')]");

    //Methods
    public String getErrorMessage() {

        return getTextFromElement(loginError);
    }

    public String getIncorrectPasswordErrorMessage(){

        return getTextFromElement(incorrectPasswordErrorMessage);
    }
}
