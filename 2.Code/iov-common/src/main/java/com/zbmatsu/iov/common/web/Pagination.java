package com.zbmatsu.iov.common.web;

import java.io.Serializable;

/**
 * 
 * @author zhangbei
 *
 */
public class Pagination implements Serializable {

    /**
	 * UID
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Limits the number of results in the response.
     */
    private Integer           pageSize         = 15;

    /**
     * Determine the page index, begin from 1
     */
    private Integer           pageIndex        = 1;

    /**
     * determines the field by witch to sort the result list
     */
    private String            sortField;

    /**
     * “asc”-Ascending or “desc”-Descending
     */
    private String            direction;

    /**
     * Determine the start of record
     */
    private Integer           start;

    /**
     * totleSize of the query don't have pageSize and pageIndex
     */
    private Integer           totleSize        = 0;

    public Pagination() {
    };

    public Pagination(Integer pageSize, Integer pageIndex, String sortField, String direction) {
        if(pageSize != null){
            this.pageSize = pageSize;
        }
        
        if(pageIndex != null){
            this.pageIndex = pageIndex;
        }
        
        if(sortField != null){
            this.sortField = sortField;
        }
        
        if(direction != null){
            this.direction = direction;
        }
        
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getStart() {
        if (start == null && pageIndex != null && pageSize != null) {
            start = (pageIndex - 1) * pageSize;
        }
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getTotleSize() {
        return totleSize;
    }

    public void setTotleSize(Integer totleSize) {
        this.totleSize = totleSize;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Pagination [pageSize=");
        builder.append(pageSize);
        builder.append(", pageIndex=");
        builder.append(pageIndex);
        builder.append(", sortField=");
        builder.append(sortField);
        builder.append(", direction=");
        builder.append(direction);
        builder.append(", start=");
        builder.append(start);
        builder.append(", totleSize=");
        builder.append(totleSize);
        builder.append("]");
        return builder.toString();
    }
    public String toURLString() {
        StringBuilder builder = new StringBuilder();
        builder.append("pageSize=");
        builder.append(pageSize);
        builder.append("&pageIndex=");
        builder.append(pageIndex);
        builder.append("&sortField=");
        builder.append(sortField);
        builder.append("&direction=");
        builder.append(direction);
        builder.append("&start=");
        builder.append(start);
        builder.append("&totleSize=");
        builder.append(totleSize);
        return builder.toString();
    }
}
