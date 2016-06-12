package com.zbmatsu.iov.core.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zbmatsu.iov.common.web.BaseController;
import com.zbmatsu.iov.common.web.Message;
import com.zbmatsu.iov.common.web.ServiceContext;
import com.zbmatsu.iov.core.service.IMenuService;
import com.zbmatsu.iov.dao.commom.InputParameter;


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
		
		ServiceContext serviceContext = menuService.getMenuList(null);
		
		return serviceContext.returnMessage();
	}
	
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public Message add(){
		
		logger.info("enter controller /Menu add...");
		
		List<InputParameter> list = new ArrayList<InputParameter>();
		list.add(new InputParameter(1,String.class,"128"));
		list.add(new InputParameter(2,String.class,"menuname"));
		list.add(new InputParameter(3,String.class,"2"));
		list.add(new InputParameter(4,String.class,"jjj/index"));
		list.add(new InputParameter(5,String.class,"124"));
		list.add(new InputParameter(6,String.class,"desc"));
		list.add(new InputParameter(7,String.class,"uuu/add.png"));
		list.add(new InputParameter(8,Integer.class,7));
		list.add(new InputParameter(9,String.class,"1"));
		
		
		ServiceContext serviceContext = new ServiceContext();
		try {
			serviceContext = menuService.addMenu(list);
		}catch (Exception e){
			serviceContext.setMessage("1", e.getMessage());
		}
		
		return serviceContext.returnMessage();
	}
}
