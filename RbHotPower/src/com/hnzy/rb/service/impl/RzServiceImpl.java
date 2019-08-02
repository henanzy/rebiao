package com.hnzy.rb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnzy.rb.dao.RzDao;
import com.hnzy.rb.pojo.Rz;
import com.hnzy.rb.service.RzService;

@Service
public class RzServiceImpl implements RzService
{
    @Autowired
	private RzDao rzDao;
	@Override
	public List<Rz> findRz()
	{
		return rzDao.findRz();
	}

	@Override
	public void InsRz(Rz rz)
	{
        rzDao.InsRz(rz);		
	}

	@Override
	public List<Rz> findCz(String cz)
	{
		return rzDao.findCz(cz);
	}

}
