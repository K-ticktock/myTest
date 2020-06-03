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
            Date d1 = format1.parse("20200101");
            Date d2 = format1.parse("20200205");
            long l1 = d1.toInstant().toEpochMilli();
            long l2 = d2.toInstant().toEpochMilli();
            long l3 = (l2-l1)/(1000*60*60*24);
            System.out.println(l3);
        } catch (ParseException e) {

        }


    }
}
