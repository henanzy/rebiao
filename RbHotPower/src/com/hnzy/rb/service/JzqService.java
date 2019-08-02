package com.hnzy.rb.service;

import org.apache.ibatis.annotations.Param;

import com.hnzy.rb.pojo.Jzq;

public interface JzqService
{
	//根据集中器IP超找jzqID
	  public Jzq findJzqID(String jzqIp,Integer port);
	  //Socket根据集中器ID更新状态和时间
	  public void updateStTim(String status,String updateTime,String jzqID);
	  //Socket根据集中器ID更时间,ip,port
	  public void updateIpPort(String IP,Integer port,String updateTime,String jzqID);
	  public void updateIpPortByXt(@Param("jzqIp")String jzqIp,@Param("port")Integer port,@Param("updatTime")String updatTime,@Param("jzqxt")String stringH);
}
