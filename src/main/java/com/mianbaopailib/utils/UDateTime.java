package com.mianbaopailib.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by shidawei on 16/7/13.
 */
public class UDateTime {

    public static String DATE_PATTERN = "yyyy-MM-dd";

    /**
     * 把string字符串转化为date
     *
     * @param date    string字符串
     * @param pattern 转化的类型
     * @return
     */
    public static Date StringToDate(String date, String pattern) {
        SimpleDateFormat formate = new SimpleDateFormat(pattern);
        Date returnDate = null;
        try {
            returnDate = formate.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return returnDate;
    }

    /**
     * @param date
     * @param days eg days=2 指两天以后
     * @author xuqifei
     */
    public static Date fewDayLater(Date date, Integer days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    public static Date getDefaultTime() {
        Long defaulttime = System.currentTimeMillis() + 1000 * 60 * 60 * 2;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String default_time = sdf.format(new Date(defaulttime));
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(default_time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;

    }

    /**
     * 将100以内正整数变为二位数
     * @param month
     * @return
     */
    public static String getMonthOrData(int month) {
        if (month > 0 && month < 10) {
            return "0" + month;
        }
        return String.valueOf(month);
    }

    /**
     * 通过天数和小时数获取下个时刻
     * @param tian
     * @param hour
     * @return
     */
    public static Date getTime(Integer tian, Integer hour) {
        Calendar c1 = Calendar.getInstance();
        c1.set(Calendar.DATE, c1.get(Calendar.DATE)+tian);
        if(hour!=null){
            c1.set(Calendar.HOUR_OF_DAY, c1.get(Calendar.HOUR_OF_DAY)+hour);
        }else{
            c1.set(Calendar.HOUR_OF_DAY, 0);
        }
        c1.set(Calendar.MINUTE, 0);
        c1.set(Calendar.SECOND, 0);
        return c1.getTime();

    }

    public static final int TYPE_YYYY_MM_DD_HH_MM_SS = 1;

    public static String formatData(Date date,int type){
        String dataFormat = null;
        switch (type){
            case TYPE_YYYY_MM_DD_HH_MM_SS:
                dataFormat = "yyyy-MM-dd HH:mm:ss";
                break;
            default:
        }
        SimpleDateFormat formatter = new SimpleDateFormat(dataFormat);
        String dateString = formatter.format(date);
        return dateString;

    }

}
