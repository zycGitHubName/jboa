package cn.jboa.util;

import java.util.List;

/**
 * 分页工具类，T：要分页的具体类
 * @param <T>
 */
public class PageSupport<T> {

    /**
     * 当前页码
     */
    private int currPageNo;
    /**
     * 每页显示条数
     */
    private int pageSize;
    /**
     * 总页码
     */
    private int totalPageCount;
    /**
     * 总条数
     */
    private int totalCount;

    /**
     * 当前页面要展示的数据集合
     */
    private List<T> items;

    public int getCurrPageNo() {
        return currPageNo;
    }

    public void setCurrPageNo(int currPageNo) {
        this.currPageNo = currPageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPageCount() {
        totalPageCount = this.totalCount % this.pageSize != 0 ? this.totalCount / this.pageSize +1 : this.totalCount / this.pageSize;
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
