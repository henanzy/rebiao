package com.hnzy.hot.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface YhInfoService {
	public List<String>findXqName();
	public List<String>findBuildNO(String xqName);
	public List<String>findCellNo(@Param("xqName")String xqName,@Param("BuildNo")String buildNo);
}
