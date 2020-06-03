package com.vytrack.utilities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeUtilities {


    /**
     * specify date format
     * this method returns current date in given format as a string
     * @param format
     * @return
     */
    public static String getCurrentDate(String format){
        return LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
    }


    /**
     * this mehtod returns differene between end and start time
     * @param end time
     * @param
     * @return
     */
    public static long getTimeDifference(String start, String end, String format){
        LocalTime startTime = LocalTime.parse(start,DateTimeFormatter.ofPattern(format));
        LocalTime endTime = LocalTime.parse(end,DateTimeFormatter.ofPattern(format));


        return ChronoUnit.HOURS.between(endTime,startTime);

    }
}
