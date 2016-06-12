package com.zbmatsu.iov.dao.commom;

public class InputParameter {

	private int index;
	private Class<?> clazz;
	private Object value;
	

	public InputParameter() {
		super();
	}

	
	public InputParameter(int index, Class<?> clazz, Object value) {
		super();
		this.index = index;
		this.clazz = clazz;
		this.value = value;
	}



	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	public Class<?> getClazz() {
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
}
