package com.hnzy.rb.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hnzy.rb.pojo.Qg;
import com.hnzy.rb.pojo.Rb;

public interface QgService
{
	public List<Qg> findQg();
	public Qg findQgID(String qgId);
	public List<Qg> findJzq();
	//socket 根据区管更新区管ip和端口号
		public void updateQgIP(@Param("Ip")String Ip,@Param("port")Integer port,@Param("jzqId")String jzqId, @Param("recordTime")String recordTime);
		//socket 根据区管更新区管状态
		public void updateQgSta(@Param("recordTime")String recordTime , @Param("qgId")String qgId );
		
}
