package com.zbmatsu.iov.common.enums;

public enum ErrorCodeEnum {

	_UNKNOW("unknow", "unknow Exception"),
	_OK("ok", ""),
	_200("200", ""),
	_201("201", ""),
	_400("400", "HTTP 400 Exception"),
	_404("404", "HTTP 404 Exception"),
	_500("500", "HTTP 500 Exception"),
	_505("505", "HTTP 505 Exception"),
	_DRIVER0001("DRIVER001", "add driver Exception");
	
	private String errorCode;
	private String errorMessage;

	private ErrorCodeEnum(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public static ErrorCodeEnum getErrorCodeEnum(String errorCode){
		for (ErrorCodeEnum e : ErrorCodeEnum.values()) {
            if (e.getErrorCode().equals(errorCode)) {
                return e;
            }
        }
		return _UNKNOW;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
