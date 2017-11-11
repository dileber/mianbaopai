package com.mianbaopailib;

/**
 * Created by shidawei on 16/7/13.
 */
public class AppConstant {

    public static final String SESSION_MUTEX = "session_mutex_lock";

    private boolean info;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isInfo() {
        return info;
    }

    public void setInfo(boolean info) {
        this.info = info;
    }
}
