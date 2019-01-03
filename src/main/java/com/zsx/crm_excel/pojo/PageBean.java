package com.zsx.crm_excel.pojo;

import org.apache.poi.ss.formula.functions.T;

import java.util.List;

public class PageBean<T> {
    private int pageIndex; //当前页数
    private int pageSize; //一共页数
    private int count; //数据条数
    private int pageCount; //每页的数据条数
    private int start; //起始数据位置
    private int end; //结束位置
    private List<T> list = null; //数据

    public void init(){
        /*
         * 根据count 和 pageCount 计算页数pageSize
         */
        int pageSize_x = (int)count / pageCount;
        if (count >= pageCount){
            this.pageCount = count % pageCount == 0 ? pageSize_x : pageSize_x + 1;
        }else {
            this.pageSize = 1;
        }
        //判断页数和当前页数
        if (pageIndex > pageSize){
            pageIndex = pageSize;
        }
        if(pageIndex < 1){
            pageIndex = 1;
        }
        //根据当前页计算起始和结束条目
        this.start = (pageIndex - 1) * pageCount + 1;
        this.end = pageIndex * pageCount;
    }

    public PageBean(){
        super();
    }

    public PageBean(int pageIndex, int count, int pageCount) {
        super();
        this.pageIndex = pageIndex;
        this.count = count;
        this.pageCount = pageCount;
    }

    public PageBean(int pageIndex, int count, int pageCount, List<T> list) {
        super();
        this.pageIndex = pageIndex;
        this.count = count;
        this.pageCount = pageCount;
        this.list = list;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", count=" + count +
                ", pageCount=" + pageCount +
                ", start=" + start +
                ", end=" + end +
                ", result=" + list +
                '}';
    }
}
