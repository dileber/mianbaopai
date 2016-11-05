package com.mianbaopailib.model;

/**
 * Created by shidawei on 16/7/18.
 */
public class DataWrapper<T> extends BaseWrapper {

    T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
