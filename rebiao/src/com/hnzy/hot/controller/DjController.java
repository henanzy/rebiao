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

@RequestMapping("DjCon")
@Controller
public class DjController {
//	@Autowired
//	private DjService djSerivce;
//	@Autowired
//	private RzService rzService;
//	
//	private Rz rz;
//	//查找单价信息
//	@RequestMapping("findDj")
//	public String findDj(HttpServletRequest reqeust){
//		List<Dj> find=djSerivce.findDj();
//		String findDj=JSONSerializer.serialize(find);
//		reqeust.setAttribute("findDj",findDj);
//		return "Xxgl/dj";
//	}
//	   //新增
//		@RequestMapping("addDj")
//		public String addDj(Dj dj,HttpSession session){
//			rz =new Rz();
//			rz.setCz("添加单价表"+dj.getYhlb());
//			rz.setCzr((String) session.getAttribute("UserName"));
//			rz.setCzsj(new Date());
//			rzService.Insert(rz);
//			djSerivce.addDj(dj);
//			return "redirect:findDj.action";
//		}
//		//修改
//		@RequestMapping("updateDj")
//		public String updateDj(Dj dj,HttpSession session){
//			rz =new Rz();
//			rz.setCz("更新单价表"+dj.getYhlb());
//			rz.setCzr((String) session.getAttribute("UserName"));
//			rz.setCzsj(new Date());
//			rzService.Insert(rz);
//			djSerivce.updateDj(dj);
//			return "redirect:findDj.action";
//		}
//		//删除
//		@ResponseBody
//		@RequestMapping("delete")
//		public void delete(int id,HttpSession session){
//			rz =new Rz();
//			rz.setCz("删除单价");
//			rz.setCzr((String) session.getAttribute("UserName"));
//			rz.setCzsj(new Date());
//			rzService.Insert(rz);
//			djSerivce.delete(id);
//		}
}
