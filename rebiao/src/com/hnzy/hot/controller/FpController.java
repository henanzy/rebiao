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

@RequestMapping("FpCon")
@Controller
public class FpController {
	
//	@Autowired
//	public FpService fpService;
//	@Autowired
//	private RzService rzService;
//	
//	private Rz rz;
//	//查找风盘信息
//	@RequestMapping("findFp")
//	public String findFp(HttpServletRequest request){
//		List<Fp> find=fpService.findFp();
//		String findFp=JSONSerializer.serialize(find);
//		request.setAttribute("findFp",findFp);
//		return "Xxgl/fp";
//	}
// 
//	//增加风盘信息
//	@RequestMapping("addFp")
//	public String addFp(Fp fp,HttpSession session){
//		rz =new Rz();
//		rz.setCz("添加风盘表"+fp.getFpbh());
//		rz.setCzr((String) session.getAttribute("UserName"));
//		rz.setCzsj(new Date());
//		rzService.Insert(rz);
//		fpService.addFp(fp);
//		return "redirect:findFp.action";
//	}
//	//修改风盘信息
//	@RequestMapping("updateFp")
//	public String updateFp(Fp fp,HttpSession session){
//		rz =new Rz();
//		rz.setCz("更新风盘表"+fp.getFpbh());
//		rz.setCzr((String) session.getAttribute("UserName"));
//		rz.setCzsj(new Date());
//		rzService.Insert(rz);
//		fpService.updateFp(fp);
//		return "redirect:findFp.action";
//	}
//	//删除风盘信息
//	@RequestMapping("deleteFp")
//	@ResponseBody
//	public void deleteFp(int id,HttpSession session){
//		rz =new Rz();
//		rz.setCz("删除风盘");
//		rz.setCzr((String) session.getAttribute("UserName"));
//		rz.setCzsj(new Date());
//		rzService.Insert(rz);
//		fpService.deleteFp(id);
//	}
}
