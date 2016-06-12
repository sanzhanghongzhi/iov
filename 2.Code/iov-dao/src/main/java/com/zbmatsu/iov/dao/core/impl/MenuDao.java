package com.zbmatsu.iov.dao.core.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zbmatsu.iov.common.web.ServiceContext;
import com.zbmatsu.iov.dao.commom.BaseDao;
import com.zbmatsu.iov.dao.commom.InputParameter;
import com.zbmatsu.iov.dao.core.IMenuDao;

@Repository("menuDao")
public class MenuDao extends BaseDao implements IMenuDao{

	@Override
	public ServiceContext getMenuList(List<InputParameter> list) {
		
		String funcName = "menu_get";
		
		return super.callPostgresqlFunction(funcName, list);
	}

	@Override
	public ServiceContext addMenu(List<InputParameter> list) {
		
		String funcName = "menu_add";
		
		return super.callPostgresqlFunction(funcName, list);
	}

}
