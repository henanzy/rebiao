package com.hnzy.hot.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hnzy.hot.util.JSONSerializer;
import com.hnzy.socket.server.ServerSessionMap;
import com.hnzy.socket.util.CzUtil;

import net.sf.json.JSONObject;



@Controller
@RequestMapping("cg")
public class CgController {
//	
//	@Autowired
//	private CgService CgService;
//	
//	@Autowired
//	private RzService rzService;
//	
//	private Rz rz;
//	private static Log log = LogFactory.getLog(CgController.class);
	@RequestMapping("/findAll")
	public String findAll(HttpServletRequest request,HttpSession session){

		return"shebgl/cggl";
	}
//	
//	@RequestMapping("/addCg")
//	public String addYh(Cg cg,HttpServletRequest request,HttpSession session){
//		CgService.Insert(cg);
//		rz =new Rz();
//		rz.setCz("添加层管"+cg.getCgbh());
//		rz.setCzr((String) session.getAttribute("UserName"));
//		rz.setCzsj(new Date());
//		rzService.Insert(rz);
//		return "redirect:findAll.action";
//	}
//	
//	@RequestMapping("/updateCg")
//	public String updateYh(Cg cg,HttpServletRequest request,HttpSession session){
//		
//		CgService.update(cg);
//		rz =new Rz();
//		rz.setCz("修改层管"+cg.getCgbh());
//		rz.setCzr((String) session.getAttribute("UserName"));
//		rz.setCzsj(new Date());
//		rzService.Insert(rz);
//		return"redirect:findAll.action";
//	}
//	
//	@ResponseBody
//	@RequestMapping("deleteCg")
//	public JSONObject deleteGd(int id,HttpServletRequest request,HttpSession session){
//		JSONObject json=new JSONObject();
//		CgService.deletecg(id);
//		rz =new Rz();
//		rz.setCz("删除层管信息");
//		rz.setCzr((String) session.getAttribute("UserName"));
//		rz.setCzsj(new Date());
//		rzService.Insert(rz);
//		json.put("del","1");
//		return json;
//		
//	}
//	 String kgString="";
//	 String jfString="";
//	 String jjString="";
//	 String ja;
//	 
//	 //某层
//	@ResponseBody
//	@RequestMapping("CgFp")
//	public JSONObject CgFp(HttpSession session,String[] arr,String kg,String jf,String jj) {
//		//层管编号
//		String cgbh=arr[1];
//		Cg cgxx=CgService.findLdDyByCg(cgbh);		
//   		String ld=cgxx.getLdh();
//   		String dy=cgxx.getDyh();
//   		String ip=cgxx.getJzqip();
//   		String port=cgxx.getJzqport();
//		 String cg=cgbh.substring(4);
//   		String xqh=cgxx.getXqh();
//   		if(xqh!=""|| xqh!=null){
//   		 ja =ld+dy+"F014B1"+xqh+ld+"00"+ld+dy+"FFF0F0F0FF"+kg+jf+jj+"FFFF";
//   		}else{
//    	 //发送数据
// 		  ja =ld+dy+"F010B1"+cg+"F0F0F0FF"+""+kg+""+jf+""+jj+ld+dy+"FF";
// 		 System.out.println("ja----"+ja);
//   		}
// 		 
// 		 log.info("对"+cg+"层 所有风盘开关计费季节操作发送指令：层管编号："+cg+"，指令---"+ja);
// 		 System.out.println("ja----"+ja);
// 		 if(kg.equals("00")){
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
//		 
//			Rz rz=new Rz();
//			rz.setCz("发送对"+cg+"层所有风盘开关计费季节操作,层管编号："+kgString+","+jfString+","+jjString);
//			rz.setCzr((String)session.getAttribute("UserName"));
//			rz.setCzsj(new Date());
//			rzService.Insert(rz);
// 		 
// 		 // IP地址和端口号
// 		 String pt = "/" + ip + ":" + port;
// 		 boolean sessionmap = cz(ja, pt);
// 		 System.out.println("ja-------------"+ja);
// 		 try {
// 		 	Thread.sleep(4000);
// 		 } catch (InterruptedException e) {
// 		 	e.printStackTrace();
// 		 }
// 		 
// 		JSONObject jsonObject = new JSONObject();
// 		 
// 		if (sessionmap == true) {
// 		 	jsonObject.put("js", "0");
// 		 	
// 		 }else{
// 			jsonObject.put("js", "1");
// 			 
// 		 }
// 		return jsonObject;
//     	}
//	//单元
//	@ResponseBody
//	@RequestMapping("dyFp")
//	public JSONObject dyFp(HttpSession session,String[] arr,String kg,String jf,String jj) {
//		//层管编号
//		String cgbh=arr[1];
//		Cg cgxx=CgService.findLdDyByCg(cgbh);
//		
////		MapUtilsDf.getMapUtils().add("dg", null);
//		
//
////   		
//   		String ld=cgxx.getLdh();
//   		String dy=cgxx.getDyh();
//   		String ip=cgxx.getJzqip();
//   		String port=cgxx.getJzqport();
//		String cg=cgbh.substring(4);
//   		String xqh=cgxx.getXqh();
//   		if(xqh!=""|| xqh!=null){
////   		 ja =ld+dy+"F014B1"+xqh+ld+"00"+ld+dy+cg+"F0F0F0FF"+kg+jf+jj+"FFFF";
//   		 ja =ld+dy+"F014B1"+xqh+ld+"00"+ld+"FFFFF0F0F0FF"+kg+jf+jj+"FFFF";
//   		}else{
//   		 //发送数据
////	 	 ja =ld+dy+"F010B1FFF0F0F0FF"+""+kg+""+jf+""+jj+ld+dy+"FF";
// 		 System.out.println("ja----"+ja);
// 		 
//   		}
// 		 
// 		 log.info("对"+cg+"层 所有风盘开关计费季节操作发送指令：层管编号："+cg+"，指令---"+ja);
//// 		 System.out.println("ja----"+ja);
// 		 if(kg.equals("00")){
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
//		 
//			Rz rz=new Rz();
//			rz.setCz("发送对"+cg+"层所有风盘开关计费季节操作,层管编号："+kgString+","+jfString+","+jjString);
//			rz.setCzr((String)session.getAttribute("UserName"));
//			rz.setCzsj(new Date());;
//			rzService.Insert(rz);
// 		 
// 		 // IP地址和端口号
// 		 String pt = "/" + ip + ":" + port;
// 		 boolean sessionmap = cz(ja, pt);
// 		 System.out.println("ja-------------"+ja);
// 		 try {
// 		 	Thread.sleep(4000);
// 		 } catch (InterruptedException e) {
// 		 	e.printStackTrace();
// 		 }
// 		 JSONObject jsonObject = new JSONObject();
// 		if (sessionmap == true) {
// 		 	jsonObject.put("js", "0");
// 		 	
// 		 }else{
// 			jsonObject.put("js", "1");
// 			 
// 		 }
// 		return jsonObject;
//     	} 
//	
//	//楼栋
//	@ResponseBody
//	@RequestMapping("LdFp")
//	public JSONObject LdFp(HttpSession session,String[] arr,String kg,String jf,String jj) {
//		//层管编号
//		String cgbh=arr[1];
//		Cg cgxx=CgService.findLdDyByCg(cgbh);
//		
////		MapUtilsDf.getMapUtils().add("dg", null);
//		
//
////   		
//   		String ld=cgxx.getLdh();
//   		String dy=cgxx.getDyh();
//   		String ip=cgxx.getJzqip();
//   		String port=cgxx.getJzqport();
//		 String cg=cgbh.substring(4);
//   		String xqh=cgxx.getXqh();
//   		if(xqh!=""|| xqh!=null){
////   		 ja =ld+dy+"F014B1"+xqh+ld+"00"+ld+dy+cg+"F0F0F0FF"+kg+jf+jj+"FFFF";
//   		 ja =ld+dy+"F014B1"+xqh+ld+"00FFFFFFF0F0F0FF"+kg+jf+jj+"FFFF";
//   		}else{
//
//
//   		 //发送数据
//	 	 ja =ld+dy+"F010B1FFF0F0F0FF"+""+kg+""+jf+""+jj+ld+dy+"FF";
// 		 System.out.println("ja----"+ja);
// 		 
//   		}
// 		 
// 		 log.info("对"+cg+"层 所有风盘开关计费季节操作发送指令：层管编号："+cg+"，指令---"+ja);
//// 		 System.out.println("ja----"+ja);
// 		 if(kg.equals("00")){
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
//		 
//			Rz rz=new Rz();
//			rz.setCz("发送对"+cg+"层所有风盘开关计费季节操作,层管编号："+kgString+","+jfString+","+jjString);
//			rz.setCzr((String)session.getAttribute("UserName"));
//			rz.setCzsj(new Date());;
//			rzService.Insert(rz);
// 		 
// 		 // IP地址和端口号
// 		 String pt = "/" + ip + ":" + port;
// 		 boolean sessionmap = cz(ja, pt);
// 		 System.out.println("ja-------------"+ja);
// 		 try {
// 		 	Thread.sleep(4000);
// 		 } catch (InterruptedException e) {
// 		 	e.printStackTrace();
// 		 }
// 		JSONObject jsonObject = new JSONObject();
//		 
// 		if (sessionmap == true) {
// 		 	jsonObject.put("js", "0");
// 		 	
// 		 }else{
// 			jsonObject.put("js", "1");
// 			 
// 		 }
// 		return jsonObject;
//     	} 
//	
////   	
////   	
////          // 抽取相同部分
// 			public boolean cz(String ja, String pt) {
// 				// 把十六进制数，转换为十进制相加
// 				int jia = CzUtil.FsZh(ja);
// 				// 十进制转换为十六进制
// 				String hex = Integer.toHexString(jia);
// 				// 截取相加结果后两位
// 				String je = null;
// 				for (int j = 0; j < hex.length() - 1; j++) {
// 					je = hex.charAt(hex.length() - 2) + "" + hex.charAt(hex.length() - 1);
// 				}
// 				String[] keys = new String[] { pt };
// 				String mString =ja+je+"FF";
// 				System.out.println("mString发送数据----------"+mString);
// 				// 解码
// 				byte[] b = CzUtil.jm(mString);
// 				ServerSessionMap sessionMap = ServerSessionMap.getInstance();
// 				boolean sessionmap = sessionMap.sendMessage(keys, b);
// 				return sessionmap;
// 			}
//		
//		return null;
//	}
	}