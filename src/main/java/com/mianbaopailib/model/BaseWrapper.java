package com.mianbaopailib.model;

/**
 * Created by shidawei on 16/7/13.
 */
public class BaseWrapper {

    Integer state;
    String msg;

    public BaseWrapper() {
    }

    public BaseWrapper(String msg, int i) {
        this.msg = msg;
        this.state = i;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
