package framework.webPages.facebook;

import framework.webPages.BasePages.BasePage;

import org.openqa.selenium.By;

public class MessengerLoginPage extends BasePage {
    //locators
    private By emailOrPhoneNumberErrorMessage = By.xpath("//div[contains(text(), 'Incorrect email or phone number')]");

    //methods
    public String getEmailOrPhoneNumberErrorMessage(){
        return getTextFromElement(emailOrPhoneNumberErrorMessage);
    }
}
