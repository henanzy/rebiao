package com.hnzy.hot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hnzy.hot.pojo.YhMessage;
import com.hnzy.hot.util.JSONSerializer;

@Controller
@RequestMapping("user")
public class UserController {

	//跳转到登录页面
		@RequestMapping("/toLogin")
		public String tologin(){
			return"index";
		}

	
	//跳转到主页面
		@RequestMapping("ZHome")
		public String ZHome(){
			return "navi";
		}
		
		@RequestMapping("bzxx")
		public String bzxx(){
			return "Xxgl/bzxx";
		}
		
		
		//首页
		@RequestMapping("/home" )
    	public String home(String mobile,HttpServletRequest request){
			List<YhMessage> findData = new ArrayList();
    		/*List<Map<String, Object>> YhList=dataService.find(null,null,null,null);
    		request.setAttribute("YhList", JSONSerializer.serialize(YhList));*/
			YhMessage da = new YhMessage();
			da.setXqm("金领小区");
			da.setLdh("1");
			da.setDyh("2");
			da.setXqm("市政小区");
			da.setLdh("1");
			da.setDyh("2");
			da.setXqm("涧河小区");
			da.setLdh("1");
			da.setDyh("2");
			da.setXqm("交警队");
			da.setLdh("1");
			da.setDyh("2");
    		findData.add(da);
    		
    		request.setAttribute("YhList", JSONSerializer.serialize(findData));
    		return "home";
    	}

    	
    	@RequestMapping("/left")
    	public String left(HttpServletRequest reqeust){
    		return "left";
    	}
    	/*@RequestMapping("/index")
    	public String index(){
    		return "index";
    	}*/
    	@RequestMapping("/error")
    	public String error(){
    		return "error";
    	}
    	
    	//缁熻鍒嗘瀽
    	@RequestMapping("/tongjfx2")
    	public String tongjfx2(){
    		return "Kefu/tongjfx2";
    	}
 
    	//宸ュ崟瀹℃牳
    	@RequestMapping("/gongdsh")
    	public String gongdsh(){
    		return "Kefu/gongdsh";
    	}
    	//宸ュ崟鐩戞帶
    	@RequestMapping("/gongdjk")
    	public String gongdjk(){
    		return "Kefu/gongdjk";
    	}
    	//鍙傛暟璁剧疆
    	@RequestMapping("/canssz")
    	public String canssz(){
    		return "Kefu/canssz";
    	}
    	//鎹㈢儹绔欒繍琛岀鐞�
    	@RequestMapping("/yunxgl2")
    	public String yunxgl2(){
    		return "huanre/yunxgl2";
    	}

    	/*企业条例新增文章*/
    	@RequestMapping("/qiytlwz")
    	public String qiytlwz(){
    		return "zhishiku/qiytlwz";
    	}

    	/*企业条例国家法规*/
    	@RequestMapping("/guojfg")
    	public String guojfg(){
    		return "zhishiku/guojfg";
    	}
    	
    	/*企业条例行业知识*/
    	@RequestMapping("/xitsm")
    	public String xitsm(){
    		return "zhishiku/xitsm";
    	}
    	
    
    	/*设备管理*/
    	@RequestMapping("/sbgl")
    	public String sbgl(){
    		return "shebgl/sbgl";
    	}
    	
    	/*缴费管理*/
    	@RequestMapping("/jfgl")
    	public String jfgl(){
    		return "/jfgl";
    	}
    	
    	/*树状栏跳转页面*/
    	@RequestMapping("/szt")
    	public String szt(){
    		return "/szt";
    	}

    	/*企业条例国家法规*/
    	@RequestMapping("/qiytl")
    	public String qiytl(String type){
    		return "zhishiku/qiytl";
    	}
    	
    	/*企业条例行业知识*/
    	@RequestMapping("/hangyzs")
    	public String hangyzs(String type){
    		return "zhishiku/hangyzs";
    	}
   
    	/*企业条例行业知识*/
    	@RequestMapping("/wentjd")
    	public String wentjd(String type){
    		return "zhishiku/wentjd";
    	}
    	

    	/*员工定位*/
    	@RequestMapping("/shisdw")
    	public String shisdw(){
    		return "dingwei/shisdw";
    	}
    	/*历史轨迹*/
    	@RequestMapping("/lisgj")
    	public String lisgj(){
    		return "dingwei/lisgj";
    	}
    	
}