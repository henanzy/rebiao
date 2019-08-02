package com.hnzy.rb.dao;


import org.apache.ibatis.annotations.Param;

import com.hnzy.rb.pojo.Jzq;

public interface JzqDao
{
	//根据集中器IP超找jzqID
  public Jzq findJzqID( @Param("jzqIp")String jzqIp,@Param("port")Integer port);
  //Socket根据集中器ID更新状态和时间
  public void updateStTim(@Param("status")String status,@Param("updateTime")String updateTime,@Param("jzqID")String jzqID );
  //Socket根据集中器ID更时间,ip,port
  public void updateIpPort( @Param("jzqIp")String jzqIp,@Param("port")Integer port,@Param("updatTime")String updatTime,@Param("jzqID")String jzqID);
  public void updateIpPortByXt(@Param("jzqIp")String jzqIp,@Param("port")Integer port,@Param("updatTime")String updatTime,@Param("jzqxt")String jzqxt);
}
