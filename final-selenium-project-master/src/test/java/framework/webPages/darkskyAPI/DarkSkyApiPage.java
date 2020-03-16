package framework.webPages.darkskyAPI;

import framework.webPages.BasePages.BasePage;
import org.openqa.selenium.By;

public class DarkSkyApiPage extends BasePage {
    private By signUpButton = By.xpath("//a[@href='/dev/register' and text() ='Sign Up']");

    public DarkSkyRegistrationPage clickOnSignUpButton() {
        clickOn(signUpButton);
        return new DarkSkyRegistrationPage();
    }
}
