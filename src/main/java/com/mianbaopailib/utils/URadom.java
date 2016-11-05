package com.mianbaopailib.utils;

import org.apache.commons.lang.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 * Created by shidawei on 16/7/17.
 */
public class URadom {

    /**
     * 得到数字和字母的组合
     * @param num
     * @return
     */
    public static String getNumWords(int num) {
        String radom = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            int number = random.nextInt(radom.length());
            sb.append(radom.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 得到从start到end的字符串
     *
     * @param num
     * @param start
     * @param end
     * @return
     */
    public static String getNum(int num,int start,int end){
        if(start<=end){
            return "";
        }
        Random random = new Random();
        return String.valueOf(start + random.nextInt(end - start));
    }

    /**
     * 获得时间的字符串
     * @return
     */
    public static String getTime(){
        SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss",
                Locale.getDefault());
        Date date = new Date();
        String time = format.format(date);
        return time;
    }

    public static String getTimeLong(){
        Date date = new Date();
        return String.valueOf(date.getTime());
    }

}
