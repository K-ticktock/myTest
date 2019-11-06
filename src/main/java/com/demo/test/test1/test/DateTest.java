package com.demo.test.test1.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        Date date1 = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
        String str1 = format1.format(date1);
        try {
            Date date2 = format1.parse("20190808");
        } catch (ParseException e) {

        }
    }
}
