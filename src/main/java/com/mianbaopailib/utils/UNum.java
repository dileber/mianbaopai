package com.mianbaopailib.utils;

/**
 * Created by shidawei on 16/7/29.
 */
public class UNum {

    public static int checkBig(int... ints){
        int big = Integer.MIN_VALUE;
        for(int temp:ints){
            if(temp>big){
                big = temp;
            }
        }
        return big;
    }


}
