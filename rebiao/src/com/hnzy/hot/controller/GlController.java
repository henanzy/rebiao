package com.hnzy.hot.controller;

import java.util.Date;
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
@RequestMapping("glb")
public class GlController {
	
//	@Autowired
//	private GlService GlService;
//	
//	@Autowired
//	private RzService rzService;
//	
//	private Rz rz;
//	
//	@RequestMapping("/findAll")
//	public String findAll(HttpServletRequest request,HttpSession session){
//		
//		List<Gl> glLsit = GlService.find();
//		String glLsitSer=JSONSerializer.serialize(glLsit);
//		request.setAttribute("glLsit", glLsitSer);
//		return"Xxgl/glbxx";
//	}
//	
//	@RequestMapping("/addGl")
//	public String addYh(Gl gl,HttpServletRequest request,HttpSession session){
//		GlService.Insert(gl);
//		rz =new Rz();
//		rz.setCz("添加功率表"+gl.getXh());
//		rz.setCzr((String) session.getAttribute("UserName"));
//		rz.setCzsj(new Date());
//		rzService.Insert(rz);
//		return "redirect:findAll.action";
//	}
//	
//	@RequestMapping("/updateGl")
//	public String updateYh(Gl gl,HttpServletRequest request,HttpSession session){
//		
//		GlService.update(gl);
//		rz =new Rz();
//		rz.setCz("修改功率表"+gl.getXh());
//		rz.setCzr((String) session.getAttribute("UserName"));
//		rz.setCzsj(new Date());
//		rzService.Insert(rz);
//		return"redirect:findAll.action";
//	}
//	
//	@ResponseBody
//	@RequestMapping("deleteGl")
//	public JSONObject deleteGd(int id,HttpServletRequest request,HttpSession session){
//		JSONObject json=new JSONObject();
//		GlService.delete(id);
//		rz =new Rz();
//		rz.setCz("删除功率表");
//		rz.setCzr((String) session.getAttribute("UserName"));
//		rz.setCzsj(new Date());
//		rzService.Insert(rz);
//		json.put("del","1");
//		return json;
//		
//	}

}