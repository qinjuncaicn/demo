package com.qjc.utils;

import java.util.List;

/**
 * @author
 * @description: datatables分页 返回前端格式
 * @create 2018/04/21 14:35
 */
public class DatatablesView<T> {

    /**
     * data 与datatales 加载的“dataSrc"对应
     */
    private List<T> data;

    /**
     * 总页数
     */
    private Long recordsTotal;

    /**
     * 总记录数
     */
    private Long recordsFiltered;

    /**
     * draw属性，必须跟前台需要的draw一致
     */
    private int draw;

    public DatatablesView() {

    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Long recordsTotal) {
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsTotal;
    }

    public Long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }
}