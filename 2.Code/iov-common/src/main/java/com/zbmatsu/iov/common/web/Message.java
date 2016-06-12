package com.zbmatsu.iov.common.web;

/**
 * 
 * @author zhangbei
 *
 */
public class Message {

	public static final String OK = "0";
	
	/**
	 * 错误码
	 */
	private String errCode = Message.OK;
	/**
	 * 错误信息
	 */
	private String errMsg = "";
	/**
	 * 数据对象
	 */
	private MessageDatas datas = new MessageDatas();

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public MessageDatas getDatas() {
		
		return datas;
	}

	public void setDatas(MessageDatas datas) {
		this.datas = datas;
	}
}
