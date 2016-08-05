package com.zbmatsu.iov.core.controller;


import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zbmatsu.iov.common.web.BaseController;
import com.zbmatsu.iov.common.web.Message;
import com.zbmatsu.iov.common.web.ServiceContext;
import com.zbmatsu.iov.core.service.IMenuService;


@Controller
@RequestMapping("/Menu")
@ResponseBody
public class MenuController extends BaseController{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	protected IMenuService menuService;
	
	@RequestMapping(method=RequestMethod.GET)
	public Message index(){
		
		logger.info("enter controller /Menu index...");
		
		ServiceContext serviceContext = new ServiceContext();
		
		menuService.getMenuList(serviceContext);
		
		return serviceContext.returnMessage();
	}
	
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public Message add(){
		
		logger.info("enter controller /Menu add...");
		
		String uuid = UUID.randomUUID().toString();
		
		String str = "{\"id\":\"" + uuid + "\",\"name\":\"menuname\",\"type\":\"2\",\"url\":\"url\",\"parentId\":\"124\",\"desc\":\"desc\",\"icon\":\"uuud.png\",\"sort\":7,\"status\":\"1\"}";
		
		JSONObject jsonObject = JSON.parseObject(str);
		
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setParams("params", jsonObject);
		
		menuService.addMenu(serviceContext);
		
		return serviceContext.returnMessage();
	}
}
