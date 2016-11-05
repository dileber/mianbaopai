package com.mianbaopailib.model;

import java.util.List;

/**
 * Created by shidawei on 15/12/12.
 */
public class ObjectWrapper<T> extends BaseWrapper{

    /**
     * 记录总数
     */
    private int recordsTotal;
    /**
     * 条件筛选后的记录总数
     */
    private int recordsFiltered;

    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }
}
