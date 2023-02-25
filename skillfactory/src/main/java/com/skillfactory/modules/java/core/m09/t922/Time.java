package com.skillfactory.modules.java.core.m09.t922;

import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Time {
    String date = "";
    public void getTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1);
        // 1970 Jan 01 00:00:00
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy MMM dd hh:mm:ss");
        date = dateFormat.format(calendar.getTime());
        System.out.println(date);
    }
}

