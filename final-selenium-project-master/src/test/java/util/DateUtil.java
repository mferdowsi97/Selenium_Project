package util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DateUtil {

    //get future date based on a given date
    public static LocalDate getFutureDate(LocalDate givenDate, int days){

        return givenDate.plusDays(days);
    }

    //get month as an integer from name of the month
    public static int monthValue(String monthName){

        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

        int n = months.length;
        for(int i = 0; i < n; i++){
            if(monthName.equalsIgnoreCase(months[i])){
                return i + 1;
            }
        }
        //if there is no matching month
        return 0;
    }

    //get month as an integer from a date
    public static int monthValue(LocalDate localDate){

        return localDate.getMonthValue();
    }

    //get date as an string
    public static String getCurrentDateOfPattern(String pattern){
        LocalDate today = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);

        return today.format(dateTimeFormatter);
    }

    //get current date
    public static LocalDate getCurrentDate(){
        return LocalDate.now();
    }

    //using LocalDateTime get timeline incremented by hours
    public static List<String> getTimelineIncrementedByHours(int intervalPeriodInHours, int timelineSize){
        List<String> timelineHours = new ArrayList<>();
        String nextHour = null;

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("Ka");

        for (int i = 0; i < timelineSize; i++){
            localDateTime = localDateTime.plusHours(intervalPeriodInHours);
            nextHour = localDateTime.format(dateTimeFormatter).toLowerCase();

            if(nextHour.equalsIgnoreCase("0pm")){
                nextHour = "12pm";
            }
            if(nextHour.equalsIgnoreCase("0am")){
                nextHour = "12am";
            }

            timelineHours.add(nextHour);
        }

        return timelineHours;
    }
}
