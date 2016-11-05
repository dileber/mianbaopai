package com.mianbaopailib.utils;

/**
 * 空检查工具
 * Created by shidawei on 16/7/17.
 */
public class UNull {

    public static boolean checkUnll(Object... object){
        for(Object temp:object){
            if(temp==null){
                return false;
            }
        }
        return true;
    }

}
