package framework.webPages.BasePages;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import stepdefinition.SharedSD.SharedSD;


import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BasePage {
    // This is the most common wait function used in selenium
    public static WebElement fluentWait(final By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(SharedSD.getDriver())
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementClickInterceptedException.class)
                .withMessage(
                        "Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });

        return element;
    }

    public String getURL(){
        return SharedSD.getDriver().getCurrentUrl();
    }

    public String getPageTitle(){
        return SharedSD.getDriver().getTitle();
    }

    public void clickOn(By locator){
        fluentWait(locator).click();
    }

    public void clearTextField(By locator){
        fluentWait(locator).clear();
    }

    public void setValue(By locator, String value){
        clearTextField(locator);
        fluentWait(locator).sendKeys(value);
    }

    public String getTextFromElement(By locator){
        return fluentWait(locator).getText();
    }

    public String getAttributeValueFromElement(By locator, String attributeName){
        return fluentWait(locator).getAttribute(attributeName);
    }

    public List<WebElement> getElements(By locator){

        return SharedSD.getDriver().findElements(locator);
    }

    public List<String> getValuesFromElements(By locator){

        List<WebElement> webElements = getElements(locator);
        List<String> values= new ArrayList<>();

        for (WebElement webElement: webElements){
            values.add(webElement.getText());
        }
        return values;
    }
    public Select selectDropDown(By locator){
        return new Select(SharedSD.getDriver().findElement(locator));
    }

    public void selectDropDownElementByText(By locator, String visibleText){
        selectDropDown(locator).selectByVisibleText(visibleText);
    }

    public String getSelectedOptionTextFromDropDown(By locator){
        return selectDropDown(locator).getFirstSelectedOption().getText();
    }

    public void selectDropDownElementByIndex(By locator, int index){
        selectDropDown(locator).selectByIndex(index);
    }

    public void selectDropDownElementByValue(By locator, String value){
        selectDropDown(locator).selectByValue(value);
    }

    public boolean isDropDownContainsValue(By locator, String value){
        List<WebElement> listOfAllOptions = selectDropDown(locator).getOptions();

        for (WebElement option: listOfAllOptions){
            if(value.equalsIgnoreCase(option.getText())){
                return true;
            }
        }
        return false;
    }

    public boolean isDropdownHasDuplicates(By locator){
        List<WebElement> listContainingDuplicateElements = selectDropDown(locator).getOptions();
        //converting the List into a Set removes duplicate elements from List
        Set<WebElement> setAfterRemovingDuplicateElements = new HashSet<>(listContainingDuplicateElements);

        if(setAfterRemovingDuplicateElements.size() < listContainingDuplicateElements.size()){
            return true;
        }
        return false;
    }

    public Set<WebElement> getDropDownDuplicateElements(By locator){
        boolean flag = true;

        //list containing duplicate elements, Example: [1, 3, 2, 1, 5, 2, 3, 4]
        List<WebElement> listContainingDuplicateElements = selectDropDown(locator).getOptions();
        //this set contains the elements with duplicates removed, Example: [1, 3, 2, 5, 4]
        Set<WebElement> uniqueElements = new HashSet<>();
        //contains elements those are duplicates, Example: [1, 3, 2]
        Set<WebElement> setOfDuplicateElements = new HashSet<>();

        for(WebElement element: listContainingDuplicateElements){

            /*The add(element) method of Set returns true if the element is not in the Set.
             *The add(element) method of Set returns false if the element is already in the Set.
             */
            flag = uniqueElements.add(element);

            if(!flag){ //!false = true, !true = false
                setOfDuplicateElements.add(element);
            }
        }
        //return the set of duplicate elements
        return setOfDuplicateElements;
    }

    public String extractNameOfViewMonth(By locator){
        String headerText = getTextFromElement(locator);
        String[] month_year = headerText.split("\\s"); //Month Year: March 2020
        String nameOfMonth = month_year[0];
        //returns name of the month
        return nameOfMonth;
    }

    public String getValueFromInvisibleElement(By locator){
        WebDriver driver = SharedSD.getDriver();
        WebDriverWait wait = new WebDriverWait(driver,30);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return element.getAttribute("value");
    }

    public void clickOnNextIcon(By locator){
        WebDriver driver = SharedSD.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(locator));
        webElement.click();
    }

    public void clickOnCheckingDate(By locator, LocalDate checkingDate){
        List<WebElement> days =  SharedSD.getDriver().findElements(locator);
        String dayOfMonth = Integer.toString(checkingDate.getDayOfMonth());

        for(WebElement day: days){
            if(day != null && day.getText().equalsIgnoreCase(dayOfMonth)){
                day.click();
                return;
            }

        }
    }

    public boolean isElementSelected(By locator){
        boolean isSelected;
        try {
            isSelected = fluentWait(locator).isSelected();
        }catch (NoSuchElementException e){
            isSelected = false;
            e.printStackTrace();
            System.out.println("No such element found with locator: " + locator);
        }
        return isSelected;
    }

    public boolean isElementDisplayed(By locator) {
        boolean isDisplayed;
        try {
            isDisplayed = SharedSD.getDriver().findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            isDisplayed = false;
            e.printStackTrace();
            System.out.println("No such element found with locator: " + locator);
        }
        return isDisplayed;
    }

    public boolean isElementEnabled(By locator){
        boolean isEnabled;
        try{
            isEnabled = fluentWait(locator).isEnabled();
        }catch (NoSuchElementException e){
            isEnabled = false;
            e.printStackTrace();
            System.out.println("No such element found with locator: " + locator);
        }
        return isEnabled;
    }

    public void scrollByVisibleElement(By locator){

        JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", fluentWait(locator));
    }
}
