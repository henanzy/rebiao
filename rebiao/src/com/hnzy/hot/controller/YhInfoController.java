package com.hnzy.hot.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hnzy.hot.service.YhInfoService;

import net.sf.json.JSONObject;
@Controller
@RequestMapping("yhInfoCon")
public class YhInfoController {
	
	@Autowired
	private YhInfoService yhInfoService;
	
  
	@RequestMapping("/findAll")
	public String findAll(){
//		List<String>xqList=yhInfoService.findXqm();
//		request.setAttribute("xqList",xqList);
		return"Xxgl/yhxx";
	}
	//查找小区名字
	@RequestMapping("findXqName")
	public JSONObject findXq(){
	JSONObject json=new JSONObject();
	List<String> xqList=yhInfoService.findXqName();	
	json.put("xqList",xqList);
		return json;
	}
	//查找楼栋号
	@RequestMapping("findBuildNO")
	public JSONObject findBuildNO(String xqName){
		JSONObject json=new JSONObject();
		List<String> ldList=yhInfoService.findBuildNO(xqName);
		json.put("ldList", ldList);
		return json;
	}
	//查找单元
	@RequestMapping("findCellNO")
	public JSONObject findCellNO(String xqName,String buildNo){
		JSONObject json=new JSONObject();
		List<String> dyList=yhInfoService.findCellNo(xqName, buildNo);
		json.put("dyList", dyList);
		return json;
	}
}