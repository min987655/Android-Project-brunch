package com.cos.brunch.utils;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateFormatter {

    private static final String TAG = "DateFormatter";

    public static String converterDate(String createDate) {

        String testDate = "2020-08-26T08:26:05.136+00:00";

        SimpleDateFormat serverDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat newDate = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

        try {
            Date testServerDate = serverDate.parse(testDate);
            Date testNewDate = newDate.parse(testDate);

            Log.d(TAG, "converterDate: testServerDate : " + testServerDate);
            Log.d(TAG, "converterDate: testNewDate : " + testNewDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
