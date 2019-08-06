package com.hnzy.hot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnzy.hot.dao.YhInfoDao;
import com.hnzy.hot.service.YhInfoService;
@Service
public class YhInfoServiceImpl implements YhInfoService{
	@Autowired
   private YhInfoDao yhInfoDao;

	@Override
	public List<String> findXqName() {
		// TODO Auto-generated method stub
		return yhInfoDao.findXqName();
	}

	@Override
	public List<String> findBuildNO(String xqName) {
		// TODO Auto-generated method stub
		return yhInfoDao.findBuildNO(xqName);
	}

	@Override
	public List<String> findCellNo(String xqName, String buildNo) {
		// TODO Auto-generated method stub
		return yhInfoDao.findCellNo(xqName, buildNo);
	}
}
