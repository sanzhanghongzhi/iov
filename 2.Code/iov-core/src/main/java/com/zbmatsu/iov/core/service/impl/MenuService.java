package com.zbmatsu.iov.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zbmatsu.iov.common.web.ServiceContext;
import com.zbmatsu.iov.core.exception.IovServiceException;
import com.zbmatsu.iov.core.service.IMenuService;
import com.zbmatsu.iov.dao.commom.InputParameter;
import com.zbmatsu.iov.dao.core.IMenuDao;

@Service("menuService")
public class MenuService implements IMenuService{

	@Autowired
	protected IMenuDao menuDao;
	

	@Override
	public ServiceContext getMenuList(List<InputParameter> list) {
		
		return menuDao.getMenuList(list);
	}

	@Override
	public ServiceContext addMenu(List<InputParameter> list) {
		
		ServiceContext serviceContext = new ServiceContext();
			
		try {
			serviceContext = menuDao.addMenu(list);
		} catch (Exception e) {
			e.printStackTrace();
			throw new IovServiceException("add menu error");
		}
		
		return serviceContext;
	}

}
