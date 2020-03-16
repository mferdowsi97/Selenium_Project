package framework.webPages.HotelsHomePage;

import framework.webPages.BasePages.BasePage;
import org.openqa.selenium.By;
import util.DateUtil;


import java.time.LocalDate;

public class HotelsHomePage extends BasePage {
    private By popUpCloseIcon = By.xpath("//button[@aria-label = 'Close overlay']");
    private By checkInCalenderIcon = By.id("widget-query-label-1");
    private By checkOutCalenderIcon = By.id("widget-query-label-3");
    private By datePickerHeaderText = By.xpath("(//div[@class = 'widget-datepicker-label'])[1]");
    private By previousMonthButton = By.xpath("(//button[@aria-label = 'Previous month'])[1]");
    private By nextMonthButton = By.xpath("(//button[@class = 'widget-datepicker-next'])[2]");
    private By checkInBox = By.xpath("//input[@name = 'q-localised-check-in']");
    private By checkOutBox = By.xpath("//input[@name = 'q-localised-check-out']");
    private By daysOfMonth = By.xpath("(//div[@class = 'widget-daterange-cont']//table)[1]//tr//td//a");
    private By nightIcon = By.xpath("//span[@class = 'widget-query-num-nights']");
    private By roomsDropDown = By.xpath("//select[@name = 'q-rooms']");
    private By adultsDropDown = By.xpath("//select[contains(@name, 'adults')]");
    private By childrenDropDown = By.xpath("//select[contains(@name, 'children')]");
    private By childDropDowns = By.xpath("//select[contains(@name, 'child') and contains(@name, 'age')]");

    public boolean isPopUpDisplayed(){
        return isElementDisplayed(popUpCloseIcon);
    }
    public void clickOnPopUpCloseIcon(){
        clickOn(popUpCloseIcon);
    }

    public void clickOnCheckInCalenderIcon(){
        clickOn(checkInCalenderIcon);
    }

    public void clickOnCheckOutCalenderIcon(){
        clickOn(checkOutCalenderIcon);
    }

    public String getCalenderViewMonth(){
        return extractNameOfViewMonth(datePickerHeaderText);
    }

    public void clickOnPreviousMonthButton(){
        clickOn(previousMonthButton);
    }
    public void clickOnNextMonthButton(){
        clickOnNextIcon(nextMonthButton);
    }

    /*checkingDate is the check in or check out date,
    *calenderViewMonth is the default view month when initially opening the calender.
    */
    public void selectCalenderDate(LocalDate checkingDate, LocalDate defaultCalenderViewMonth){

        int calenderViewMonth = DateUtil.monthValue(defaultCalenderViewMonth);
        int checkingMonth = DateUtil.monthValue(checkingDate);

        /*go to the check in or check out month
        by clicking on the prev-month and next-month arrow signs
        */
        while (checkingMonth != calenderViewMonth){
            if(checkingMonth < calenderViewMonth){
                    clickOnPreviousMonthButton();
            }
            else {
                clickOnNextMonthButton();
            }
            calenderViewMonth = DateUtil.monthValue(getCalenderViewMonth());
        }
        //select check in or check out date
       clickOnCheckingDate(daysOfMonth, checkingDate);
    }

    public void clickOnCheckInInput(){
        clickOn(checkInBox);
    }
    public String getCheckInDate(){
        return getAttributeValueFromElement(checkInBox, "value");
    }

    public String nightStays(){
        return getTextFromElement(nightIcon);
    }

    public void selectRoomsFromDropDown(String  noOfRooms){
        selectDropDownElementByText(roomsDropDown, noOfRooms);
    }

    public void selectAdultsFromDropDown(String noOfAdults){
        selectDropDownElementByText(adultsDropDown, noOfAdults);
    }

    public void selectChildrenFromDropDown(String noOfChildren){
        selectDropDownElementByText(childrenDropDown, noOfChildren);
    }

    public int getNoOfChildDropDowns(){
        return getElements(childDropDowns).size();
    }
}
