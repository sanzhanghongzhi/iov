package com.zbmatsu.iov.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.zbmatsu.iov.dao.commom.BaseDao;

public class BaseService {

	@Autowired
	protected BaseDao baseDao;
}
