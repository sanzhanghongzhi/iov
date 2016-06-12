package com.zbmatsu.iov.dao.commom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zbmatsu.iov.common.web.ServiceContext;

public class PostgresqlUtils {

	/**
	 * 将postgresql 函数 返回的json对象 转成  PostgresqlOutput 对象
	 * @param jsonObject
	 * @return
	 */
	public static ServiceContext parse(JSONObject jsonObject){
		
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setMessage(jsonObject.getString("err_code"), jsonObject.getString("err_msg"));
		serviceContext.setReturnObject(getObjByJson((JSONObject)jsonObject.get("obj")));
		serviceContext.setReturnList(getListByJson((JSONArray)jsonObject.get("list")));
		
		return serviceContext;
	}
	
	
	

	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		String jsonStr = "{list:[{ab_cd_kgh:\"ffff\",asd:\"tttt\"},{ab_cd_kgh:\"dddd\",asd:\"zzzz\"}],obj:{ab_obj_test:\"凌空垫射\",asd_func:\"第三方\"},err_code:0,err_msg:\"没错\"}";
		
		JSONObject jsonObject = JSON.parseObject(jsonStr);
		
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setReturnObject(getObjByJson((JSONObject)jsonObject.get("obj")));
		serviceContext.setReturnList(getListByJson((JSONArray)jsonObject.get("list")));
		
		System.out.println(serviceContext.getErrCode());
		System.out.println(serviceContext.getErrMsg());
		System.out.println(serviceContext.getObj());
		System.out.println(serviceContext.getList());
		
		System.out.println(jsonObject);
			
	}
	
	
	/**
	 * 只支持1层目录
	 * @return
	 */
	private static Map<String, Object> getObjByJson(JSONObject jsonObject){
		
		//如果没有 jsonObject 则返回 null
		if(jsonObject == null)
			return null;
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		for (Iterator<?> iterator = jsonObject.entrySet().iterator(); iterator.hasNext();) {
			
			@SuppressWarnings("unchecked")
			Entry<String, Object> entry = (Entry<String, Object>) iterator.next();
			
			String key = getKey(entry.getKey());
			Object value = entry.getValue();
			
			map.put(key, value);
			//System.out.println(key + "::::" + value);
		}
		
		return map;
	}
	
	
	/**
	 * 获取list对象 只能支持1层目录
	 * @return
	 */
	private static List<Map<String, Object>> getListByJson(JSONArray jsonArray){
		
		//如果list为空 返回null
		if(jsonArray == null)
			return null;
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		for (int i = 0; i < jsonArray.size(); i++) {
			
			JSONObject jsonObject = (JSONObject) jsonArray.get(i);
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map = getObjByJson(jsonObject);
			
			list.add(map);
			
			//System.out.println(map);
			
		}
		return list;
	}
	
	/**
	 * 将key进行转换  abc_def_ghi => abcDefGhi
	 * @param _key
	 * @return
	 */
	private static String getKey(String _key){
		
		String key = _key;
		
		if(_key.indexOf("_") != -1){
			
			StringBuffer sb = new StringBuffer();
			
			String[] keys = _key.split("_");
			
			for (int i = 0; i < keys.length; i++) {
				
				if(i == 0)
					sb.append(keys[i]);
				if(i>0){
					sb.append(keys[i].substring(0, 1).toUpperCase());
					sb.append(keys[i].substring(1, keys[i].length()));
				}
				
			}
			key = sb.toString();
		}
		
		return key;
	}
	
}
