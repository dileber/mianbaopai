package com.mianbaopailib.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by shidawei on 16/7/17.
 */
public class UIp {

    public static  String getIpAddr(HttpServletRequest request)  {
        String ip  =  request.getHeader( " x-forwarded-for " );
        if (ip  ==   null   ||  ip.length()  ==   0   ||   " unknown " .equalsIgnoreCase(ip))  {
            ip  =  request.getHeader( " Proxy-Client-IP " );
        }
        if (ip  ==   null   ||  ip.length()  ==   0   ||   " unknown " .equalsIgnoreCase(ip))  {
            ip  =  request.getHeader( " WL-Proxy-Client-IP " );
        }
        if (ip  ==   null   ||  ip.length()  ==   0   ||   " unknown " .equalsIgnoreCase(ip))  {
            ip  =  request.getRemoteAddr();
        }
        return  ip;
    }

}
