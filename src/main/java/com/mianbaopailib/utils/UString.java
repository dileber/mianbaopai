package com.mianbaopailib.utils;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by shidawei on 16/7/13.
 */
public class UString {



    public static final Pattern pattern = Pattern.compile("\\{\\{([a-zA-Z0-9_\\-]+)\\}\\}");

    public static String concat(Object... args) {
        if (args.length > 0) {
            StringBuilder ret = new StringBuilder();
            for (Object s : args) {
                if(s == null){
                    s = "null";
                    ret.append(s.toString());
                }else{
                    if (s.getClass().isArray()) {
                        Object[] ss = (Object[]) s;
                        ret.append("[");
                        for (Object obj : ss) {
                            ret.append(obj.toString()).append(",");
                        }
                        ret.append("]");
                    } else {
                        ret.append(s.toString());
                    }
                }
            }
            return ret.toString();
        } else {
            return "";
        }
    }


    public static String concat(String spliter, Object... args) {
        if (args.length > 1) {
            StringBuilder ret = new StringBuilder();
            int n = spliter.length();
            for (Object s : args) {

                if (s == null) {
                    s = "null";
                    ret.append(spliter).append(s.toString());
                } else if (!s.getClass().isArray()) {
                    ret.append(spliter).append(s.toString());
                } else {
                    Object[] ss = (Object[]) s;
                    ret.append("[");
                    for (Object obj : ss) {
                        ret.append(obj.toString()).append(",");
                    }
                    ret.append("]");
                }
            }
            if (ret.length() > n) {
                ret.delete(0, n);
            }
            return ret.toString();
        } else if (args.length == 1) {
            return args[0]==null?"null":args[0].toString();
        } else {
            return "";
        }
    }


    /**
     * 通过模版生成字符串
     * @param target
     * @param param
     * @return
     */
    public static String templetStr(String target, Map<String, Object> param) {
        StringBuilder ret = new StringBuilder();
        Matcher m = pattern.matcher(target);
        int start = 0;
        if (param != null) {
            while (m.find(start)) {
                String k = m.group(1);
                if (param.containsKey(k)) {
                    String kk = param.get(k).toString();
                    ret.append(target.subSequence(start, m.start()));
                    ret.append(kk);
                    start = m.end();
                } else {
                    throw new IllegalArgumentException(concat("param ", k, " not set "));
                }
            }
        }
        if (start < target.length()) {
            ret.append(target.substring(start));
        }

        return ret.toString();
    }


}
