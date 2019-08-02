package com.hnzy.rb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnzy.rb.dao.CsTimeDao;
import com.hnzy.rb.pojo.CsTime;
import com.hnzy.rb.service.CsTimeService;

@Service
public class CsTimeServiceImpl implements CsTimeService
{
	@Autowired
	private CsTimeDao csTimeDao;
	@Override
	public  List<CsTime> findCsTime()
	{
		return csTimeDao.findCsTime();
	}

	@Override
	public void updCsTime(String csTime)
	{
		csTimeDao.updCsTime(csTime);
	}

	@Override
	public void updCsTime1(String cstime)
	{
		csTimeDao.updCsTime1(cstime);
	}

}
