package com.hnzy.rb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnzy.rb.dao.VillageDao;
import com.hnzy.rb.pojo.Village;
import com.hnzy.rb.service.VillageService;

@Service
public class VillageServiceImpl implements VillageService {

	@Autowired
	private VillageDao villageDao;
	@Override
	public List<Village> findYhValAd(Village village) {
		return villageDao.findValAdByYh(village);
	}
	@Override
	public List<Village> findXQ() {
		return villageDao.findXQ();
	}
	@Override
	public List<Village> findBOByXQ(Village village) {
		return villageDao.findBO(village);
	}
	@Override
	public List<Village> findCOByXQAndBO(Village village) {
		return villageDao.findCO(village); 
	}
	@Override
	public List<Village> findByXqName(String xqName) {
		return villageDao.findByXqName(xqName);
	}

}
