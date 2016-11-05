package com.mianbaopailib.exception;

import com.mianbaopailib.utils.ULog;

/**
 * Created by shidawei on 16/7/24.
 */
public class BaseException extends Exception{

    public BaseException(String msg){
        super(msg);
    }

    @Override
    public void printStackTrace() {
        //super.printStackTrace();
        ULog.e(getMessage());
    }
}
