package com.hnzy.rb.dao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.ibatis.annotations.Param;

import com.hnzy.rb.base.BaseDao;
import com.hnzy.rb.pojo.RbrlUser;

public interface RbrlDao extends BaseDao<RbrlUser>
{
	//查询历史数据
   public List<RbrlUser> findRbrlUser();
   //搜索条件
   public List<RbrlUser> SearFind(@Param("xqName")String xqName,@Param("recordTime1") String recordTime1,@Param("recordTime2") String recordTime2);
   //查询实时数据
   public List<RbrlUser> findUserInfo();
   //搜索实时条件
   public List<RbrlUser> SearFindInfo(@Param("xqName")String xqName,@Param("recordTime1") String recordTime1,@Param("recordTime2") String recordTime2);
   //导出
   public void exportExcel(List<RbrlUser>yhInfosList,ServletOutputStream outputStream) throws IOException;
}
