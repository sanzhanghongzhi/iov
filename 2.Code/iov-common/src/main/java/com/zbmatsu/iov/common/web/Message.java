package com.zbmatsu.iov.common.web;

/**
 * 
 * @author zhangbei
 *
 */
public class Message {

	public static final String OK = "ok";
	
	/**
	 * 错误码
	 */
	private String errCode = Message.OK;
	/**
	 * 错误信息
	 */
	private String errMessage = "";
	/**
	 * 数据对象
	 */
	private Object datas;

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

	public Object getDatas() {
		if (datas == null) {
			datas = new Object[] {};
		}
		return datas;
	}

	public void setDatas(Object datas) {
		this.datas = datas;
	}
}
