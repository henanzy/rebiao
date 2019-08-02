package com.hnzy.rb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hnzy.rb.pojo.Qg;

public interface QgDao
{
public List<Qg> findQg();
public Qg findQgID(String qgId);
public List<Qg> findJzq();
//socket 根据区管更新区管ip和端口号
public void updateQgIP(@Param("Ip")String  Ip,@Param("port")Integer port,@Param("jzqId")String jzqId , @Param("recordTime")String recordTime);
//socket 根据区管更新区管状态
public void updateQgSta(@Param("recordTime")String recordTime , @Param("qgId")String qgId );
//根据区管ID查找集中器id

}
