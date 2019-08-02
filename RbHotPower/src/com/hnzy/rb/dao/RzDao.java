package com.hnzy.rb.dao;

import java.util.List;

import com.hnzy.rb.pojo.Rz;

public interface RzDao
{
   //查询日志信息
	public List<Rz> findRz();
	//插入日志
	public void InsRz(Rz rz);
	//模糊查询操作内容
	public List<Rz>findCz(String cz);
}
