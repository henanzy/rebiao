package com.hnzy.hot.controller;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hnzy.hot.util.JSONSerializer;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("JzqCon")
public class JzqController {

//	@Autowired
//	private JzqService jzqService;
//	@Autowired
//	private RzService rzService;
//	
//	private Rz rz;
	//查找集中器信息
	@RequestMapping("find")
	public String find(HttpServletRequest request){
		/*String findJzq=JSONSerializer.serialize(jzqService.find());
		request.setAttribute("findJzq",findJzq);*/
		return "Xxgl/jzq";
	}
	//新增
	/*@RequestMapping("addJzq")
	public String addJzq(Jzq jzq,HttpSession session){
		rz =new Rz();
		rz.setCz("添加集中器表"+jzq.getJzqip());
		rz.setCzr((String) session.getAttribute("UserName"));
		rz.setCzsj(new Date());
		rzService.Insert(rz);
		jzqService.addJzq(jzq);
		return "redirect:find.action";
	}
	//修改
	@RequestMapping("updateJzq")
	public String updateJzq(Jzq jzq,HttpSession session){
		rz =new Rz();
		rz.setCz("更新集中器表"+jzq.getJzqip());
		rz.setCzr((String) session.getAttribute("UserName"));
		rz.setCzsj(new Date());
		rzService.Insert(rz);
		jzqService.updateJzq(jzq);
		return "redirect:find.action";
	}
	//删除
	@ResponseBody
	@RequestMapping("deleteJzq")
	public JSONObject deleteJzq(String jzqnet,HttpSession session){
		JSONObject json =new JSONObject();
		rz =new Rz();
		rz.setCz("删除集中器");
		rz.setCzr((String) session.getAttribute("UserName"));
		rz.setCzsj(new Date());
		rzService.Insert(rz);
	 int i=	jzqService.deleteJzq(jzqnet);
	 if(i==1){
		 json.put("data",1);
	 }else{
		 json.put("data",0); 
	 }
	 return json;
	}*/
}
