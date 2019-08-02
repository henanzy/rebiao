package com.hnzy.rb.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.hnzy.custompojo.LineDataModel;
import com.hnzy.rb.pojo.Rb;
import com.hnzy.rb.pojo.Rz;
import com.hnzy.rb.pojo.Village;
import com.hnzy.rb.service.RbService;
import com.hnzy.rb.service.RzService;
import com.hnzy.rb.service.VillageService;
import com.hnzy.rb.util.DateUtil;
import com.hnzy.socket.server.ServerSessionMap;
import com.hnzy.socket.util.CzUtil;
import com.hnzy.socket.util.MapUtils;
import com.hnzy.socket.util.MapUtilsDf;

@Controller
@RequestMapping("RbCon")
public class RbController
{
	@Autowired
    private RbService rbService;
	@Autowired
	private VillageService villageService;
	@Autowired
	private RzService rzService;
	private List<Rb> rbList;
	private Rb rb;
	private List<Village> yhInfoList;
	private static Log log = LogFactory.getLog(RbController.class);
	String param = null;
	//根据小区楼栋单元查找热表信息树形图
	@RequestMapping("findRb")
	public String findRb(HttpServletRequest request,String xqName,String rbLyName,String cellNO,String houseNO) throws UnsupportedEncodingException{	
		xqName = new String(xqName.getBytes("ISO-8859-1"), "utf-8") + "";
	  if(rbLyName!=null){
		  if(cellNO!=null){
				cellNO = new String(cellNO.getBytes("ISO-8859-1"), "utf-8") + "";    
				if(houseNO!=null){
					houseNO = new String(houseNO.getBytes("ISO-8859-1"), "utf-8") + "";    
				}
		  }
			rbLyName = new String(rbLyName.getBytes("ISO-8859-1"), "utf-8") + "";
	  }
//		houseNO = new String(houseNO.getBytes("ISO-8859-1"), "utf-8") + "";
		rbList=rbService.findRb(xqName, rbLyName, cellNO, houseNO);
		request.setAttribute("rbList",rbList);
		return "rbList";
	}
	//查询和四小区的热表信息为默认信息
	@RequestMapping("find")
	public String find(HttpServletRequest request){
		rbList=rbService.find();
		request.setAttribute("rbList",rbList);
		return "rbList";
	}
	
	//热表跳转
	@RequestMapping("ztreeMe")
	public String ztreeMe(){
		return "ztreeMe";
		
	}
	//跳转到设备维护界面
	@RequestMapping("SbMe")
	public String SbMe(){
		return "SbMe";
	}
	//跳转到数据报表界面
	@RequestMapping("SbMeSbb")
	public String SbHisMe(){
		return "SbMeSbb";
	}
	//跳转到异常检测界面
	@RequestMapping("SbYcjcMe")
	public String SbYcjcMe(){
		return "SbYcjcMe";
	}
	//跳转到信息管理界面
	@RequestMapping("SbxxgsMe")
	public String SbxxgsMe(){
		return "SbxxgsMe";
	}
	//跳转到图标分析界面
	@RequestMapping("SbTjfxMe")
	public String SbTbfxMe(){
		return "SbTjfx";
		
	}
	@ResponseBody
	@RequestMapping("findRbHis")
	public JSONObject findRbHis(int Sxx){
		JSONObject jsonObject=new JSONObject();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    Date date=new Date();  
	    Calendar calendar = Calendar.getInstance();  
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
	    Date date1=new Date();
		String time1=sdf.format(date1);//当前时间
		if(Sxx==1){
			calendar.add(Calendar.DAY_OF_MONTH, -2);  
		    date = calendar.getTime(); 
		    String time=sdf.format(date);//三天后的时间
			rbList=rbService.findRbHis(time,time1);
		}else if(Sxx==2){
			calendar.add(Calendar.DAY_OF_MONTH, -4);  
		    date = calendar.getTime(); 
		    String time=sdf.format(date);//五天后的时间
			rbList=rbService.findRbHis(time,time1);
		}else if(Sxx==0){
			rbList=null;
		}else if(Sxx==4){
			calendar.add(Calendar.DAY_OF_MONTH, -1);  
		    date = calendar.getTime(); 
		    String time=sdf.format(date);//近一天的时间
			rbList=rbService.findRbHis(time,time1);
		}else{
			calendar.add(Calendar.DAY_OF_MONTH, -5);  
		    date = calendar.getTime(); 
		    String time=sdf.format(date);//一周后的时间
			rbList=rbService.findRbHis(time,time1);
		}
		jsonObject.put("findList",rbList);
		return jsonObject;
	}
	
	//搜索故障信息
	@ResponseBody
	@RequestMapping("findRbGzxx")
	public JSONObject findRbGzxx(String gzxx) throws UnsupportedEncodingException{
		gzxx = new String(gzxx.getBytes("ISO-8859-1"), "utf-8") + "";
		JSONObject jsonObject=new JSONObject();
		rbList=rbService.findRbGzxx(gzxx);
		jsonObject.put("findList",rbList);
		return jsonObject;
	}
	
	
	//用户备注
	@RequestMapping("Yhbz")
	public String Yhbz(HttpServletRequest request){
		yhInfoList = villageService.findXQ();
		request.setAttribute("yhInfoList", yhInfoList);
		return "Yhbz";
	}
	//根据小区楼栋单元户号获取这户备注信息
	@ResponseBody
	@RequestMapping("findBzxx")
	public JSONObject findBzxx(String xqName,String rbLyName,String cellNo,String houseNo) throws UnsupportedEncodingException{
		xqName = new String(xqName.getBytes("ISO-8859-1"), "utf-8") + "";
		JSONObject jsonObject=new JSONObject();
		  if(rbLyName!=null){
			  if(cellNo!=null){
				  cellNo = new String(cellNo.getBytes("ISO-8859-1"), "utf-8") + "";    
					if(houseNo!=null){
						houseNo = new String(houseNo.getBytes("ISO-8859-1"), "utf-8") + "";    
					}
			  }
				rbLyName = new String(rbLyName.getBytes("ISO-8859-1"), "utf-8") + "";
		  }
		rb=rbService.findBzxx(xqName, rbLyName, cellNo, houseNo);
		if(rb==null){
		   jsonObject.put("bz","查找失败!请重新搜索");
		}else{
			jsonObject.put("bz", rb.getYh().getBz());
		}
		return jsonObject;
		
	}
	//根据小区楼栋单元户号更新用户备注
	@RequestMapping("Upbz")
	@ResponseBody
	public JSONObject Upbz(String bz,String xqName,String rbLyName,String cellNo,String houseNo) throws UnsupportedEncodingException{
		xqName = new String(xqName.getBytes("ISO-8859-1"), "utf-8") + "";
	
		bz = new String(bz.getBytes("ISO-8859-1"), "utf-8") + "";
		JSONObject jsonObject=new JSONObject();
		String str;
		if(xqName.equals("")&&rbLyName.equals("")&&cellNo.equals("")&&houseNo==null){
			 str="更新失败!";
				jsonObject.put("str", str);
		}else{
			rbLyName = new String(rbLyName.getBytes("ISO-8859-1"), "utf-8") + "";
			cellNo = new String(cellNo.getBytes("ISO-8859-1"), "utf-8") + "";
			houseNo = new String(houseNo.getBytes("ISO-8859-1"), "utf-8") + "";
			List<Rb> findRbAd=rbService.SelRbAd(xqName, rbLyName, cellNo, houseNo);
			String rbAd=findRbAd.get(0).getRbAd();
			rbService.upRbbz(rbAd, bz);
//			rbService.Upbz(bz,xqName, buildNo, cellNo, houseNo);
			 str="更新成功!";
			jsonObject.put("str", str);
		}
		
		return jsonObject;
		
	}
	//信息管理
	@RequestMapping("Sbxxgs")
	public String Sbxxgs(ModelMap map,HttpServletRequest request){
		rbList=rbService.find();
		yhInfoList = villageService.findXQ();
		request.setAttribute("yhInfoList", yhInfoList);
		map.addAttribute("rbList",rbList);
		return "Sbxxgs";
	}
	//跳转到修改用户界面
	@RequestMapping("updYhMe")
	public String updYhMe(HttpServletRequest request,HttpSession session ,Integer  id){
		String userName=(String) session.getAttribute("userName");
		System.out.println("userName--------------"+userName);
		request.setAttribute("userName", userName);
		rb=rbService.findById(id);
		request.setAttribute("rb",rb);
		return "updYhMe";
	}
	//gs供水温度hs回水温度 wc温差为负数
	@RequestMapping("SbYcjc")
	public String SbYcjc(HttpServletRequest request,Double gs,Double hs,Integer wc){
		rbList=rbService.SbSelExp(gs, hs, wc);
		request.setAttribute("rbList",rbList);
		return "SbYcjc";
	}
	
	//gs供水温度hs回水温度 wc温差为负数搜索
	@RequestMapping("SelSbYcjc")
	@ResponseBody
	public JSONObject SelSbYcjc(Double gs,Double hs,Integer wc){
		JSONObject jsonObject=new JSONObject();
		rbList=rbService.SbSelExp(gs, hs, wc);
		jsonObject.put("rbList", rbList);
		return jsonObject;
	}
	//提交更新数据
	@RequestMapping("UpSbxx")
	public String UpSbxx(String rbAd,String yhName,String xqName,String rbLyName,String cellNO,String houseNO,String rbfl,String bz){
//		Rb rb=new Rb();
		Integer Rbfl;
		if(rbfl.equals("流量")){
			Rbfl=0;
		}else{
			Rbfl=1;
		}
		rb.getYh().setYhName(yhName);
		rb.getYh().setXqName(xqName);
		rb.getYh().setRbLyName(rbLyName);
		rb.getYh().setCellNO(cellNO);
		rb.getYh().setHouseNO(houseNO);
		rb.setRbAd(rbAd);
		rb.getYh().setRbfl(Rbfl);
		rb.getYh().setBz(bz);
		//更新热表地址
		rbService.UpRbVal(rb);
		//更新用户表用户名称和热表地址
		rbService.UpSbxx(rb);
		return "redirect: SbxxgsMe.action";
	}
	//抄取热表信息
	@RequestMapping("RbList")
	public String RbList(HttpServletRequest request,ModelMap map){
		yhInfoList = villageService.findXQ();
		rbList=rbService.find();
		map.addAttribute("yhInfoList", yhInfoList);
		request.setAttribute("rbList",rbList);
		return "CrbList";
		}
	        // 获取所有的小区
			@RequestMapping("findYhNameList")
			public String findYhNameList(@RequestParam(value = "pageNum", required = false) String pageNum, ModelMap map) {
				yhInfoList = villageService.findXQ();
				map.addAttribute("yhInfoList", yhInfoList);
				return "sbgls/fmgl";
			}

			// 根据小区获取楼栋号
			@RequestMapping("findYhBuildNObyXqName")
			@ResponseBody
			public JSONObject findYhBuildNObyXqName(Village village,String xqName) throws UnsupportedEncodingException {
				xqName = new String(xqName.getBytes("ISO-8859-1"), "utf-8") + "";
				village.setXqName(xqName);
				yhInfoList = villageService.findBOByXQ(village);
				JSONObject jsonObject = new JSONObject();
				if (yhInfoList != null) {
					jsonObject.put("xqlist", yhInfoList);
				} else {
					jsonObject.put("fail", null);
				}
				return jsonObject;
			}

			// 根据小 区楼栋号获取单元号
			@RequestMapping("findYhCellNOByBuild")
			@ResponseBody
			public JSONObject findYhCellNOByBuild(Village village,@Param("build") String build, @Param("xqName") String xqName)
					throws UnsupportedEncodingException {
				xqName = new String(xqName.getBytes("ISO-8859-1"), "utf-8") + "";
				build = new String(build.getBytes("ISO-8859-1"), "utf-8") + "";
				village.setXqName(xqName);
				village.setRbLyName(build);
				yhInfoList = villageService.findCOByXQAndBO(village);
				JSONObject jsonObject = new JSONObject();
				if (yhInfoList != null) {
					jsonObject.put("cellList", yhInfoList);
				} else {
					jsonObject.put("fail", null);
				}
				return jsonObject;

			}
			// 读热表
			@RequestMapping("rebInfo")
			@ResponseBody
			public JSONObject Crb(HttpSession session,Rb rb, String ids) {
				String qgId = null;
				String rbid =null;
				
				rb =rbService.findByRbAd(ids);
			
				int rblb=rb.getYh().getRblb();
				qgId = rb.getQgId();
				JSONObject jsonObject=new JSONObject();
		    	String xqName = rb.getYh().getXqName();
		    	String BuildNo = rb.getYh().getBuildNO();
		    	String CellNo = rb.getYh().getCellNO();
		    	String HouseNo = rb.getYh().getHouseNO();
		    	if(rblb==1){
		    	ids=ids.substring(1);
		    	}
				MapUtilsDf.getMapUtils().add("dRbParam", ids);
		    	//日志
				Rz rz=new Rz();
				rz.setCz("热表系统，读取热表,热表地址为:"+ids+"用户地址:"+xqName+"-"+BuildNo+"-"+CellNo+"-"+HouseNo);
				rz.setCzr((String)session.getAttribute("userName"));
				rz.setCzsj(new Date());
				rzService.InsRz(rz);
					// 区管ID
					String ip =rb.getQg().getJzq().getJzqIp();
					// 端口号
					int port = rb.getQg().getJzq().getJzqPort();
					// IP地址和端口号
					
					String pt = "/" + ip + ":" + port;
					String rbd = String.format("%14s", ids);
					rbid = rbd.replaceAll("\\s", "F");
					String ja = "F0121500" + qgId +"0"+rblb+rbid;
					log.info("读热表发送数据："+ja);
					boolean sessionmap = cz(ja, pt);
					try {
	    				Thread.sleep(6000);

	    			} catch (InterruptedException e) {
	    				e.printStackTrace();
	    			}
					if (sessionmap == true &&  MapUtils.getMapUtils().get("Crb")!=null && MapUtils.getMapUtils().get("Crb").equals(ids)) {
						MapUtils.getMapUtils().add("Crb", null);
						jsonObject.put("js", "0");
						jsonObject.put("rbId", "小区:" + xqName + "楼栋号:" + BuildNo + "单元号:" + CellNo + "户号:" + HouseNo);
						return jsonObject;
					}else if (sessionmap == false && MapUtils.getMapUtils().get("Crb") == null) {
						MapUtils.getMapUtils().add("Crb", null);
						jsonObject.put("js", "4");
						jsonObject.put("rbId", "小区:" + xqName + "楼栋:" + BuildNo + "单元:" + CellNo + "户号:" + HouseNo);
						log.info("发送数据失败,集中器不在线");
						return jsonObject;
					} else {
						MapUtils.getMapUtils().add("Crb", null);
						jsonObject.put("js", "1");
						jsonObject.put("rbId", "小区:" + xqName + "楼栋:" + BuildNo + "单元:" + CellNo + "户号:" + HouseNo);
						return jsonObject;
				   }
				}
		
			       
			// 抽取相同部分
			public boolean cz(String ja, String pt) {

				// 把十六进制数，转换为十进制相加
				int jia = CzUtil.FsZh(ja);
				// 十进制转换为十六进制
				String hex = Integer.toHexString(jia);
				// 截取相加结果后两位
				String je = null;
				for (int j = 0; j < hex.length() - 1; j++) {
					je = hex.charAt(hex.length() - 2) + "" + hex.charAt(hex.length() - 1);
				}
				String[] keys = new String[] { pt };
				String mString = ja + je + "FF";
				// 解码
				byte[] b = CzUtil.jm(mString);
				ServerSessionMap sessionMap = ServerSessionMap.getInstance();
				boolean sessionmap = sessionMap.sendMessage(keys, b);
				return sessionmap;
			}
			//搜索热表信息
			@RequestMapping("searchRb")
			@ResponseBody
			public JSONObject searchRb(HttpServletRequest request, ModelMap map, @Param("xqName") String xqName,@Param("rbfl") Integer rbfl,
					@Param("rbLyName") String rbLyName, @Param("cellNo") String  cellNo, @Param("houseNo") String houseNo)
					throws UnsupportedEncodingException {
				  if(rbLyName!=null){
					  if(cellNo!=null){
						  cellNo = new String(cellNo.getBytes("ISO-8859-1"), "utf-8") + "";    
							if(houseNo!=null){
								houseNo = new String(houseNo.getBytes("ISO-8859-1"), "utf-8") + "";    
							}
					  }
						rbLyName = new String(rbLyName.getBytes("ISO-8859-1"), "utf-8") + "";
				  }
				xqName = new String(xqName.getBytes("ISO-8859-1"), "utf-8") + "";
				JSONObject jsonObject = new JSONObject();
				rbList=rbService.findRbAll(xqName, rbLyName, cellNo, houseNo,rbfl);
				jsonObject.put("findList",rbList);
				// 小区名称
				yhInfoList = villageService.findXQ();
				// 列表
				return jsonObject;
			}
			
			//搜索热表信息数据报表
			@RequestMapping("searchRbSbb")
			@ResponseBody
			public JSONObject searchRbSbb(HttpServletRequest request, ModelMap map, @Param("xqName") String xqName,@Param("rbfl") Integer rbfl,
					@Param("buildNo") String buildNo, @Param("cellNo") String  cellNo, @Param("houseNo") String houseNo,@Param("recordTime1") String recordTime1,@Param("recordTime2") String recordTime2)
					throws UnsupportedEncodingException {
				xqName = new String(xqName.getBytes("ISO-8859-1"), "utf-8") + "";
				buildNo = new String(buildNo.getBytes("ISO-8859-1"), "utf-8") + "";
				JSONObject jsonObject = new JSONObject();
				if(recordTime1!="" || recordTime2!=""){
					rbList=rbService.searchHis(xqName, buildNo, cellNo, houseNo, recordTime1, recordTime2);
				}else{
					rbList=rbService.searchSbb(xqName, buildNo, cellNo, houseNo, recordTime1, recordTime2,rbfl);
				}
				jsonObject.put("findList",rbList);
				// 小区名称
				yhInfoList = villageService.findXQ();
				// 列表
				return jsonObject;
			}
			
//			//搜索热表信息数据报表
//			@RequestMapping("searchRbsljj")
//			@ResponseBody
//			public JSONObject searchRbsljj(HttpServletRequest request, ModelMap map, @Param("xqName") String xqName,@Param("rbfl") Integer rbfl,
//					@Param("buildNo") Integer buildNo, @Param("cellNo") Integer  cellNo, @Param("houseNo") Integer houseNo,@Param("recordTime1") String recordTime1,@Param("recordTime2") String recordTime2)
//					throws UnsupportedEncodingException {
//				xqName = new String(xqName.getBytes("ISO-8859-1"), "utf-8") + "";
//				JSONObject jsonObject = new JSONObject();
//				if(recordTime1!="" || recordTime2!=""){
//					rbList=rbService.searchHis(xqName, buildNo, cellNo, houseNo, recordTime1, recordTime2);
//				}else{
//					rbList=rbService.searchSbb(xqName, buildNo, cellNo, houseNo, recordTime1, recordTime2,rbfl);
//				}
//				jsonObject.put("findList",rbList);
//				// 小区名称
//				yhInfoList = villageService.findXQ();
//				// 列表
//				return jsonObject;
//			}
			@RequestMapping("RbdoExportExcel")
			@ResponseBody
			public JSONObject RbdoExportExcel(HttpServletRequest request ,HttpServletResponse response, ModelMap map, @Param("xqName") String xqName,Integer rbfl,
					@Param("buildNo") String buildNo, @Param("cellNo") String cellNo, @Param("houseNo") String houseNo,@Param("recordTime1") String recordTime1,@Param("recordTime2") String recordTime2)
					throws IOException {
				xqName = new String(xqName.getBytes("ISO-8859-1"), "utf-8") + "";
				//告诉浏览器要弹出的文档类型
						response.setContentType("application/x-execl");
						//告诉浏览器这个文档作为附件给别人下载（放置浏览器不兼容，文件要编码）
//						response.setHeader("Content-Disposition", "attachment;filename="+new String("用户信息列表.xls".getBytes(),"ISO-8859-1"));
						//获取输出流
				         response.setCharacterEncoding("utf-8");
				           response.setHeader("content-disposition", "attachment;filename=" + new String(xqName.getBytes(), "ISO8859-1") + ".xls" );
				JSONObject jsonObject = new JSONObject();
				if (recordTime1!="" || recordTime2!="") {
					if(buildNo!=null){
						buildNo = new String(buildNo.getBytes("ISO-8859-1"), "utf-8") + "";
					}
					if(cellNo!=null){
						cellNo = new String(cellNo.getBytes("ISO-8859-1"), "utf-8") + "";
					}
					ServletOutputStream outputStream=response.getOutputStream();
					rbList=rbService.searchHisExcel(xqName, buildNo, cellNo, houseNo, recordTime1, recordTime2);
					rbService.exportExcel(rbList, outputStream);
					if(outputStream!=null){
						outputStream.close();
					}
				}else{
					if(buildNo!=null){
						buildNo = new String(buildNo.getBytes("ISO-8859-1"), "utf-8") + "";
					}
					if(cellNo!=null){
						cellNo = new String(cellNo.getBytes("ISO-8859-1"), "utf-8") + "";
					}
					ServletOutputStream outputStream=response.getOutputStream();
					rbList=rbService.searchSbb(xqName, buildNo, cellNo, houseNo, recordTime1, recordTime2,rbfl);
					rbService.exportExcel(rbList, outputStream);
					if(outputStream!=null){
						outputStream.close();
					}	
				}
				// 小区名称
				yhInfoList = villageService.findXQ();
				// 列表
				return jsonObject;
			}
			//查询抄表日期
			@RequestMapping("CbJc")
			@ResponseBody
			public JSONObject CbJc(int cb,String xqName,@Param("rbLyName") String rbLyName, @Param("cellNo") String  cellNo) throws UnsupportedEncodingException{
				xqName = new String(xqName.getBytes("ISO-8859-1"), "utf-8") + "";
				JSONObject jsonObject=new JSONObject();
				//今日抄表用户
				 Calendar calendar = Calendar.getInstance();
				 calendar.setTime(new Date());
				 calendar.set(Calendar.HOUR_OF_DAY, 0);
				 calendar.set(Calendar.MINUTE, 0);
				 calendar.set(Calendar.SECOND, 0);
				 calendar.add(Calendar.DATE, -1);
				 Date start = calendar.getTime();
	                String dateStr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(start);
	                
	                if(rbLyName!=null){
						  if(cellNo!=null){
							  cellNo = new String(cellNo.getBytes("ISO-8859-1"), "utf-8") + "";    
								if(rbLyName!=null){
									rbLyName = new String(rbLyName.getBytes("ISO-8859-1"), "utf-8") + "";    
								}
						  }
							rbLyName = new String(rbLyName.getBytes("ISO-8859-1"), "utf-8") + "";
					  }
				if(cb==0){
					rbList=rbService.JrCb( xqName,rbLyName,cellNo,dateStr);
					jsonObject.put("findList",rbList);
				}else{
					//今日未抄表用户
					rbList=rbService.JrWCb( xqName,rbLyName,cellNo,dateStr);
					jsonObject.put("findList",rbList);
				}
				return jsonObject;
				
			}
			//抄取热表信息
			@RequestMapping("RbListSbb")
			public String RbListSbb(HttpServletRequest request,ModelMap map){
				yhInfoList = villageService.findXQ();
				rbList=rbService.find();
				map.addAttribute("yhInfoList", yhInfoList);
				request.setAttribute("rbList",rbList);
				return "CrbListSbb";
			}
			//历史信息
			@RequestMapping("RbListsjsj")
			public String RbListsjsj(HttpServletRequest request,ModelMap map){
				yhInfoList = villageService.findXQ();
				rbList=rbService.find();
				map.addAttribute("yhInfoList", yhInfoList);
				request.setAttribute("rbList",rbList);
				return "CrbListlssj";
			}
			//导出
			@RequestMapping("RbExportExcel")
			public void  RbExportExcel(HttpSession session,HttpServletResponse response,Double gs,Double hs,Integer wc) throws IOException{
				//告诉浏览器要弹出的文档类型
				response.setContentType("application/x-execl");
				//告诉浏览器这个文档作为附件给别人下载（放置浏览器不兼容，文件要编码）
				response.setHeader("Content-Disposition", "attachment;filename="+new String("用户信息列表.xls".getBytes(),"ISO-8859-1"));
				//获取输出流

						ServletOutputStream outputStream=response.getOutputStream();
						rbService.exportExcel(rbService.SbSelExp(gs, hs, wc), outputStream);
						if(outputStream!=null){
							outputStream.close();
						}
			}
			//故障导出
			@RequestMapping("RbGzdoExportExcel")
			public void  RbGzdoExportExcel(HttpSession session,HttpServletResponse response,String gzxx) throws IOException{
				//告诉浏览器要弹出的文档类型
				response.setContentType("application/x-execl");
				//告诉浏览器这个文档作为附件给别人下载（放置浏览器不兼容，文件要编码）
				response.setHeader("Content-Disposition", "attachment;filename="+new String("用户信息列表.xls".getBytes(),"ISO-8859-1"));
				//获取输出流
						gzxx = new String(gzxx.getBytes("ISO-8859-1"), "utf-8") + "";
						ServletOutputStream outputStream=response.getOutputStream();
						rbService.exportExcel(rbService.findRbGzxx(gzxx), outputStream);
						if(outputStream!=null){
							outputStream.close();
						}
			}
			//搜索出现图
			@RequestMapping("/goHistoryLine")
			public String goHistoryChartPage(HttpServletRequest request,@Param("xqName")String xqName,@Param("buildNO")String buildNO,@Param("cellNO")String cellNO,@Param("houseNO") String houseNO) {
				try {
					xqName=	new String(xqName.getBytes("ISO-8859-1"), "UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				yhInfoList = villageService.findXQ();
//				map.addAttribute("yhInfoList", yhInfoList);
				List<Rb> info = rbService.SelRbAd(xqName, buildNO, cellNO, houseNO);
				for(int i=0;i<info.size();i++)
				{
					String RbAd = info.get(i).getRbAd();
					request.setAttribute("RbAd", RbAd);
				}
//				yhInfoList=rbService.findYhNameList();
				request.setAttribute("yhInfoList",yhInfoList );
				return "RbHChart";
			}
			
			
			
			@RequestMapping("/historyLine")
			@ResponseBody
			public Map<String,Object> listYhFmHistory(String RbAd) { 
				   SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String date = DateUtil.get2WeekAgoDateStr(DateUtil.YYYYMMDDHHMMSS);
//				String date="2018-01-10 16:02:16";
//				FmHistoryLog fmHistory = new FmHistoryLog();
//				fmHistory.setValAd(fmValAd);
//				fmHistory.setRecordTime(date);
				List<Rb> rbList = rbService.SelRb(RbAd,date);
				List<LineDataModel> lines = new ArrayList<LineDataModel>();
				int count = rbList.size();
				Object[] wd = new Object[count];
//				Object[] fm = new Object[count];
				Object[] kd = new Object[count];
//				Object[] tq = new Object[count];
				Object[] xy = new Object[count];
				for (int i = 0; i < count; i++) {
					rb = rbList.get(i);
					Double roomWD = rb.getEnergy();
					String power = rb.getPower();
//					BigDecimal fmWD=rb.getValTemp();
					Date recor = rb.getRecordTime();
					String	record=simple.format(recor);
//					String record=recor.toString();
					record = record.substring(2, 16);
//					int tqyb=history.getTqyb();
					wd[i] = roomWD;
					kd[i] = power;
//					tq[i] = tqyb;
					xy[i] = record;
//					fm[i]= fmWD;
					
//					FmHistoryLog history = fmHistories.get(i);
//					BigDecimal roomWD = history.getRoomTemp();
//					int fmkd = history.getFamKd();
//					BigDecimal fmWD=history.getValTemp();
//					String record = history.getRecordTime();
//					record = record.substring(2, 16);
//					int tqyb=history.getTqyb();
//					wd[i] = roomWD;
//					kd[i] = fmkd;
//					tq[i] = tqyb;
//					xy[i] = record;
//					fm[i]= fmWD;
				}
				LineDataModel model = new LineDataModel();
				model.setName("累计热量");
				model.setData(wd);
				lines.add(model);
//				LineDataModel model3 = new LineDataModel();
//				model3.setName("室外温度");
//				model3.setData(tq);
//				lines.add(model3);
				LineDataModel model2 = new LineDataModel();
				model2.setName("阀门开度");
				model2.setData(kd);
				lines.add(model2);
//				LineDataModel mode4 = new LineDataModel();
//				mode4.setName("管道温度");
//				mode4.setData(fm);
//				lines.add(mode4);
				Map<String, Object> json = new HashMap<String, Object>();
				json.put("xy", xy);
				json.put("data", lines);
				return json;
			}

	
	public List<Rb> getRbList()
	{
		return rbList;
	}
	public void setRbList(List<Rb> rbList)
	{
		this.rbList = rbList;
	}
	public List<Village> getYhInfoList()
	{
		return yhInfoList;
	}
	public void setYhInfoList(List<Village> yhInfoList)
	{
		this.yhInfoList = yhInfoList;
	}
	
}
