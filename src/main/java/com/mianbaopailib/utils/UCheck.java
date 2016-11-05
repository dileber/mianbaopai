package com.mianbaopailib.utils;

import com.sun.istack.internal.Nullable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by shidawei on 16/7/17.
 */
public class UCheck{

    /**
     * 中国手机号
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobiles) {
        String telRegex = "[1][3-8]\\d{9}";
        if (!checkText(mobiles,11)) {
            return false;
        }else if(mobiles.matches(telRegex)){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 长度在start~end之间，只能包含字符，数字和下划线
     * @param pass
     * @param start
     * @param end
     * @return
     */
    public static boolean isPassWord(String pass,int start,int end){
        String telRegex = "^[0-9_a-zA-Z]{"+start+","+end+"}$";
        if (!checkText(pass, start)) {
            return false;
        }else if(pass.matches(telRegex)){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 不能小于某个数
     * @param edit
     * @param num
     * @return
     */
    public static boolean checkText(String edit,int num){
        if(edit==null||edit.length()<num){
            return false;
        }
        return true;
    }

    /**
     * 检查电子邮件
     * @param email
     * @return
     */
    public static boolean checkEmail(String email){
        String emailcheck = "^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\\.([a-zA-Z0-9_-])+)+$";
        Pattern p = Pattern.compile(emailcheck);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    public static <T> T checkNotNull(T reference) {
        if(reference == null) {
            throw new NullPointerException();
        } else {
            return reference;
        }
    }

    public static <T> T checkNotNull(T reference, @Nullable Object errorMessage) {
        if (reference == null) {
            throw new NullPointerException(String.valueOf(errorMessage));
        }
        return reference;
    }

    public static boolean checkNotNulls(Object ... objects){
        if(objects==null){
            return false;
        }
        for(int i=0;i<objects.length;i++){
            if(objects[i]==null){
                return false;
            }
        }
        return true;
    }


}
