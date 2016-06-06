package com.zbmatsu.iov.core.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zbmatsu.iov.core.service.IMenuService;
import com.zbmatsu.iov.dao.core.IMenuDao;

@Service("menuService")
public class MenuService implements IMenuService{

	@Autowired
	protected IMenuDao menuDao;
	
	@Override
	public List<Map<String, Object>> getMenuList() {
		
		List<Map<String, Object>> list = menuDao.getAll();
		
		return list;
	}

}
