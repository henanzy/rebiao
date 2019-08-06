package com.hnzy.hot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface YhInfoDao {
	
	public List<String>findXqName();
	public List<String>findBuildNO(String xqName);
	public List<String>findCellNo(@Param("xqName")String xqName,@Param("buildNo")String buildNo);
}
