package com.hnzy.rb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnzy.rb.dao.RbJsDao;
import com.hnzy.rb.pojo.RbJs;
import com.hnzy.rb.service.RbJsService;
@Service
public class RbJsServiceImpl implements RbJsService{
	@Autowired
	private RbJsDao rbJsDao;
	@Override
	public List<RbJs> findRbJs() {
		// TODO Auto-generated method stub
		return rbJsDao.findRbJs();
	}

}
