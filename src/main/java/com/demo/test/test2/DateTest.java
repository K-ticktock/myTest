package com.demo.test.test2;

import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getMonth()+1+"yue"+date.getDate()+"tian"+date.getHours()+":"+date.getMinutes());
        String ss = "123456789";
        System.out.println(ss.substring(ss.length()-3));
        Long aa = 1L;
        System.out.println(aa==1);

        String ac = "9999021199903238949752";
        System.out.println(ac.startsWith("99991"));
    }
}
