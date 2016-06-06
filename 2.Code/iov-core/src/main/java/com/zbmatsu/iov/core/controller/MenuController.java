package com.zbmatsu.iov.core.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zbmatsu.iov.common.web.BaseController;
import com.zbmatsu.iov.common.web.Message;
import com.zbmatsu.iov.common.web.ServiceContext;
import com.zbmatsu.iov.core.service.IMenuService;

@Controller
@RequestMapping("/Menu")
@ResponseBody
public class MenuController extends BaseController{

	@Autowired
	protected IMenuService menuService;
	
	@RequestMapping(method=RequestMethod.GET)
	public Message index(){
		
		ServiceContext context = new ServiceContext();
		
		List<Map<String, Object>> list = menuService.getMenuList();
		
		context.setReturnList(list);
		
		return context.returnMessage();
	}
}
