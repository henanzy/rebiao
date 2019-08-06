package com.hnzy.hot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hnzy.hot.util.JSONSerializer;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("RzCon")
public class RzController {
	
//	@Autowired
//	private RzService rzService;
	
	@RequestMapping("find")
	public String find(HttpServletRequest request,HttpSession session){
//		 List<Rz> rzList= rzService.find();
//		 String rzListSer=JSONSerializer.serialize(rzList);
//		request.setAttribute("rzListSer", rzListSer);
		 return "rzgl/rz";
	}
	
	//模糊查询日志
//	@RequestMapping("findRz")
//	@ResponseBody
//	public JSONObject findRz(String cz){
//		JSONObject json=new JSONObject();
//		String findCz=JSONSerializer.serialize(rzService.Search(cz));
//		json.put("findCz", findCz);
//		return json;
//	}
}