package com.zbmatsu.iov.common.web;

import java.util.List;

public class MessageDatas {

	private Object object = null;//普通object
	private List<?> resultList = null;//table 列表
	private Pagination pagination = null;//table 列表分页信息
	
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public List<?> getResultList() {
		return resultList;
	}
	public void setResultList(List<?> resultList) {
		this.resultList = resultList;
	}
	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	
}
