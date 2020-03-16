package framework.webPages.darkskyAPI;

import framework.webPages.BasePages.BasePage;
import org.openqa.selenium.By;

public class DarkSkyRegistrationPage extends BasePage {

    private By registerButton = By.xpath("//button[@type = 'submit' and text() = 'Register']");
    private By registrationFormHeaderText = By.xpath("//h1[contains(@class, 'title') and text() = 'Register']");

    public void clickOnRegisterButton(){
        clickOn(registerButton);
    }

    public String getRegistrationFormHeaderText(){
        return getTextFromElement(registrationFormHeaderText);
    }
}
