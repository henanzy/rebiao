package com.hnzy.rb.dao;

import java.util.List;

import com.hnzy.rb.base.BaseDao;
import com.hnzy.rb.pojo.Village;


public interface VillageDao extends BaseDao<Village> {

	public List<Village> findValAdByYh(Village village);
	
    public List<Village> findXQ();
	
	public List<Village> findBO(Village village);
	
	public List<Village> findCO(Village village);
	public List<Village>findByXqName(String xqName);
}
