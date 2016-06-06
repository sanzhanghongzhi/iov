package com.zbmatsu.iov.common.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请求上下文
 * 
 * @author Peter
 */
public class ServiceContext {
	
	private Map<String, Object> params = new HashMap<String, Object>();

	private Message message = new Message();
	
	public Map<String, Object> getParams() {
		return params;
	}
	
	/**
	 * 存放参数
	 * 
	 * @param name
	 * @param value
	 */
	public void putParam(String name, Object value) {
		params.put(name, value);
	}

	/**
	 * 获取参数值
	 * 
	 * @param name
	 * @return
	 */
	public Object getParam(String name) {
		return params.get(name);
	}

	/**
	 * 获取返回值
	 * 
	 * @return
	 */
	public Object returnValue() {
		return message.getDatas();
	}

	/**
	 * 获取返回报文
	 * 
	 * @return
	 */
	public Message returnMessage() {
		return message;
	}

	/**
	 * 设置返回值
	 * 
	 * @param value
	 */
	public void setReturnObject(Object value) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("obj", value);
		message.setDatas(map);
	}
	
	/**
	 * 设置返回值
	 * 
	 * @param value
	 */
	public void setReturnList(List<?> value, Pagination pagination) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pagination", pagination);
		map.put("list", value);
		message.setDatas(map);
	}
	
	/**
	 * 设置返回值
	 * 
	 * @param value
	 */
	public void setReturnList(List<?> value) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", value);
		message.setDatas(map);
	}

	/**
	 * 设置错误信息
	 * 
	 * @param errCode
	 */
	public void setMessage(String errCode) {
		message.setErrCode(errCode);
	}

	/**
	 * 设置错误信息
	 * 
	 * @param errCode
	 * @param errDesc
	 */
	public void setMessage(String errCode, String errDesc) {
		message.setErrMessage(errDesc);
		message.setErrCode(errCode);
	}
}

