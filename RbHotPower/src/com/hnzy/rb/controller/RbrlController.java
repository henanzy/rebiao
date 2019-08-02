package com.hnzy.rb.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.hnzy.rb.pojo.RbName;
import com.hnzy.rb.pojo.RbrlUser;
import com.hnzy.rb.service.RbrlService;

@Controller
@RequestMapping("RbrlCon")
public class RbrlController
{
  @Autowired
  private RbrlService rbrlService;
  private List<RbrlUser> rbrlUsers;
  private List<RbName> rbName;
  //查找实时数据
  @RequestMapping("findRbrlUser")
	public String find(HttpServletRequest request){
	  	rbName=rbrlService.findXqName();
		rbrlUsers=rbrlService.findUserInfo();
		request.setAttribute("yhInfoList", rbName);
		request.setAttribute("rbUs", rbrlUsers);
		return"rbUser";
	}
  
  //查找实时数据1
  @RequestMapping("findRbUser")
	public String findRbUser(HttpServletRequest request){
		rbrlUsers=rbrlService.findUserInfo();
		request.setAttribute("rbUs", rbrlUsers);
		return"rbUserS";
	}
  //搜索实时数据1
  @RequestMapping("SearFInfo")
 	public String SearFInfo(HttpServletRequest request,String xqName,String recordTime1,String recordTime2) throws UnsupportedEncodingException{
	  xqName=new String(xqName.getBytes("ISO-8859-1"),"utf-8")+"";
	  rbrlUsers= rbrlService.SearFindInfo(xqName, recordTime1, recordTime2);
	  request.setAttribute("rbUs",rbrlUsers);
	  return"rbUserS";
 	}
  
  //搜索实时数据
  @ResponseBody
  @RequestMapping("SearFindInfo")
 	public JSONObject SearFindInfo(String xqName,String recordTime1,String recordTime2) throws UnsupportedEncodingException{
	  xqName=new String(xqName.getBytes("ISO-8859-1"),"utf-8")+"";
	  JSONObject jsonObject=new JSONObject();
	  rbrlUsers= rbrlService.SearFindInfo(xqName, recordTime1, recordTime2);
	  jsonObject.put("rbUs", rbrlUsers);
	  return jsonObject;
 	}
  //查找历史数据
  @RequestMapping("fdRbrlUser")
	public String findRb(HttpServletRequest request){
	    rbName=rbrlService.findXqName();
		rbrlUsers=rbrlService.findRbrlUser();
		request.setAttribute("rbUs", rbrlUsers);
		request.setAttribute("yhInfoList", rbName);
		return"rbUserSbb";
	}
  //搜索历史数据
  @RequestMapping("SearFind")
  @ResponseBody
  public JSONObject SearFind(String xqName,String recordTime1,String recordTime2) throws UnsupportedEncodingException{
	  xqName=new String(xqName.getBytes("ISO-8859-1"),"utf-8")+"";
	  JSONObject jsonObject=new JSONObject();
	  rbrlUsers= rbrlService.SearFind(xqName, recordTime1, recordTime2);
	  jsonObject.put("rbUs", rbrlUsers);
	  return jsonObject;
  }
  //导出
  @RequestMapping("RbdoExportExcel")
	@ResponseBody
	public JSONObject RbdoExportExcel(HttpServletRequest request ,HttpServletResponse response, ModelMap map, @Param("xqName") String xqName,
			@Param("recordTime1") String recordTime1,@Param("recordTime2") String recordTime2)
			throws IOException {
		xqName = new String(xqName.getBytes("ISO-8859-1"), "utf-8") + "";
		request.setAttribute("xqName", xqName);
		//告诉浏览器要弹出的文档类型
				response.setContentType("application/x-execl");
				//告诉浏览器这个文档作为附件给别人下载（放置浏览器不兼容，文件要编码）
				response.setHeader("Content-Disposition", "attachment;filename="+new String("用户信息列表.xls".getBytes(),"ISO-8859-1"));
				//获取输出流
			JSONObject jsonObject = new JSONObject();
			ServletOutputStream outputStream=response.getOutputStream();
			rbrlService.exportExcel(rbrlUsers= rbrlService.SearFind("%"+xqName+"%", recordTime1, recordTime2), outputStream);
			if(outputStream!=null){
				outputStream.close();
		}
		return jsonObject;
	}
  
  @RequestMapping("rbrlMe")
  public String rbrlMe(){
	return "rbrl";
  }
  
}
