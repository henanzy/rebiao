package com.hnzy.rb.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hnzy.rb.pojo.CxRb;

public interface CxRbService
{
	 public void update ( @Param("rbAd")String rbAd,@Param("rbfl")Integer rbfl,@Param("qgId")String qgId);
	  public List<CxRb> selectRbId();
	//更新热表地址和区管地址为空值
	  public void updateRbId();
}
