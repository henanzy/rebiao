package com.hnzy.rb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnzy.rb.dao.JzqDao;
import com.hnzy.rb.pojo.Jzq;
import com.hnzy.rb.service.JzqService;

@Service
public class JzqServiceImpl implements JzqService
{
	@Autowired
	private JzqDao jzqDao;

	@Override
	public Jzq findJzqID(String jzqIp, Integer port)
	{
		return jzqDao.findJzqID(jzqIp,port);
	}


	@Override
	public void updateStTim(String status, String updateTime, String jzqID)
	{
		jzqDao.updateStTim(status, updateTime, jzqID);
	}

	@Override
	public void updateIpPort(String IP, Integer port, String updateTime, String jzqID)
	{
		jzqDao.updateIpPort(IP, port, updateTime, jzqID);
	}


	@Override
	public void updateIpPortByXt(String jzqIp, Integer port, String updatTime, String jzqxt) {
		// TODO Auto-generated method stub
		jzqDao.updateIpPortByXt(jzqIp, port, updatTime, jzqxt);
	}

}
