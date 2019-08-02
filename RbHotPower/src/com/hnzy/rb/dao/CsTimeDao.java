package com.hnzy.rb.dao;

import java.util.List;

import com.hnzy.rb.pojo.CsTime;

public interface CsTimeDao
{
	//获取抄表设定的时间
	public List<CsTime> findCsTime();
	//更新抄表设定的时间
	public void updCsTime(String cstime);
	public void updCsTime1(String cstime);
}
