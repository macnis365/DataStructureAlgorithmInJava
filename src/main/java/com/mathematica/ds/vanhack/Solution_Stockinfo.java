package com.mathematica.ds.vanhack;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution_Stockinfo {

    public static void openAndClosePrices(String firstDate, String lastDate, String weekDay) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMMM-yyyy");
        System.out.println(LocalDate.parse(firstDate, formatter).format(formatter));
        System.out.println(LocalDate.parse(lastDate, formatter).format(formatter));

        long numOfDays = ChronoUnit.DAYS.between(LocalDate.parse(firstDate, formatter), LocalDate.parse(lastDate, formatter));
        List<LocalDate> daysRange = Stream.iterate(LocalDate.parse(firstDate, formatter), date -> date.plusDays(1)).limit(numOfDays).filter(date -> date.getDayOfWeek() == DayOfWeek.valueOf(weekDay.toUpperCase())).collect(Collectors.toList());
        String stockUrl = "https://jsonmock.hackerrank.com/api/stocks/?date=";
        daysRange.stream().map(date -> date.format(formatter)).forEach(System.out::println);
        daysRange.stream().map(date -> date.format(formatter)).forEach((date) -> {
            httpGet(stockUrl + date.toString());
        });
    }

    public static void httpGet(String stockUrl) {
        Gson gson = new Gson();
        try (java.util.Scanner s = new java.util.Scanner(new URL(stockUrl).openStream())) {
            Stock stock = gson.fromJson(s.next(), Stock.class);
            Arrays.asList(stock.getData()).stream().filter(date ->
                    !date.getOpen().isEmpty() && !date.getClose().isEmpty()
            ).forEach((date) -> {
                System.out.println(date.getDate() + " " + date.getOpen() + " " + date.getClose());
            });
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Stock {
    private String per_page;

    private String total;

    private Data[] data;

    private String page;

    private String total_pages;

    public String getPer_page() {
        return per_page;
    }

    public void setPer_page(String per_page) {
        this.per_page = per_page;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Data[] getData() {
        return data;
    }

    public void setData(Data[] data) {
        this.data = data;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(String total_pages) {
        this.total_pages = total_pages;
    }

    @Override
    public String toString() {
        return "Stock [per_page = " + per_page + ", total = " + total + ", data = " + data + ", page = " + page + ", total_pages = " + total_pages + "]";
    }
}

class Data {
    private String date;

    private String high;

    private String low;

    private String close;

    private String open;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    @Override
    public String toString() {
        return "stock-data [date = " + date + ", high = " + high + ", low = " + low + ", close = " + close + ", open = " + open + "]";
    }
}
