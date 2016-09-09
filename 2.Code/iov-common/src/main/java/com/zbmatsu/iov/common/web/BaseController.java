package com.zbmatsu.iov.common.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.zbmatsu.iov.common.dao.ProductRequest;
import com.zbmatsu.iov.common.enums.ProductNameEnum;

@Controller
public class BaseController {

	@Autowired
	protected ProductRequest productRequest;
	
	public Object requestPGFunc(ProductNameEnum funcName, JSONObject parameter){
		return productRequest.callPostgresqlFunction(funcName, parameter);
	}
}
