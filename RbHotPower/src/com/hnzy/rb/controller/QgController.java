package com.hnzy.rb.controller;

import java.util.ArrayList;
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
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import com.alibaba.fastjson.JSONObject;
import com.hnzy.rb.pojo.CxRb;
import com.hnzy.rb.pojo.Qg;
import com.hnzy.rb.pojo.Rb;
import com.hnzy.rb.pojo.Rz;
import com.hnzy.rb.service.CxRbService;
import com.hnzy.rb.service.QgService;
import com.hnzy.rb.service.RbService;
import com.hnzy.rb.service.RzService;
import com.hnzy.socket.RbidSDataUtil;
import com.hnzy.socket.server.ServerSessionMap;
import com.hnzy.socket.util.CzUtil;
import com.hnzy.socket.util.MapUtils;
import com.hnzy.socket.util.MapUtilsDf;

@Controller
@RequestMapping("QgCon")
public class QgController
{

	@Autowired
	private QgService qgServic;
	public List<Qg> qglist;
	@Autowired
	public RzService rzService;
	@Autowired
    private RbService rbService;
	@Autowired
	private CxRbService cxRbService;
	boolean sessionmap = false;
    public String ip;
    public int port;
    public String pString;
    private static Log log = LogFactory.getLog(QgController.class);
    
	@RequestMapping("findQg")
	public String findQg(HttpServletRequest request){
		qglist=qgServic.findQg();
		request.setAttribute("qglist", qglist);
		return "qygl";
	}
	@RequestMapping("QgTS")
	@ResponseBody
	public String QgTS(HttpSession session,Qg qg, String ids) {
		//日志
		Rz rz=new Rz();
		rz.setCz("热表系统，查询通讯状态,区管地址为:"+ids);
		rz.setCzr((String)session.getAttribute("userName"));
		rz.setCzsj(new Date());
		rzService.InsRz(rz);
		qg = qgServic.findQgID(ids);
		 ip = qg.getJzq().getJzqIp();
		 port = qg.getJzq().getJzqPort();
		 pString = qgTs(ip, port, ids);
		return pString;

	}
	
	// 实时热表数据
	@RequestMapping("SsRb")
	@ResponseBody
	public String SsRb(HttpSession session,Qg qg, String ids) {
		//日志
				Rz rz=new Rz();
				rz.setCz("热表系统，热表区管抄表:"+ids);
				rz.setCzr((String)session.getAttribute("userName"));
				rz.setCzsj(new Date());
				rzService.InsRz(rz);
		qg = qgServic.findQgID(ids);
		 ip = qg.getJzq().getJzqIp();
		 port = qg.getJzq().getJzqPort();
		 pString = sjRb(ip, port, ids);
		return pString;
	}
	
	
	   //区管查询通信状态
		public String qgTs(String jzqIp, int jzqPort,String ids) {
			String pt = "/" + jzqIp + ":" + jzqPort;
			String ja = "F0090500" + ids;//改为区管地址 F0 0A 05 00 AA AA AA AA XX FF 
			sessionmap = cz(ja, pt);//改为区管地址 F0 0A 05 01 D0 D0 D0 11 XX FF 
			
			log.info("查询通信状态发送数据："+ja);
			try {
				Thread.sleep(6000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (sessionmap == true && MapUtils.getMapUtils().get("qg")!=null && MapUtils.getMapUtils().get("qg") .equals(ids)) {
				 MapUtils.getMapUtils().add("qg", null);
				return "0";
			}else if (sessionmap == false) {
				 MapUtils.getMapUtils().add("qg", null);
				log.info("发送数据失败,集中器不在线");
				return "2";
			} else {
				 MapUtils.getMapUtils().add("qg", null);
				return "1";
			}
		}
		
	        	//实时数据
				public String sjRb(String ip, int port, String qgId) {
					 qgId = CzUtil.Uppercase(qgId).toString();
					System.out.println("批量读热表-----"+qgId);
					MapUtilsDf.getMapUtils().add("PlDRb", qgId);
					MapUtilsDf.getMapUtils().add("PldRb", null);
					//IP地址和端口号
					String pt = "/" + ip + ":" + port;
					// fmId十进制
					String ja = "F00B1500" + qgId+"04";
					log.info("实时数据发送数据："+ja);
					sessionmap = cz(ja, pt);
					
					try {
						Thread.sleep(7000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					if (sessionmap == true && MapUtilsDf.getMapUtils().get("PldRb")!=null && MapUtilsDf.getMapUtils().get("PldRb").equals("su")) {
						MapUtilsDf.getMapUtils().add("PlDRb", null);
						MapUtilsDf.getMapUtils().add("PldRb", null);
						return "0";
					}else if (sessionmap == false) {
						MapUtilsDf.getMapUtils().add("PlDRb", null);
						MapUtilsDf.getMapUtils().add("PldRb", null);
						log.info("发送数据失败,集中器不在线");
						return "2";
					}else {
						MapUtilsDf.getMapUtils().add("PlDRb", null);
						MapUtils.getMapUtils().add("PldRb", null);
						return "1";
					} 
					
				}
				
				
				//---------------查询热表地址
				@RequestMapping("CxRbId")
				@ResponseBody
				public JSONObject CxRbId(HttpSession session,Qg qg, String ids){
					MapUtils.getMapUtils().add("CxRbId", null);
					//查询热表地址之前删除原来的热表地址--------
//					rbService.DeleteRbId();
					//请控值
//					cxRbService.updateRbId();
					//日志
					Rz rz=new Rz();
					rz.setCz("查询热表地址，区管地址为:"+ids);
					rz.setCzr((String)session.getAttribute("userName"));
					rz.setCzsj(new Date());
					rzService.InsRz(rz);
					qg = qgServic.findQgID(ids);
					ip = qg.getJzq().getJzqIp();
					port = qg.getJzq().getJzqPort();
					//IP地址和端口号
					String pt = "/" + ip + ":" + port;
					// fmId十进制
					String ja = "F00A2900" + ids;
					log.info("查询热表地址"+ja);
					sessionmap = cz(ja, pt);
					
					try {
						Thread.sleep(6000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					JSONObject jsonObject=new JSONObject();
//					if (sessionmap == true && MapUtils.getMapUtils().get("CxRbId")!=null && MapUtils.getMapUtils().get("CxRbId").equals(ids)) {
						if (sessionmap == true) {
						MapUtils.getMapUtils().add("CxRbId", null);
						jsonObject.put("js","0");
					} else if (sessionmap == false) {
						MapUtils.getMapUtils().add("CxRbId", null);
						log.info("发送数据失败,集中器不在线");
						jsonObject.put("js","2");
					}else {
						MapUtils.getMapUtils().add("CxRbId", null);
						jsonObject.put("js","1");
					}
				 	return jsonObject;
				 	//成功之后返回到查找热表id页面
				 	
				}
				//查询热表地址
				@RequestMapping("rbId")
				public String rbId(HttpServletRequest request){
		        List<Rb> findRbId=rbService.findRbId();
		        request.setAttribute("rbIdList",findRbId);
					return"rbId";
					
				}
				//删除热表地址
				@RequestMapping("DeleteRbId")
				public String DeleteRbId(){
					rbService.DeleteRbId();
					return"rbId";
				}
			     // 添加热表地址
				@RequestMapping("addRb")
				@ResponseBody
				public JSONObject addRb(Qg qg,HttpSession session,Rb rb, String qgId) {
					MapUtils.getMapUtils().add("addRbId", null);
					qg = qgServic.findQgID(qgId);
					 ip = qg.getJzq().getJzqIp();
					 port = qg.getJzq().getJzqPort();
					 String HzrbAds = "";
					 String HmrbAds = "";
					 String HdrbAds = "";	 
			    	//日志
					Rz rz=new Rz();
					rz.setCz("热表系统，添加热表区管地址:"+qgId);
					rz.setCzr((String)session.getAttribute("userName"));
					rz.setCzsj(new Date());
					rzService.InsRz(rz);
						// IP地址和端口号
						String pt = "/" + ip + ":" + port;
						System.out.println("ip------------"+pt);
						
						 List<Rb> findrb=rbService.findRbYh(qgId);
						 for(int i=0;i<findrb.size();i++){
							 int rblb=findrb.get(i).getYh().getRblb();
							 //汇中热表
							 if(rblb==1){
								 String hrb=findrb.get(i).getRbAd().substring(1).trim();
								 HzrbAds+="FFFFF"+hrb;
							 }
							 //荷德鲁美特
							 if(rblb==2){
								 HdrbAds+="FFFFFF"+findrb.get(i).getRbAd().trim();
							 }
							 //鲁普
							 if(rblb==3){
								 HmrbAds+="FFFFFF"+findrb.get(i).getRbAd().trim();
							 }
						 }
						 
						 //汇中热表
						 if(null!=HzrbAds&&HzrbAds.length()>0){
							
							List<String> list=new ArrayList<String>();
								for(int i=0;i<HzrbAds.length();i=i+420){
									if(HzrbAds.length()>i+420){
										String r=HzrbAds.substring(i, i+420);
										list.add(r);
									}else{
										String r=HzrbAds.substring(i, HzrbAds.length());
										list.add(r);
									}
									
								}
								//每30个位一组
								for(int i=0;i<list.size();i++){
									//热表地址
									String rbIds=list.get(i);
									 Integer adCd=rbIds.length()/2+11;
										//长度十进制转换为十六进制
							    	     String adCds=Integer.toHexString(adCd);
							    	     if(adCds.length()==1){
							    	    	 adCds="0"+adCds;
							    	     }				    	     
									 String ja = "F0"+adCds+"1D00"+qgId+"01"+rbIds;
									
									 try {
										Thread.sleep(2000);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									 
									 sessionmap = cz(ja, pt);
									 log.info("汇中添加热表区管地址："+qgId);
								}	
								
						 }
						 //荷德鲁美特
						 if(null!=HdrbAds&&HdrbAds.length()>0){
							 List<String> list=new ArrayList<String>();
								for(int i=0;i<HdrbAds.length();i=i+420){
									if(HdrbAds.length()>i+420){
										String r=HdrbAds.substring(i, i+420);
										list.add(r);
									}else{
										String r=HdrbAds.substring(i, HdrbAds.length());
										list.add(r);
									}
									
								}
								
								
								//每30个位一组
								for(int i=0;i<list.size();i++){
									//热表地址
									String rbIds=list.get(i);
									 Integer adCd=rbIds.length()/2+11;
										//长度十进制转换为十六进制
							    	     String adCds=Integer.toHexString(adCd);
							    	     if(adCds.length()==1){
							    	    	 adCds="0"+adCds;
							    	     }
									 String ja = "F0"+adCds+"1D00"+qgId+"02"+rbIds;
									 
									 try {
											Thread.sleep(2000);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									 sessionmap = cz(ja, pt);
									 
									 log.info("荷德鲁美特添加热表区管地址："+qgId);
								}	
								
						 }
						 
						 //鲁普
						 if(null!=HmrbAds&&HmrbAds.length()>0){
							 List<String> list=new ArrayList<String>();
								for(int i=0;i<HmrbAds.length();i=i+420){
									if(HmrbAds.length()>i+420){
										String r=HmrbAds.substring(i, i+420);
										list.add(r);
									}else{
										String r=HmrbAds.substring(i, HmrbAds.length());
										list.add(r);
									}
									
								}
								
								//每30个位一组
								for(int i=0;i<list.size();i++){
									//热表地址
									String rbIds=list.get(i);
									 Integer adCd=rbIds.length()/2+11;
//										//长度十进制转换为十六进制
							    	     String adCds=Integer.toHexString(adCd);
							    	     if(adCds.length()==1){
							    	    	 adCds="0"+adCds;
							    	     }
							    	 
									 String ja = "F0"+adCds+"1D00"+qgId+"01"+rbIds;
									 
									 try {
											Thread.sleep(2000);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									 sessionmap = cz(ja, pt);
									 log.info("卡姆鲁普添加热表区管地址："+qgId);
								}	
						 }

						try {
		    				Thread.sleep(3000);

		    			} catch (InterruptedException e) {
		    				e.printStackTrace();
		    			}
						JSONObject jsonObject =new JSONObject();
//						if (sessionmap == true && MapUtils.getMapUtils().get("addRbId")!=null && MapUtils.getMapUtils().get("addRbId").equals("success")) {
						if (sessionmap == true) {
							//添加热表地址后更新数据库热表地址
//							rbService.updateRbAd(ids,xgRb);
							MapUtils.getMapUtils().add("addRbId", null);
							jsonObject.put("js", "0"); 
							return jsonObject;
						} else if (sessionmap == false) {
							//添加热表地址后更新数据库热表地址
							MapUtils.getMapUtils().add("addRbId", null);
							jsonObject.put("js", "2");
							log.info("发送数据失败,集中器不在线");
							return jsonObject;
						} else {
							MapUtils.getMapUtils().add("addRbId", null);
							jsonObject.put("js", "1");
							return jsonObject;
					   }
					}
				
					      // 修改区管地址
							@RequestMapping("xgQgId")
							@ResponseBody
							public JSONObject xgQgId(Qg qg,HttpSession session,Rb rb, String ids,String xgQgId) {
								qg = qgServic.findQgID(ids);
								 ip = qg.getJzq().getJzqIp();
								 port = qg.getJzq().getJzqPort();
						    	//日志
								Rz rz=new Rz();
								rz.setCz("热表系统,修改热表ID:"+ids+"修改为："+xgQgId);
								rz.setCzr((String)session.getAttribute("userName"));
								rz.setCzsj(new Date());
								rzService.InsRz(rz);	
									// IP地址和端口号
									String pt = "/" + ip + ":" + port;
									String ja = "F00E3A00"+ids+xgQgId;
									log.info("修改区管ID发送数据："+ja);
									boolean sessionmap = cz(ja, pt);
									try {
					    				Thread.sleep(6000);

					    			} catch (InterruptedException e) {
					    				e.printStackTrace();
					    			}
									JSONObject jsonObject=new JSONObject();
									if (sessionmap == true && MapUtils.getMapUtils().get("UpQg")!=null && MapUtils.getMapUtils().get("UpQg").equals(ids)) {
										MapUtils.getMapUtils().add("UpQg", null);
										//添加热表地址后更新数据库热表地址
//										rbService.updateRbAd(ids,xgRb);
										jsonObject.put("js", "0");
										return jsonObject;
									}else if (sessionmap == false && MapUtils.getMapUtils().get("UpQg") == null) {
										MapUtils.getMapUtils().add("UpQg", null);
										//添加热表地址后更新数据库热表地址
//										rbService.updateRbAd(ids,xgRb);
//										rbService.updateYhRbAd(ids, xgRb);
										jsonObject.put("js", "2");
										log.info("发送数据失败,集中器不在线");
										return jsonObject;
									} else {
										MapUtils.getMapUtils().add("Crb", null);
										jsonObject.put("js", "1");
										return jsonObject;
								   }
								}
							
				// 删除
				@RequestMapping("dropRb")
				@ResponseBody
				public JSONObject dropRb(Qg qg,HttpSession session,Rb rb, String ids) {
					MapUtils.getMapUtils().add("deleteRbId", null);
			    	//日志
					Rz rz=new Rz();
					rz.setCz("热表系统，删除区管下的热表地址,区管地址为："+ids);
					rz.setCzr((String)session.getAttribute("userName"));
					rz.setCzsj(new Date());
					rzService.InsRz(rz);
					qg = qgServic.findQgID(ids);
					 ip = qg.getJzq().getJzqIp();
					 port = qg.getJzq().getJzqPort();
					 System.out.println(ids);
					 List<Rb> findrb=rbService.findRblb(ids);
					 for(int i=0;i<findrb.size();i++){
						 int rblb=findrb.get(i).getYh().getRblb();
						// IP地址和端口号
						String pt = "/" + ip + ":" + port;
						String ja = "F00B1F00"+ids+"0"+rblb;
						log.info("删除热表，热表类型为："+rblb+"--"+ja);
						
						 sessionmap = cz(ja, pt);
						 try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					 }					
						try {
		    				Thread.sleep(2000);

		    			} catch (InterruptedException e) {
		    				e.printStackTrace();
		    			}
						JSONObject jsonObject=new JSONObject();
//						if (sessionmap == true &&  MapUtils.getMapUtils().get("deleteRbId")!=null && MapUtils.getMapUtils().get("deleteRbId").equals(ids)) {
						if (sessionmap == true ) {
							MapUtils.getMapUtils().add("deleteRbId", null);
							jsonObject.put("js", "0");
							return jsonObject;
						} else if (sessionmap == false) {
							MapUtils.getMapUtils().add("deleteRbId", null);
							jsonObject.put("js", "2");
							log.info("发送数据失败,集中器不在线");
							return jsonObject;
						} else {
							MapUtils.getMapUtils().add("deleteRbId", null);
							jsonObject.put("js", "1");
							return jsonObject;
					   }
					}
				
				// 抽取相同部分
				public boolean cz(String ja, String pt) {
					// 把十六进制数，转换为十进制相加
					int jia = CzUtil.FsZh(ja);
					// 十进制转换为十六进制
					String hex = Integer.toHexString(jia);
					StringBuffer stringBuffer = new StringBuffer();
					// 转换为大写
					if (hex != null) {
						for (int i = 0; i < hex.length(); i++) {
							char c = hex.charAt(i);
							if (!Character.isDigit(c)) {
								stringBuffer.append(Character.toUpperCase(c));
							} else {
								stringBuffer.append(c);
							}
						}
					}
					String sH = stringBuffer.toString();
					// 截取相加结果后两位
					String je = null;
					for (int j = 0; j < sH.length() - 1; j++) {
						je = sH.charAt(sH.length() - 2) + "" + sH.charAt(sH.length() - 1);
					}
					String[] keys = new String[] { pt };
					String mString = ja + "" + je + "FF";
					System.out.println(mString);
					// 解码
					byte[] b = CzUtil.jm(mString);
					ServerSessionMap sessionMap = ServerSessionMap.getInstance();
					boolean sessionmap = sessionMap.sendMessage(keys, b);
					return sessionmap;
				}
}
