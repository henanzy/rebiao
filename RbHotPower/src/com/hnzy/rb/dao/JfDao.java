package com.hnzy.rb.dao;

import java.util.List;

import com.hnzy.rb.pojo.Jf;

public interface JfDao {

	public List<Jf> jfSel();
	
	public void updateJf(Jf jf);//更新缴费系统
	public void insertJf(Jf jf);//插入缴费系统
}
