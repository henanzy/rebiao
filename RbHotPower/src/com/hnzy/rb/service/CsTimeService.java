package com.hnzy.rb.service;

import java.util.List;

import com.hnzy.rb.pojo.CsTime;

public interface CsTimeService
{
	    //获取抄表设定的时间
		public  List<CsTime> findCsTime();
		//更新抄表设定的时间
		public void updCsTime(String csTime);
		public void updCsTime1(String cstime);
}
