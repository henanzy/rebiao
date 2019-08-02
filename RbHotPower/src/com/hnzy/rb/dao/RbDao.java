package com.hnzy.rb.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.hnzy.rb.base.BaseDao;
import com.hnzy.rb.pojo.Rb;

public interface RbDao extends BaseDao<Rb>
{
	
	//查找所有信息
     public List<Rb> findRbAll(@Param("xqName")String xqName,@Param("rbLyName")String rbLyName,@Param("cellNO")String cellNO,@Param("houseNO")String houseNO ,@Param("rbfl") Integer rbfl);
	//根据树形图查询信息
	 public List<Rb> findRb(@Param("xqName")String xqName,@Param("rbLyName")String rbLyName,@Param("cellNO")String cellNO,@Param("houseNO")String houseNO );
	 //显示信息
	 public List<Rb> find();
	  //搜索数据报表
     public List<Rb> searchSbb(@Param("xqName")String xqName,@Param("rbLyName")String rbLyName,@Param("cellNo")String cellNo,@Param("houseNo")String houseNo,@Param("recordTime1") String recordTime1,@Param("recordTime2") String recordTime2,@Param("rbfl") Integer rbfl);
	  //搜索历史数据
	 public List<Rb> searchHis(@Param("xqName")String xqName,@Param("rbLyName")String rbLyName,@Param("cellNo")String cellNo,@Param("houseNo")String houseNo,@Param("recordTime1") String recordTime1,@Param("recordTime2") String recordTime2);
	//搜索历史数据
	 public List<Rb> searchHisExcel(@Param("xqName")String xqName,@Param("rbLyName")String rbLyName,@Param("cellNo")String cellNo,@Param("houseNo")String houseNo,@Param("recordTime1") String recordTime1,@Param("recordTime2") String recordTime2);
	 //热表异常
	 public List<Rb> SbSelExp(@Param("gs")Double gs,@Param("hs")Double hs,@Param("wc")Integer wc);
	  //热表有瞬时流量，供水温度大于40，回水温度大于30度，累计热量不累加
	 public List<Rb> SelRbExp();
	  //查询热表前两条
	 public List<Rb> SelRbEp(@Param("rbAd")String rbAd);
	 //更新热表异常数据
	 public void UpExp(@Param("rbAd")String rbAd,@Param("rbExp") int rbExp);
	 //根据热表iD查找用户信息
	 public Rb findById(@Param("id")String id);
	 //更新信息
	 public void UpdaSb();
	 //更新数据用户名和热表地址
	 public void UpSbxx(Rb rb);
	 //更新热表地址
	 public void UpRbVal(Rb rb);
	 //根据热表id查找信息
	 public Rb findByRbAd(@Param("rbAd")String rbAd);
	 //根据小区楼栋单元户号获取用户备注信息
	 public Rb findBzxx(@Param("xqName")String xqName,@Param("rbLyName")String rbLyName,@Param("cellNO")String cellNO,@Param("houseNO")String houseNO );
	 //根据小区楼栋单元户号更新用户备注信息
	 public void Upbz(@Param("bz")String bz,@Param("xqName")String xqName,@Param("rbLyName")String rbLyName,@Param("cellNO")String cellNO,@Param("houseNO")String houseNO);
	 //根据小区楼栋单元户号搜索热表地址
	 public List<Rb> SelRbAd(@Param("xqName")String xqName,@Param("rbLyName")String rbLyName,@Param("cellNO")String cellNO,@Param("houseNO")String houseNO );
	 //更具热表地址查找信息
	 public List<Rb> SelRb(@Param("RbAd")String RbAd,@Param("recordTime")String date);
	 //搜索数据报表在时间内的数据
	 public List<Rb> findRbHis(@Param("recordTime1") String recordTime1,@Param("recordTime2") String recordTime2);
	 //根据热表地址修改备注信息
	 public void upRbbz(@Param("rbAd")String rbAd,@Param("bz")String bz);
	 //微信 Socket根据阀门地址查找信息
	 public Rb findWxxByFmId(@Param("fmId") String fmId);
	 // socket更新热表信息 
	 public void updateRbById(Rb rb);
	 //socket插入历史热表信息
	 public void InsertRbHis(Rb rb);
	 //今日抄表用户
	 public List<Rb> JrCb(@Param("xqName")String xqName,@Param("rbLyName")String rbLyName,@Param("cellNo")String cellNo,@Param("time") String time);
	 //今日未抄表
	 public List<Rb> JrWCb(@Param("xqName")String xqName,@Param("rbLyName")String rbLyName,@Param("cellNo")String cellNo,@Param("time") String time);
	 //更新热表热表地址
	 public void updateRbAd(@Param("rbAd")String rbAd ,@Param("xrbAd")String xrbAd );
	 //更新用户热表地址
	 public void updateYhRbAd(@Param("rbAd")String rbAd ,@Param("xrbAd")String xrbAd);
	 //插入热表id表中
	 public void InsertRbId(@Param("rbAd")String rbAd ,@Param("recordTime")String recordTime);
	 //删除热表地址
	 public void DeleteRbId();
	 //查询热表地址
	 public List<Rb> findRbId();
	 //根据区管地址查找热表分类
	 public Rb findRbflByQgId(String qgId);
	 //查找用户的故障信息
	 public List<Rb> findRbGzxx(String status);
	//根据区管地址查找热表分类
    public List<Rb> findRbYh(String qgId);
    //查找热表类别
    public List<Rb>findRblb(String qgId);
}
