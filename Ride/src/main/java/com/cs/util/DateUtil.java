package com.cs.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 */
public class DateUtil {

    // 默认日期格式
    public static final String DATE_DEFAULT_FORMAT = "yyyy-MM-dd";

    // 默认时间格式
    public static final String DATETIME_DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String TIME_DEFAULT_FORMAT = "HH:mm:ss";

    public static String getString(Date date,String fmt) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_DEFAULT_FORMAT);
        String result = sdf.format(date);
        return result;
    }

    public static Date getDate(String date,String fmt){
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_DEFAULT_FORMAT);
        Date result = null;
        try {
            result = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(DateUtil.getDate("2020-01-07 12:39:44",null));
        System.out.println(DateUtil.getString(new Date(),null));
    }
}