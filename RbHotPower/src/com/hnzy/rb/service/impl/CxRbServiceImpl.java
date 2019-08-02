package com.hnzy.rb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnzy.rb.dao.CxRbDao;
import com.hnzy.rb.pojo.CxRb;
import com.hnzy.rb.service.CxRbService;

@Service
public class CxRbServiceImpl implements CxRbService
{

	@Autowired
	private CxRbDao cxRbDao;

	@Override
	public List<CxRb> selectRbId()
	{
		// TODO Auto-generated method stub
		return cxRbDao.selectRbId();
	}
	@Override
	public void update(String rbAd, Integer rbfl, String qgId)
	{
		cxRbDao.update(rbAd, rbfl, qgId);
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateRbId()
	{
		cxRbDao.updateRbId();
		// TODO Auto-generated method stub
		
	}

}
