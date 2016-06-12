package com.zbmatsu.iov.dao.core;

import java.util.List;

import com.zbmatsu.iov.common.web.ServiceContext;
import com.zbmatsu.iov.dao.commom.InputParameter;

public interface IMenuDao{
	
	/**
	 * get all
	 * @param list
	 * @return
	 */
	public ServiceContext getMenuList(List<InputParameter> list);
	
	/**
	 * add
	 * @param list
	 * @return
	 */
	public ServiceContext addMenu(List<InputParameter> list);
	
}
