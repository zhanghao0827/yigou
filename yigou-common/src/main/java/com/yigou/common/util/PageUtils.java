package com.yigou.common.util;


import java.util.ArrayList;
import java.util.List;

public class PageUtils<T> {

    private Integer pageIndex; //当前页码
    private Integer pageSize; //页码大小
    private Integer totalCount; //总条数
    private Integer pageCount; //总页数(计算出来)
    private List<T> records; //每页数据

    //存储页面需要显示的页码
    private List<Integer> numbers = new ArrayList<Integer>();

    //开始序号
    private Integer numberStart = 1;
    //结束的序号
    private Integer numberEnd;

    public PageUtils(Integer pageIndex, Integer pageSize, Integer totalCount, List<T> records) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.records = records;
        //计算总页数
        this.pageCount = (this.totalCount % this.pageSize == 0) ? (this.totalCount / this.pageSize) : (this.totalCount / this.pageSize + 1);


        this.numberStart = 1;
        this.numberEnd = this.pageCount;

        //------------------------------------------------
        //限制页码个数问题
        if (this.pageCount <= 10) {
            //总页数不够10页
            this.numberStart = 1;
            this.numberEnd = this.pageCount;
        } else {
            //超过了10页
            this.numberStart = this.pageIndex - 4;
            this.numberEnd = this.pageIndex + 5;
            //判断前后越界的！！！
            if (this.numberStart < 1) {
                //判断前面越界
                this.numberStart = 1;
                this.numberEnd = 10;
            } else if (this.numberEnd > this.pageCount) {
                //判断后面越界！
                this.numberEnd = this.getPageCount();
                this.numberStart = this.pageCount - 9;
            }
        }
        //------------------------------------------------

        for (int i = this.numberStart; i <= this.numberEnd; i++) {
            numbers.add(i);
        }
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Integer getNumberStart() {
        return numberStart;
    }

    public void setNumberStart(Integer numberStart) {
        this.numberStart = numberStart;
    }

    public Integer getNumberEnd() {
        return numberEnd;
    }

    public void setNumberEnd(Integer numberEnd) {
        this.numberEnd = numberEnd;
    }
}
