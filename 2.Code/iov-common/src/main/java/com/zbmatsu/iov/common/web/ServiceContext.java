package com.zbmatsu.iov.common.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zbmatsu.iov.common.enums.ErrorCodeEnum;

/**
 * 请求上下文
 * 
 * @author Peter
 */
public class ServiceContext {
	

	private Message message = new Message();
	
	private MessageDatas messageDatas = new MessageDatas();
	

	/**
	 * 设置输入参数 
	 * @param key
	 * @param value
	 */
	public void setParams(String key, Object value){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(key, value);
		messageDatas.setInputParams(map);
		message.setDatas(messageDatas);
	}
	
	/**
	 * 设置aop切面参数 
	 * @param key
	 * @param value
	 */
	public void setAspectj(String key, Object value){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(key, value);
		messageDatas.setAspectj(map);
		message.setDatas(messageDatas);
	}

	/**
	 * 设置返回值
	 * 
	 * @param value
	 */
	public void setReturnObject(Object value) {
		messageDatas.setObject(value);
		message.setDatas(messageDatas);
	}
	
	/**
	 * 设置返回值
	 * 
	 * @param value
	 */
	public void setReturnList(List<?> value, Pagination pagination) {
		messageDatas.setPagination(pagination);
		messageDatas.setResultList(value);
		message.setDatas(messageDatas);
	}
	
	/**
	 * 设置返回值
	 * 
	 * @param value
	 */
	public void setReturnList(List<?> value) {
		messageDatas.setResultList(value);
		message.setDatas(messageDatas);
	}
	
	/**
	 * 设置返回值
	 * 
	 * @param value
	 */
	public void setReturnList(Pagination pagination) {
		messageDatas.setPagination(pagination);
		message.setDatas(messageDatas);
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
	public void setMessage(String errCode, String errMsg) {
		message.setErrCode(errCode);
		message.setErrMsg(errMsg);
	}
	
	/**
	 * 设置错误信息
	 * 
	 * @param ErrorCodeEnum  枚举
	 */
	public void setMessage(ErrorCodeEnum errorCodeEnum){
		message.setErrCode(errorCodeEnum.getErrorCode());
		message.setErrMsg(errorCodeEnum.getErrorMessage());;
		
	}
	
	/**********************************get method**************************/
	
	/**
	 * 获取输入参数值
	 * 
	 * @param name
	 * @return
	 */
	public Object getParam(String name) {
		return messageDatas.getInputParams().get(name);
	}
	
	/**
	 * 获取aop切面参数值
	 * 
	 * @param name
	 * @return
	 */
	public Object getAspectj(String name) {
		return messageDatas.getAspectj().get(name);
	}
	
	/**
	 * 获取返回报文
	 * 清空inputParams
	 * @return
	 */
	public Message returnMessage() {
		messageDatas.setInputParams(null);//清空inputParams
		message.setDatas(messageDatas);
		return message;
	}
	
	
	/**
	 * 获取errCode
	 * @return
	 */
	public String getErrCode(){
		return message.getErrCode();
	}
	
	
	/**
	 * 获取errMsg
	 * @return
	 */
	public String getErrMsg(){
		return message.getErrMsg();
	}
	
	/**
	 * 获取obj对象
	 * @return
	 */
	public Object getObj(){
		return messageDatas.getObject();
	}
	
	/**
	 * 获取list对象
	 * @return
	 */
	public List<?> getList(){
		return messageDatas.getResultList();
	}
}

