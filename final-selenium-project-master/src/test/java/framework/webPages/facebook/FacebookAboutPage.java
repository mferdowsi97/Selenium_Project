package framework.webPages.facebook;

import framework.webPages.BasePages.BasePage;
import org.openqa.selenium.By;

public class FacebookAboutPage extends BasePage {
    private By create_a_PageBtn = By.xpath("(//button[@type = 'submit'])[1]");

    public void clickOnCreate_A_PageBtn(){
        clickOn(create_a_PageBtn);
    }
}
