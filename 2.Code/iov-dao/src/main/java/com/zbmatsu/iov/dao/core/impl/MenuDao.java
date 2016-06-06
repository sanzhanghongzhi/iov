package com.zbmatsu.iov.dao.core.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zbmatsu.iov.dao.commom.BaseDao;
import com.zbmatsu.iov.dao.core.IMenuDao;

@Repository("menuDao")
public class MenuDao extends BaseDao implements IMenuDao{

	
	@Override
	public List<Map<String, Object>> getAll() {
		
		List<Map<String, Object>> list = 
				this.jdbcTemplate.queryForList("select * from iov_menu");
		
		return list;
	}

}
