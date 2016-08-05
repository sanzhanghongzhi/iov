package com.zbmatsu.iov.common.web;

import java.util.List;
import java.util.Map;

public class MessageDatas {

	private Object object = null;//普通object
	private List<?> resultList = null;//table 列表
	private Pagination pagination = null;//table 列表分页信息
	private Map<String, Object> inputParams = null;//从controller到service的参数 
	private Map<String, Object> aspectj = null;//aop切面信息
	
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
	public Map<String, Object> getInputParams() {
		return inputParams;
	}
	public void setInputParams(Map<String, Object> inputParams) {
		this.inputParams = inputParams;
	}
	public Map<String, Object> getAspectj() {
		return aspectj;
	}
	public void setAspectj(Map<String, Object> aspectj) {
		this.aspectj = aspectj;
	}
	
}
