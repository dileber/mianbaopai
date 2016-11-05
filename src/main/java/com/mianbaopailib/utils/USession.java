package com.mianbaopailib.utils;

import com.mianbaopailib.exception.SessionException;
import org.omg.CORBA.UserException;

import javax.servlet.http.HttpSession;

/**
 * Created by shidawei on 16/7/19.
 */
public class USession {

    public static <T>T getSession(HttpSession session,String seesionName) throws SessionException {
        if(seesionName==null){
            throw new SessionException("sessionName不能为空");
        }
        Object o = session.getAttribute(seesionName);
        if(o == null){
            throw new SessionException("session没有该值");
        }
        return (T)o;
    }

}
