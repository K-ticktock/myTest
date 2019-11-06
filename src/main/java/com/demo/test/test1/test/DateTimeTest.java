package com.demo.test.test1.test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeTest {
    public static void main(String[] args){
        Clock clock = Clock.systemUTC();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        System.out.println(Instant.now().toEpochMilli());
        System.out.println(localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli());

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String time = localDateTime.format(dateTimeFormatter);
        System.out.println(time);

        System.out.println(clock.millis());

        Date date = new Date(20191016);
        System.out.println(date);
    }
}
