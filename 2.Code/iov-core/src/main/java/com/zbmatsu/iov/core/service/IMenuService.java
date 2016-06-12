package com.zbmatsu.iov.core.service;

import java.util.List;

import com.zbmatsu.iov.common.web.ServiceContext;
import com.zbmatsu.iov.dao.commom.InputParameter;

public interface IMenuService {

	public ServiceContext getMenuList(List<InputParameter> list);
	
	public ServiceContext addMenu(List<InputParameter> list);
}
