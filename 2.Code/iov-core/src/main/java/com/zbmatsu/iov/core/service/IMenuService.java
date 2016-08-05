package com.zbmatsu.iov.core.service;


import com.zbmatsu.iov.common.web.ServiceContext;

public interface IMenuService {

	public boolean getMenuList(ServiceContext serviceContext);
	
	public boolean addMenu(ServiceContext serviceContext);
}
