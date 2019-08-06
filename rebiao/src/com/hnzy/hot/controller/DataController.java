package com.hnzy.hot.controller;

 
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.hnzy.socket.server.ServerSessionMap;
import com.hnzy.socket.util.CzUtil;
import com.hnzy.socket.util.MapUtilsDf;
 
@Controller
@RequestMapping("/Data")
public class DataController {

//	@Autowired
//	private DataService dataService;
// 
//	@Autowired
//	private RzService rzService;
//	@Autowired
//	private YhMessageService yhMessageService;
//	
//	public String fs;
//	private static Log log = LogFactory.getLog(DataController.class);
//	public List<Data> YhList;
//	public List<Data> BjList;//报警
//	Data jszl=new Data();
////	ServerHandler sh=new ServerHandler();
//	
//	//首页
//	
//	
//	
//	//设备管理
//	@RequestMapping("/dataSbgl")
//	@ResponseBody
//	public JSONObject Sbgl(HttpServletRequest request,String xqm,String ldh,String dyh,
//			String hh) throws UnsupportedEncodingException  {
//		//yhInfoList=yhMessageService.findXqName();
//		if(xqm!=null&&("").equals(xqm)==false){
//			xqm=new String(xqm.getBytes("ISO-8859-1"),"utf-8")+"";
//		}
//		
//		
//		JSONObject jsonObject=new JSONObject();
//		
//		jsonObject.put("YhList",dataService.find(xqm, ldh, dyh, hh));
//		return jsonObject;
//	}
//	
//	//搜索并显示
//	@RequestMapping("searchInfo")
//	@ResponseBody
//	public JSONObject searchInfo(HttpServletRequest request,String xqm,String ldh,
//					String dyh,String hh,String time1,String time2) throws UnsupportedEncodingException{
//		JSONObject jsonObject=new JSONObject();
//		if(xqm!=null&&("").equals(xqm)==false){
//			xqm=new String(xqm.getBytes("ISO-8859-1"),"utf-8")+"";
//		}
//		System.out.println(xqm);
//	   List<Map<String, String>> list=dataService.searchInfo(xqm, ldh, dyh, hh, time1,time2);
//			 
//			jsonObject.put("list",list);
//
//		
//			return jsonObject;		
//		}
//	
//	
//	String  fpdzS;
//	 String kgString="";
//	 String jfString="";
//	 String jjString="";
//	 String ja ;
//	
//	//抄表
//	@RequestMapping("CxState")
//	@ResponseBody
//	public JSONObject CxState(HttpSession session,String[] arr,String kg,String jf,String jj){
//		String yhbh=arr[1];
//	
//		String fpdz=arr[3];
//		String	fp=Integer.toHexString(Integer.valueOf(fpdz));
//		if(fp.length()==1){
//		  fpdzS="0"+fp;
//		}
//		MapUtilsDf.getMapUtils().add("fs",yhbh+fpdz);
//		MapUtilsDf.getMapUtils().add("state",null);
//		String ld=arr[4];
//		String dy=arr[5];
//		//根据用户编码和风盘地址查找层管编号
//		System.out.println(kg);
//		YhMessage yh=	yhMessageService.findCg(yhbh, fpdz);
//		//层管地址
//		String cgbh=yh.getCgbh();
//		String cg=cgbh.substring(4);
//		String ip=yh.getJzqip();
//		String port=yh.getJzqport();
//	
//		Rz rz=new Rz();
//		//用户编号
//		 String yhbhs = Integer.toHexString(Integer.valueOf(yhbh));//16进制  
//
//		 if(kg.equals("00")){
//			 kgString="强关";
//		 }else if(kg.equals("01")){
//			 kgString="自动"; 
//		 }else{
//			 kgString="";  
//		 }
//		 if(jf.equals("00")){
//			 jfString="禁止计费";
//		 }else if(jf.equals("01")){
//			 jfString="允许计费";
//		 }
//		 if(jj.equals("00")){
//			 jjString="夏季";
//		 }else if(jj.equals("01")){
//			 jjString="冬季";
//		 }
//		//用户小区号
//		String xqh=yh.getXqh();
//		if(xqh!=null&&xqh!=""){
//			xqh = Integer.toHexString(Integer.valueOf(xqh));//16进制  
//			if(xqh.length()==1){
//				xqh=0+xqh;
//			}
//			 ja =ld+dy+"F014B5"+xqh+ld+"00"+ld+dy+cg+yhbhs+fpdzS+kg+jf+jj+"FFFF";//起始到结束  01终端	
//			 System.out.println("新小区一户发送指令："+ja);
//			 rz.setCz("对某户 楼栋号："+ld+"单元号："+dy+"风盘地址:"+fpdzS+"开关"+kgString+"计费"+jfString+"季节"+jjString+"操作发送指令");
//		}else{
////			 ja =ld+dy+"F010B5"+cg+""+idsS+fpdz+ld+dy+"FFFFFFFF";//起始到结束  01终端
//			 ja =ld+dy+"F010B5"+cg+""+yhbhs+fpdzS+ld+dy+"FFFFFFFF";//起始到结束  01终端	
//			 System.out.println("一户："+ja);
//			 rz.setCz("对某户 楼栋号："+ld+"单元号："+dy+"风盘地址:"+fpdzS+"操作发送指令");
//		}
//		
//		rz.setCzr((String)session.getAttribute("UserName"));
//		rz.setCzsj(new Date());
//		rzService.Insert(rz);
//		String pt = "/" + ip + ":" + port; 
//		System.out.println("ja--抄表发送数据-----"+ja);
//		boolean sessionmap = cz(ja, pt);
//		
//		 try {
//			 	Thread.sleep(4000);
//			 } catch (InterruptedException e) {
//			 	e.printStackTrace();
//			 }
//		JSONObject js=new JSONObject();
//		if(sessionmap==true&&null!=MapUtilsDf.getMapUtils().get("state")&& MapUtilsDf.getMapUtils().get("state").equals(yhbh+fpdz)){
//			MapUtilsDf.getMapUtils().add("state",null);
//			MapUtilsDf.getMapUtils().add("fs",null);
//			js.put("js", 0);
//		}else{
//			MapUtilsDf.getMapUtils().add("state",null);
//			MapUtilsDf.getMapUtils().add("fs",null);
//			js.put("js",1);
//		}
//	  return js;
//	}
//	
//
//	// ---------------------单个风盘操作开关---------
//	  	@RequestMapping("DCxZx")
//		@ResponseBody
//		public JSONObject DCxZx(HttpSession session,String[] arr,String kg,String jf,String jj){
//	  		String yhbh=arr[1];
//			String fpdz=arr[3];
//			// 根据用户编码和风盘地址查找用户
//			Data findData = dataService.findData(yhbh, fpdz);
//			jszl.setYhbh(yhbh);
//			jszl.setFpdz(fpdz);
//			if(kg.equals("FF")){
//				jszl.setKg(findData.getKg());
//			}else{
//				jszl.setKg(kg);
//			}
//		    if(jf.equals("FF")){
//		    	jszl.setJf(findData.getJf());
//		    }else{
//		    	jszl.setYhbh(jf);
//		    }
//			if(jj.equals("FF")){
//				jszl.setJj(findData.getJj());
//			}else{
//				jszl.setJf(jj);
//			}
//			MapUtilsDf.getMapUtils().add("fs",yhbh+fpdz);
//	  		MapUtilsDf.getMapUtils().add("state",null);
//	  		
//			String	fp=Integer.toHexString(Integer.valueOf(fpdz));
//			if(fp.length()==1){
//			  fpdzS="0"+fp;
//			}
//			
//			String ld=arr[4];
//			String dy=arr[5];
//			//根据用户编码和风盘地址查找层管编号
//			System.out.println(kg);
//			YhMessage yh=	yhMessageService.findCg(yhbh, fpdz);
//			//层管地址
//			String cgbh=yh.getCgbh();
//			String cg=cgbh.substring(4);
//			String ip=yh.getJzqip();
//			String port=yh.getJzqport();
//			//用户编号
//			String yhbhs = Integer.toHexString(Integer.valueOf(yhbh));//16进制  
//			//用户小区号
//			String xqh=yh.getXqh();
//			System.out.println("小区号---------"+xqh);
//			//根据小区号分类
//			if(xqh!=null&&xqh!=""){
//			 ja =ld+dy+"F014B1"+xqh+ld+"00"+ld+dy+cg+yhbhs+fpdzS+kg+jf+jj+"FFFF";
//				System.out.println("新开关指令---"+ja); 
//			}else{
//			 //空调状态
//			  ja =ld+dy+"F010B1"+cg+""+yhbhs+fpdzS+""+kg+""+jf+""+jj+ld+dy+"FF";
//			  System.out.println("老指令："+ja);
//
//			}
//			
//			System.out.println("ja--单个风盘开关-------"+ja);
//			 // IP地址和端口号
//			 String pt = "/" + ip + ":" + port;
//			 boolean sessionmap = cz(ja, pt);	
//			
//			 log.info("对某户单个 风盘开关计费季节操作发送指令 ："+ja);
//				//日志
//		
//			 if(kg.equals("00")){
//				 kgString="强关";
//			 }else if(kg.equals("01")){
//				 kgString="自动"; 
//			 }else{
//				 kgString="";  
//			 }
//			 if(jf.equals("00")){
//				 jfString="禁止计费";
//			 }else if(jf.equals("01")){
//				 jfString="允许计费";
//			 }
//			 if(jj.equals("00")){
//				 jjString="夏季";
//			 }else if(jj.equals("01")){
//				 jjString="冬季";
//			 }
//			 
//			    try {
//				 	Thread.sleep(4000);
//				 } catch (InterruptedException e) {
//				 	e.printStackTrace();
//				 }
//				Rz rz=new Rz();
//				rz.setCz("对单户 风盘开关计费季节操作,楼栋号："+ld+",单元号："+dy+",风盘地址："+fpdz+",开关:"+kgString+",计费："+jfString+",季节："+jjString);
//				rz.setCzr((String)session.getAttribute("UserName"));
//				rz.setCzsj(new Date());
//				rzService.Insert(rz);
//				JSONObject js=new JSONObject();
//				if(sessionmap==true&&null!=MapUtilsDf.getMapUtils().get("state")&& MapUtilsDf.getMapUtils().get("state").equals(yhbh+fpdz)){
//					dataService.updateSbJs(jszl);
//					MapUtilsDf.getMapUtils().add("state",null);
//					MapUtilsDf.getMapUtils().add("fs",null);
//					js.put("js", 0);
//				}else{
//					MapUtilsDf.getMapUtils().add("state",null);
//					MapUtilsDf.getMapUtils().add("fs",null);
//					js.put("js",1);
//				}
//			  return js;
//	    	} 
//	//某户所有风盘操作
//		@RequestMapping("QyFp")
//	 	public JSONObject SCxZx(HttpSession session,String[] arr,String kg,String jf,String jj){
////	   		MapUtilsDf.getMapUtils().add("dg", null);
//	  		String yhbh=arr[1];
//			MapUtilsDf.getMapUtils().add("fs",yhbh);
//	  		MapUtilsDf.getMapUtils().add("state",null);
//			String fpdz=arr[3];
//			String	fp=Integer.toHexString(Integer.valueOf(fpdz));
//			if(fp.length()==1){
//			  fpdzS="0"+fp;
//			}
//			String ld=arr[4];
//			String dy=arr[5];
//			//根据用户编码和风盘地址查找层管编号
//			System.out.println(kg);
//			YhMessage yh=	yhMessageService.findCg(yhbh, fpdz);
//			//层管地址
//			String cgbh=yh.getCgbh();
//			String cg=cgbh.substring(4);
//			String ip=yh.getJzqip();
//			String port=yh.getJzqport();
//			//用户编号
//			 yhbh = Integer.toHexString(Integer.valueOf(yhbh));//16进制  
//			//用户小区号
//			String xqh=yh.getXqh();
//			
//			//根据小区号分类
//			if(xqh!=null&&xqh!=""){
//			 ja =ld+dy+"F014B1"+xqh+ld+"00"+ld+dy+cg+yhbh+"FF"+kg+jf+jj+"FFFF";
//				
//				
//			 
//			}else{
//	 		 //空调状态
//	 		  ja =ld+dy+"F010B1"+cg+""+yhbh+"FF"+""+kg+""+jf+""+jj+ld+dy+"FF";
//	 		 System.out.println("ja----"+ja);
//	 		 // IP地址和端口号
//	 		
//			}
//			
//			
//	 		 log.info("对某户 所有风盘开关计费季节操作,楼栋号:"+ld+"单元号："+dy+",发送指令 ："+ja);
//	 		 if(kg.equals("00")){
//				 kgString="强关";
//			 }else if(kg.equals("01")){
//				 kgString="自动"; 
//			 }else{
//				 kgString="";  
//			 }
//			 if(jf.equals("00")){
//				 jfString="禁止计费";
//			 }else if(jf.equals("01")){
//				 jfString="允许计费";
//			 }
//			 if(jj.equals("00")){
//				 jjString="夏季";
//			 }else if(jj.equals("01")){
//				 jjString="冬季";
//			 }
//				Rz rz=new Rz();
//				rz.setCz("发送对单户 所有风盘开关计费季节操作,风盘地址："+fpdz+",开关："+kgString+",计费"+jfString+",季节"+jjString);
//				rz.setCzr((String)session.getAttribute("UserName"));
//				rz.setCzsj(new Date());;
//				rzService.Insert(rz);
//				
//				 String pt = "/" + ip + ":" + port;
//				 
//		 		 boolean sessionmap = cz(ja, pt);
//				
//	 		 try {
//	 		 	Thread.sleep(4000);
//	 		 } catch (InterruptedException e) {
//	 		 	e.printStackTrace();
//	 		 }
//	 		JSONObject js=new JSONObject();
//	 		if(sessionmap==true&&null!=MapUtilsDf.getMapUtils().get("state")&& MapUtilsDf.getMapUtils().get("state").equals("success")){
//				MapUtilsDf.getMapUtils().add("state",null);
//				MapUtilsDf.getMapUtils().add("fs",null);
//				js.put("js", 0);
//			}else{
//				MapUtilsDf.getMapUtils().add("state",null);
//				MapUtilsDf.getMapUtils().add("fs",null);
//				js.put("js",1);
//			}
//		     return js;
//	     	} 
//	// 抽取相同部分
//				public boolean cz(String ja, String pt) {
//					// 把十六进制数，转换为十进制相加
//					int jia = CzUtil.FsZh(ja);
//					// 十进制转换为十六进制
//					String hex = Integer.toHexString(jia);
//					// 截取相加结果后两位
//					String je = null;
//					for (int j = 0; j < hex.length() - 1; j++) {
//						je = hex.charAt(hex.length() - 2) + "" + hex.charAt(hex.length() - 1);
//					}
//					String[] keys = new String[] { pt };
//					String mString =ja+je+"FF";
//					System.out.println("发送数据--"+mString);
//					// 解码
//					byte[] b = CzUtil.jm(mString);
//					ServerSessionMap sessionMap = ServerSessionMap.getInstance();
//					boolean sessionmap = sessionMap.sendMessage(keys, b);
//					return sessionmap;
//				}

//	@Autowired
//	private DataService dataService;
// 
//	@Autowired
//	private RzService rzService;
//	@Autowired
//	private YhMessageService yhMessageService;
//	
//	public String fs;
//	private static Log log = LogFactory.getLog(DataController.class);
//	public List<Data> YhList;
//	public List<Data> BjList;//报警
//	Data jszl=new Data();
////	ServerHandler sh=new ServerHandler();
//	
//	//首页
//	
//	
//	
//	//设备管理
//	@RequestMapping("/dataSbgl")
//	@ResponseBody
//	public JSONObject Sbgl(HttpServletRequest request,String xqm,String ldh,String dyh,
//			String hh) throws UnsupportedEncodingException  {
//		//yhInfoList=yhMessageService.findXqName();
//		if(xqm!=null&&("").equals(xqm)==false){
//			xqm=new String(xqm.getBytes("ISO-8859-1"),"utf-8")+"";
//		}
//		
//		
//		JSONObject jsonObject=new JSONObject();
//		
//		jsonObject.put("YhList",dataService.find(xqm, ldh, dyh, hh));
//		return jsonObject;
//	}
//	
//	//搜索并显示
//	@RequestMapping("searchInfo")
//	@ResponseBody
//	public JSONObject searchInfo(HttpServletRequest request,String xqm,String ldh,
//					String dyh,String hh,String time1,String time2) throws UnsupportedEncodingException{
//		JSONObject jsonObject=new JSONObject();
//		if(xqm!=null&&("").equals(xqm)==false){
//			xqm=new String(xqm.getBytes("ISO-8859-1"),"utf-8")+"";
//		}
//		System.out.println(xqm);
//	   List<Map<String, String>> list=dataService.searchInfo(xqm, ldh, dyh, hh, time1,time2);
//			 
//			jsonObject.put("list",list);
//
//		
//			return jsonObject;		
//		}
//	
//	
//	String  fpdzS;
//	 String kgString="";
//	 String jfString="";
//	 String jjString="";
//	 String ja ;
//	
//	//抄表
//	@RequestMapping("CxState")
//	@ResponseBody
//	public JSONObject CxState(HttpSession session,String[] arr,String kg,String jf,String jj){
//		String yhbh=arr[1];
//	
//		String fpdz=arr[3];
//		String	fp=Integer.toHexString(Integer.valueOf(fpdz));
//		if(fp.length()==1){
//		  fpdzS="0"+fp;
//		}
//		MapUtilsDf.getMapUtils().add("fs",yhbh+fpdz);
//		MapUtilsDf.getMapUtils().add("state",null);
//		String ld=arr[4];
//		String dy=arr[5];
//		//根据用户编码和风盘地址查找层管编号
//		System.out.println(kg);
//		YhMessage yh=	yhMessageService.findCg(yhbh, fpdz);
//		//层管地址
//		String cgbh=yh.getCgbh();
//		String cg=cgbh.substring(4);
//		String ip=yh.getJzqip();
//		String port=yh.getJzqport();
//	
//		Rz rz=new Rz();
//		//用户编号
//		 String yhbhs = Integer.toHexString(Integer.valueOf(yhbh));//16进制  
//
//		 if(kg.equals("00")){
//			 kgString="强关";
//		 }else if(kg.equals("01")){
//			 kgString="自动"; 
//		 }else{
//			 kgString="";  
//		 }
//		 if(jf.equals("00")){
//			 jfString="禁止计费";
//		 }else if(jf.equals("01")){
//			 jfString="允许计费";
//		 }
//		 if(jj.equals("00")){
//			 jjString="夏季";
//		 }else if(jj.equals("01")){
//			 jjString="冬季";
//		 }
//		//用户小区号
//		String xqh=yh.getXqh();
//		if(xqh!=null&&xqh!=""){
//			xqh = Integer.toHexString(Integer.valueOf(xqh));//16进制  
//			if(xqh.length()==1){
//				xqh=0+xqh;
//			}
//			 ja =ld+dy+"F014B5"+xqh+ld+"00"+ld+dy+cg+yhbhs+fpdzS+kg+jf+jj+"FFFF";//起始到结束  01终端	
//			 System.out.println("新小区一户发送指令："+ja);
//			 rz.setCz("对某户 楼栋号："+ld+"单元号："+dy+"风盘地址:"+fpdzS+"开关"+kgString+"计费"+jfString+"季节"+jjString+"操作发送指令");
//		}else{
////			 ja =ld+dy+"F010B5"+cg+""+idsS+fpdz+ld+dy+"FFFFFFFF";//起始到结束  01终端
//			 ja =ld+dy+"F010B5"+cg+""+yhbhs+fpdzS+ld+dy+"FFFFFFFF";//起始到结束  01终端	
//			 System.out.println("一户："+ja);
//			 rz.setCz("对某户 楼栋号："+ld+"单元号："+dy+"风盘地址:"+fpdzS+"操作发送指令");
//		}
//		
//		rz.setCzr((String)session.getAttribute("UserName"));
//		rz.setCzsj(new Date());
//		rzService.Insert(rz);
//		String pt = "/" + ip + ":" + port; 
//		System.out.println("ja--抄表发送数据-----"+ja);
//		boolean sessionmap = cz(ja, pt);
//		 log.info("抄表发送数据---："+ja);
//		 try {
//			 	Thread.sleep(4000);
//			 } catch (InterruptedException e) {
//			 	e.printStackTrace();
//			 }
//		JSONObject js=new JSONObject();
//		if(sessionmap==true&&null!=MapUtilsDf.getMapUtils().get("state")&& MapUtilsDf.getMapUtils().get("state").equals(yhbh+fpdz)){
//			MapUtilsDf.getMapUtils().add("state",null);
//			MapUtilsDf.getMapUtils().add("fs",null);
//			js.put("js", 0);
//		}else{
//			MapUtilsDf.getMapUtils().add("state",null);
//			MapUtilsDf.getMapUtils().add("fs",null);
//			js.put("js",1);
//		}
//	  return js;
//	}
//	
//
//	// ---------------------单个风盘操作开关---------
//	  	@RequestMapping("DCxZx")
//		@ResponseBody
//		public JSONObject DCxZx(HttpSession session,String[] arr,String kg,String jf,String jj){
//	  		String yhbh=arr[1];
//			String fpdz=arr[3];
//			// 根据用户编码和风盘地址查找用户
//			Data findData = dataService.findData(yhbh, fpdz);
//			jszl.setYhbh(yhbh);
//			jszl.setFpdz(fpdz);
//			if(kg.equals("FF")){
//				jszl.setKg(findData.getKg());
//			}else{
//				jszl.setKg(kg);
//			}
//		    if(jf.equals("FF")){
//		    	jszl.setJf(findData.getJf());
//		    }else{
//		    	jszl.setYhbh(jf);
//		    }
//			if(jj.equals("FF")){
//				jszl.setJj(findData.getJj());
//			}else{
//				jszl.setJf(jj);
//			}
//			MapUtilsDf.getMapUtils().add("fs",yhbh+fpdz);
//	  		MapUtilsDf.getMapUtils().add("state",null);
//	  		
//			String	fp=Integer.toHexString(Integer.valueOf(fpdz));
//			if(fp.length()==1){
//			  fpdzS="0"+fp;
//			}
//			
//			String ld=arr[4];
//			String dy=arr[5];
//			//根据用户编码和风盘地址查找层管编号
//			System.out.println(kg);
//			YhMessage yh=	yhMessageService.findCg(yhbh, fpdz);
//			//层管地址
//			String cgbh=yh.getCgbh();
//			String cg=cgbh.substring(4);
//			String ip=yh.getJzqip();
//			String port=yh.getJzqport();
//			//用户编号
//			String yhbhs = Integer.toHexString(Integer.valueOf(yhbh));//16进制  
//			//用户小区号
//			String xqh=yh.getXqh();
//			System.out.println("小区号---------"+xqh);
//			//根据小区号分类
//			if(xqh!=null&&xqh!=""){
//			 ja =ld+dy+"F014B1"+xqh+ld+"00"+ld+dy+cg+yhbhs+fpdzS+kg+jf+jj+"FFFF";
//				System.out.println("新开关指令---"+ja); 
//			}else{
//			 //空调状态
//			  ja =ld+dy+"F010B1"+cg+""+yhbhs+fpdzS+""+kg+""+jf+""+jj+ld+dy+"FF";
//			  System.out.println("老指令："+ja);
//
//			}
//			
//			System.out.println("ja--单个风盘开关-------"+ja);
//			 // IP地址和端口号
//			 String pt = "/" + ip + ":" + port;
//			 boolean sessionmap = cz(ja, pt);	
//			
//			 log.info("对某户单个 风盘开关计费季节操作发送指令 ："+ja);
//				//日志
//		
//			 if(kg.equals("00")){
//				 kgString="强关";
//			 }else if(kg.equals("01")){
//				 kgString="自动"; 
//			 }else{
//				 kgString="";  
//			 }
//			 if(jf.equals("00")){
//				 jfString="禁止计费";
//			 }else if(jf.equals("01")){
//				 jfString="允许计费";
//			 }
//			 if(jj.equals("00")){
//				 jjString="夏季";
//			 }else if(jj.equals("01")){
//				 jjString="冬季";
//			 }
//			 
//			    try {
//				 	Thread.sleep(4000);
//				 } catch (InterruptedException e) {
//				 	e.printStackTrace();
//				 }
//				Rz rz=new Rz();
//				rz.setCz("对单户 风盘开关计费季节操作,楼栋号："+ld+",单元号："+dy+",风盘地址："+fpdz+",开关:"+kgString+",计费："+jfString+",季节："+jjString);
//				rz.setCzr((String)session.getAttribute("UserName"));
//				rz.setCzsj(new Date());
//				rzService.Insert(rz);
//				JSONObject js=new JSONObject();
//				if(sessionmap==true&&null!=MapUtilsDf.getMapUtils().get("state")&& MapUtilsDf.getMapUtils().get("state").equals(yhbh+fpdz)){
//					dataService.updateSbJs(jszl);
//					MapUtilsDf.getMapUtils().add("state",null);
//					MapUtilsDf.getMapUtils().add("fs",null);
//					js.put("js", 0);
//				}else{
//					MapUtilsDf.getMapUtils().add("state",null);
//					MapUtilsDf.getMapUtils().add("fs",null);
//					js.put("js",1);
//				}
//			  return js;
//	    	} 
//	//某户所有风盘操作
//		@RequestMapping("QyFp")
//		@ResponseBody
//	 	public JSONObject SCxZx(HttpSession session,String[] arr,String kg,String jf,String jj){
////	   		MapUtilsDf.getMapUtils().add("dg", null);
//	  		String yhbh=arr[1];
//			MapUtilsDf.getMapUtils().add("fs",yhbh);
//	  		MapUtilsDf.getMapUtils().add("state",null);
//			String fpdz=arr[3];
//			String	fp=Integer.toHexString(Integer.valueOf(fpdz));
//			if(fp.length()==1){
//			  fpdzS="0"+fp;
//			}
//			String ld=arr[4];
//			String dy=arr[5];
//			//根据用户编码和风盘地址查找层管编号
//			System.out.println(kg);
//			YhMessage yh=	yhMessageService.findCg(yhbh, fpdz);
//			//层管地址
//			String cgbh=yh.getCgbh();
//			String cg=cgbh.substring(4);
//			String ip=yh.getJzqip();
//			String port=yh.getJzqport();
//			//用户编号
//			 yhbh = Integer.toHexString(Integer.valueOf(yhbh));//16进制  
//			//用户小区号
//			String xqh=yh.getXqh();
//			
//			//根据小区号分类
//			if(xqh!=null&&xqh!=""){
//			 ja =ld+dy+"F014B1"+xqh+ld+"00"+ld+dy+cg+yhbh+"FF"+kg+jf+jj+"FFFF";
//				
//				
//			 
//			}else{
//	 		 //空调状态
//	 		  ja =ld+dy+"F010B1"+cg+""+yhbh+"FF"+""+kg+""+jf+""+jj+ld+dy+"FF";
//	 		 System.out.println("ja----"+ja);
//	 		 // IP地址和端口号
//	 		
//			}
//			
//			
//	 		 log.info("对某户 所有风盘开关计费季节操作,楼栋号:"+ld+"单元号："+dy+",发送指令 ："+ja);
//	 		 if(kg.equals("00")){
//				 kgString="强关";
//			 }else if(kg.equals("01")){
//				 kgString="自动"; 
//			 }else{
//				 kgString="";  
//			 }
//			 if(jf.equals("00")){
//				 jfString="禁止计费";
//			 }else if(jf.equals("01")){
//				 jfString="允许计费";
//			 }
//			 if(jj.equals("00")){
//				 jjString="夏季";
//			 }else if(jj.equals("01")){
//				 jjString="冬季";
//			 }
//				Rz rz=new Rz();
//				rz.setCz("发送对单户 所有风盘开关计费季节操作,风盘地址："+fpdz+",开关："+kgString+",计费"+jfString+",季节"+jjString);
//				rz.setCzr((String)session.getAttribute("UserName"));
//				rz.setCzsj(new Date());;
//				rzService.Insert(rz);
//				
//				 String pt = "/" + ip + ":" + port;
//				 
//		 		 boolean sessionmap = cz(ja, pt);
//				
//	 		 try {
//	 		 	Thread.sleep(4000);
//	 		 } catch (InterruptedException e) {
//	 		 	e.printStackTrace();
//	 		 }
//	 		JSONObject js=new JSONObject();
//	 		if(sessionmap==true&&null!=MapUtilsDf.getMapUtils().get("state")&& MapUtilsDf.getMapUtils().get("state").equals("success")){
//				MapUtilsDf.getMapUtils().add("state",null);
//				MapUtilsDf.getMapUtils().add("fs",null);
//				js.put("js", 0);
//			}else{
//				MapUtilsDf.getMapUtils().add("state",null);
//				MapUtilsDf.getMapUtils().add("fs",null);
//				js.put("js",1);
//			}
//		     return js;
//	     	} 
//	// 抽取相同部分
//				public boolean cz(String ja, String pt) {
//					// 把十六进制数，转换为十进制相加
//					int jia = CzUtil.FsZh(ja);
//					// 十进制转换为十六进制
//					String hex = Integer.toHexString(jia);
//					// 截取相加结果后两位
//					String je = null;
//					for (int j = 0; j < hex.length() - 1; j++) {
//						je = hex.charAt(hex.length() - 2) + "" + hex.charAt(hex.length() - 1);
//					}
//					String[] keys = new String[] { pt };
//					String mString =ja+je+"FF";
//					System.out.println("发送数据--"+mString);
//					// 解码
//					byte[] b = CzUtil.jm(mString);
//					ServerSessionMap sessionMap = ServerSessionMap.getInstance();
//					boolean sessionmap = sessionMap.sendMessage(keys, b);
//					return sessionmap;
//				}
//				
//				
//	@RequestMapping("/sjbb")
//	public String sjbb(HttpServletRequest request)  {	
//		
//		
//		return "shebgl/sjbb";
//	}
//	
	@RequestMapping("/sbgl")
	public String sbgl(HttpServletRequest request)  {	
		
		
		return "shebgl/sbgl";
	}
//
//	/*public String getFs() {
//		return fs;
//	}
//
//	public void setFs(String fs) {
}
