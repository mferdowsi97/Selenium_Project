package framework.webPages.facebook;

import framework.webPages.BasePages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class FacebookLandingPage extends BasePage {
    //Locators
    private By emailTextField = By.id("email");
    private By passTextField = By.id("pass");
    private By loginButton = By.id("loginbutton");
    private By firstNameTextField = By.name("firstname");
    private By lastNameTextField = By.name("lastname");
    private By mobileEmailTextField = By.xpath("//input[@name='reg_email__']");
    private By newPasswordField = By.xpath("//input[@name='reg_passwd__']");
    private By monthDropDown = By.id("month");
    private By dayDropDown = By.id("day");
    private By yearDropDown = By.id("year");
    private By signUpButton = By.xpath("//button[@name='websubmit']");
    private By genderErrorMessage = By.xpath("//div[starts-with(text(), 'Please choose a gender')]");
    private By messengerLink = By.xpath("//a[@href='https://messenger.com/']");
    private By maleRadioButton = By.xpath("//input[@type='radio' and @value='2']");
    private By femaleRadioButton = By.xpath("//input[@type = 'radio' and @value = '1']");
    private By invalidMobileOrEmailErrorMsg = By.xpath("//div[starts-with(text(),'Please enter a valid mobile')]");
    private By aboutLink = By.linkText("About");


    //Methods
    public String getPageURL(){
        return getURL();
    }

    public String getFacebookPageTitle(){
        return getPageTitle();
    }

    public void enterEmail(String value){
        setValue(emailTextField, value);
    }

    public void enterPassword(String value) {
        setValue(passTextField, value);
    }

    public FacebookLoginPage clickLoginButton() {
        clickOn(loginButton);
        return new FacebookLoginPage();
    }

    public void enterFirstName(String firstName){
        setValue(firstNameTextField, firstName);
    }

    public void enterLastName(String lastName){
        setValue(lastNameTextField, lastName);
    }

    public void enterMobileNumberOrEmail(String mobileNumberOrEmail){
        setValue(mobileEmailTextField, mobileNumberOrEmail);
    }

    public void clickOnMobileNumberOrEmailTextField(){
        clickOn(mobileEmailTextField);
    }

    public String getInvalidMobileOrEmailErrorMsg(){
        return getTextFromElement(invalidMobileOrEmailErrorMsg);
    }

    public void enterNewPassWord(String newPassword){
        setValue(newPasswordField, newPassword );
    }

    public String getGenderErrorMessage(){
        return getTextFromElement(genderErrorMessage);
    }

    public void selectCurrentMonthFromMonthDropDown(String monthValue){
        selectDropDownElementByValue(monthDropDown, monthValue);
    }

    public By getMonthDropDown(){
        return monthDropDown;
    }

    public By getDayDropDown(){
        return dayDropDown;
    }

    public By getYearDropDown(){
        return yearDropDown;
    }

    public boolean isDropDownHasDuplicates(By locator){
        return isDropdownHasDuplicates(locator);
    }

    public Set<WebElement> getDuplicatesFromDropDown(By locator) {
        return getDropDownDuplicateElements(locator);
    }

    public String getSelectedMonthFromMonthDropDown(){
        return getSelectedOptionTextFromDropDown(monthDropDown);
    }

    public boolean isGenderSelected(String gender){

        if(gender.equalsIgnoreCase("male")){
            return isGenderMaleSelected();
        }
        else if(gender.equalsIgnoreCase("female")){
            return isGenderFemaleSelected();
        }
        //if gender is not male or female
        return false;
    }

    public boolean isGenderMaleSelected(){
        return isElementSelected(maleRadioButton);
    }

    public boolean isGenderFemaleSelected(){return isElementSelected(femaleRadioButton);}

    public void selectGender(String gender){

        if(gender.equalsIgnoreCase("male")){
          selectGenderMale();
        }
        else if(gender.equalsIgnoreCase("female")){
            selectGenderFemale();
        }
    }

    public void selectGenderMale(){
        clickOn(maleRadioButton);
    }

    public void selectGenderFemale(){
        clickOn(femaleRadioButton);
    };

    public void clickOnSignUpButton(){
        clickOn(signUpButton);
    }

    public By getMaleRadioButton(){
        return maleRadioButton;
    }

    public By getFemaleRadioButton(){
        return femaleRadioButton;
    }

    public MessengerPage clickOnMessengerLink(){
        clickOn(messengerLink);
        return new MessengerPage();
    }

    public FacebookAboutPage clickOnAboutLink(){
        clickOn(aboutLink);
        return new FacebookAboutPage();
    }

}
