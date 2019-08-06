package com.hnzy.hot.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hnzy.hot.util.JSONSerializer;

@Controller
@RequestMapping("ZskCon")
public class ZskController {

//	@Autowired
//	private ZskService zskService;
	
//	@RequestMapping(value="getQytl")
//    public String getQytl(HttpServletRequest request,HttpServletResponse response,String type,RedirectAttributes attr) throws UnsupportedEncodingException{
//		String 	ty="";
//		if(type!=null&&"".equals(type)==false){
//			ty=  new String(type.getBytes("ISO-8859-1"),"utf-8")+"";
//		}
//		
//		 	
//		 	if(ty.equals("")||ty==null){
//		 		ty=(String) attr.getFlashAttributes().get("type");
//		 	}
		 	
	
		// TODO Auto-generated catch block
		
		
	
		
//		List<Zsk> zskList= zskService.selAll(ty);
//		
//		
//		request.setAttribute("zskList", JSONSerializer.serialize(zskList));
//		String url="";
//		if(ty.equals("企业条例")){
//			url="zhishiku/qiytl";
//		}
//		if(ty.equals("国家法规")){
//			url="zhishiku/guojfg";
//		}
//		if(ty.equals("行业知识")){
//			url="zhishiku/hangyzs";
//		}
//		if(ty.equals("系统说明")){
//			url="zhishiku/xitsm";
//		}
//		if(ty.equals("问题解答")){
//			url="zhishiku/wentjd";
//		}
//		
//		
//		
//		return url;
//    }
	
	@RequestMapping(value="insertZsk")
    public String insertZsk(HttpServletRequest request,HttpServletResponse response){
		
		
		
		return "zhishiku/qiytlwz";
    }
	
//	@RequestMapping(value="addZsk")
//    public String addZsk(HttpServletRequest request,HttpServletResponse response,Zsk zsk,RedirectAttributes attr){
//		zskService.addZsk(zsk);
//		
//		String type=zsk.getZsktype();
//		attr.addAttribute("type", type);
//		return "redirect:getQytl.action";
//    }
//	
//	@RequestMapping(value="updateZsk")
//    public String updateZsk(HttpServletRequest request,HttpServletResponse response,Zsk zsk,RedirectAttributes attr){
//		
//		zskService.updateZsk(zsk);
//		String type=zsk.getZsktype();
//		attr.addAttribute("type", type);
//		return "redirect:getQytl.action";
//    }
	
//	@RequestMapping(value="deleteZsk")
//	@ResponseBody
//    public String deleteZsk(HttpServletRequest request,HttpServletResponse response,String id,String type,RedirectAttributes attr){
//		
//		
//		attr.addAttribute("type", type);
//		zskService.deleteZsk(id);
//		
//		return "redirect:getQytl.action";
//    }
	
	
}
