package com.hnzy.rb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnzy.rb.dao.JfDao;
import com.hnzy.rb.pojo.Jf;
import com.hnzy.rb.service.JfService;

@Service
public class JfServiceImpl implements JfService{

	@Autowired
	public  JfDao jfDao;

	@Override
	public List<Jf> jfSel() {
		// TODO Auto-generated method stub
		return jfDao.jfSel();
	}

	@Override
	public void updateJf(Jf jf) {
		// TODO Auto-generated method stub
		jfDao.updateJf(jf);
	}

	@Override
	public void insertJf(Jf jf) {
		// TODO Auto-generated method stub
		jfDao.insertJf(jf);
	}
	
}
