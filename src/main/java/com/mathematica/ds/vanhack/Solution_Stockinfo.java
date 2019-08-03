package com.mathematica.ds.vanhack;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution_Stockinfo {

    public static void openAndClosePrices(String firstDate, String lastDate, String weekDay) {

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat localDateFormat = new SimpleDateFormat("dd-MMMM-yyyy");
        Locale loc = new Locale("en", "US");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
        System.out.println(LocalDate.parse(firstDate, formatter).format(formatter));
        System.out.println(LocalDate.parse(lastDate, formatter).format(formatter));

        long numOfDays = ChronoUnit.DAYS.between(LocalDate.parse(firstDate, formatter), LocalDate.parse(lastDate, formatter));
        List<LocalDate> daysRange = Stream.iterate(LocalDate.parse(firstDate, formatter), date -> date.plusDays(1)).limit(numOfDays).filter(date -> date.getDayOfWeek()== DayOfWeek.valueOf(weekDay.toUpperCase()) ).collect(Collectors.toList());

        daysRange.stream().map(date->date.format(formatter)).forEach(System.out::println);


    }
}
