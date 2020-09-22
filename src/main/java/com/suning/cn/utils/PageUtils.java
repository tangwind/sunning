package com.suning.cn.utils;

import lombok.Data;

import java.util.Collection;

@Data
public class PageUtils<T> {

    //当前页
    private int currentPage;
    //
    private int pageNo;
    //
    private Integer pageSize =15;
    //
    private long totalPage;
    //
    private long totalCount;
    //
    private Collection<T> currentList;

    /**
     * 手动get，set
     */
    public int getPageNo() {
        return (pageNo - 1) * pageSize;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public long getTotalPage() {
        return totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

}

