package com.hnzy.rb.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.hnzy.rb.pojo.Rz;
import com.hnzy.rb.service.RzService;

@RequestMapping("RzCon")
@Controller
public class RzController
{

	@Autowired
	private RzService rzService;
	private List<Rz> RzList;
	@RequestMapping("rzList")
	public String rzList(HttpServletRequest request){
		RzList=rzService.findRz();
		request.setAttribute("RzList",RzList);
		return "rzList";
		
	}
	@ResponseBody
	@RequestMapping("SelCzList")
	public JSONObject SelCzList(String cz) throws UnsupportedEncodingException{
		cz = new String(cz.getBytes("ISO-8859-1"), "utf-8") + "";
		JSONObject jsonObject=new JSONObject();
		RzList=rzService.findCz("%"+cz+"%");
		jsonObject.put("RzList",RzList);
		return jsonObject;
	}
	public List<Rz> getRzList()
	{
		return RzList;
	}
	public void setRzList(List<Rz> rzList)
	{
		RzList = rzList;
	}
	
}
