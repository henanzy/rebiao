package com.hnzy.rb.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnzy.rb.dao.QgDao;
import com.hnzy.rb.pojo.Qg;
import com.hnzy.rb.service.QgService;

@Service
public class QgServiceImpl implements QgService
{
	@Autowired
    public QgDao qgDao;
	@Override
	public List<Qg> findQg()
	{
		return qgDao.findQg();
	}
	@Override
	public Qg findQgID(String qgId)
	{
		return qgDao.findQgID(qgId);
	}
	@Override
	public List<Qg> findJzq()
	{
		return qgDao.findJzq();
	}
	@Override
	public void updateQgIP(String Ip, Integer port, String jzqId,String recordTime)
	{
		qgDao.updateQgIP(Ip, port, jzqId,recordTime);
	}
	@Override
	public void updateQgSta(String recordTime, String qgId)
	{
		qgDao.updateQgSta(recordTime, qgId);
	}
	
}
