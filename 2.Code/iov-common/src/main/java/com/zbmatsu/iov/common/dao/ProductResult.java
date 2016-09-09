package com.zbmatsu.iov.common.dao;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class ProductResult {

	private JSONObject object;
	private JSONArray list;
	
	
	public JSONObject getObject() {
		return object;
	}
	public void setObject(JSONObject object) {
		this.object = object;
	}
	public JSONArray getList() {
		return list;
	}
	public void setList(JSONArray list) {
		this.list = list;
	}
	
	
}
