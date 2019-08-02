package com.hnzy.rb.service.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnzy.rb.dao.RbNameDao;
import com.hnzy.rb.dao.RbrlDao;
import com.hnzy.rb.pojo.RbName;
import com.hnzy.rb.pojo.RbrlUser;
import com.hnzy.rb.service.RbrlService;
import com.hnzy.rb.util.ExcelRlUtilRb;

@Service
public class RbrlServiceImpl implements RbrlService
{

	@Autowired
	private RbrlDao rbrlDao;
	@Autowired
	private RbNameDao rbNameDao;
	@Override
	public List<RbrlUser> findRbrlUser()
	{
		return rbrlDao.findRbrlUser();
	}
	@Override
	public List<RbName> findXqName()
	{
		return rbNameDao.findXqName();
	}
	@Override
	public List<RbrlUser> SearFind(String xqName, String recordTime1, String recordTime2)
	{
		return rbrlDao.SearFind(xqName, recordTime1, recordTime2);
	}
	@Override
	public List<RbrlUser> findUserInfo()
	{
		return rbrlDao.findUserInfo();
	}
	@Override
	public List<RbrlUser> SearFindInfo(String xqName, String recordTime1, String recordTime2)
	{
		return rbrlDao.SearFindInfo(xqName, recordTime1, recordTime2);
	}
	@Override
	public void exportExcel(List<RbrlUser> yhInfosList, ServletOutputStream outputStream) throws IOException
	{
		ExcelRlUtilRb.exportExcel(yhInfosList, outputStream);		
	}

}
