package com.hnzy.hot.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hnzy.hot.util.JSONSerializer;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("YcCon")
public class YcController {
//	@Autowired
//	private DataService dataService;
	//搜索报警
	@RequestMapping("findyc")
	public String findyc(HttpServletRequest request,String bj){
		/*List<Map<String, Object>> YcList=dataService.SearchYc(bj);
		request.setAttribute("YcList", JSONSerializer.serialize(YcList));*/	
		return"ycxx/yc";
	}
	
//	@RequestMapping("Searycxx")
//	@ResponseBody
//	public JSONObject Searycxx(String bj){
//		JSONObject json=new JSONObject();
//		List<Map<String, Object>> YcList=dataService.SearchYc(bj);
//		json.put("YcList", JSONSerializer.serialize(YcList));	
//		return json;
//	}
}
