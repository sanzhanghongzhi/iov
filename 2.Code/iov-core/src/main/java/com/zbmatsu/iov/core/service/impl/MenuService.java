package com.zbmatsu.iov.core.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.zbmatsu.iov.common.web.ServiceContext;
import com.zbmatsu.iov.core.service.IMenuService;
import com.zbmatsu.iov.dao.commom.ProductNameEnum;
import com.zbmatsu.iov.dao.commom.ProductResult;

@Service("menuService")
public class MenuService extends BaseService implements IMenuService{

	
	@Override
	public boolean getMenuList(ServiceContext serviceContext) {
		
		ProductResult result = baseDao.callPostgresqlFunction(ProductNameEnum.MENU_GET, null);
		
		serviceContext.setReturnList(result.getList());
		
		return true;
	}

	@Transactional
	@Override
	public boolean addMenu(ServiceContext serviceContext) {
		
		JSONObject jsonObject = (JSONObject)serviceContext.getParam("params");
		
		baseDao.callPostgresqlFunction(ProductNameEnum.MENU_ADD, jsonObject);
		return true;
	}
		
}
