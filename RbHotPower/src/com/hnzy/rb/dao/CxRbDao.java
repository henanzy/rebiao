package com.hnzy.rb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hnzy.rb.pojo.CxRb;

public interface CxRbDao
{
	//查询热表地址时根据热表分类更新热表地址和区管地址
  public void update ( @Param("rbAd")String rbAd,@Param("rbfl")Integer rbfl,@Param("qgId")String qgId);
  //查询所有的信息
  public List<CxRb> selectRbId();
  //更新热表地址和区管地址为空值
  public void updateRbId();
}
