package com.zbmatsu.iov.common.web;

import java.util.List;

/**
 * 请求上下文
 * 
 * @author Peter
 */
public class ServiceContext {
	

	private Message message = new Message();
	
	private MessageDatas messageDatas = new MessageDatas();
	


	/**
	 * 设置返回值
	 * 
	 * @param value
	 */
	public void setReturnObject(Object value) {
		messageDatas.setObj(value);
		message.setDatas(messageDatas);
	}
	
	/**
	 * 设置返回值
	 * 
	 * @param value
	 */
	public void setReturnList(List<?> value, Pagination pagination) {
		messageDatas.setPagination(pagination);
		messageDatas.setList(value);
		message.setDatas(messageDatas);
	}
	
	/**
	 * 设置返回值
	 * 
	 * @param value
	 */
	public void setReturnList(List<?> value) {
		messageDatas.setList(value);
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
	
	/**********************************get method**************************/
	
	/**
	 * 获取返回报文
	 * 
	 * @return
	 */
	public Message returnMessage() {
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
		return messageDatas.getObj();
	}
	
	/**
	 * 获取list对象
	 * @return
	 */
	public List<?> getList(){
		return messageDatas.getList();
	}
}

