package com.hnzy.socket.server;


import java.math.BigDecimal;
import java.net.SocketAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.mina.core.future.CloseFuture;
import org.apache.mina.core.future.IoFuture;
import org.apache.mina.core.future.IoFutureListener;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.hnzy.rb.pojo.Qg;
import com.hnzy.rb.pojo.Rb;
import com.hnzy.rb.service.JzqService;
import com.hnzy.rb.service.QgService;
import com.hnzy.rb.service.RbService;
import com.hnzy.socket.RbidSDataUtil;
import com.hnzy.socket.util.CzUtil;
import com.hnzy.socket.util.DatabaseUtil;
import com.hnzy.socket.util.MapUtils;
import com.hnzy.socket.util.MapUtilsDf;
import com.hnzy.socket.util.MapUtilsSkq;
import com.hnzy.socket.util.Utils;

public class ServerHandler extends IoHandlerAdapter
{

	PreparedStatement ps;
	ResultSet rst;
	int rs = 0;
	@Autowired
    private RbService rbService;
	@Autowired
	private QgService qgService;
	@Autowired
	private JzqService jzqService;
	String rblb;
	String kfSt;
	String gfSt;
	String SJtring;
	String jaString;
	String dfStatus;
	boolean sessionmap;
	String param;
	ServerSessionMap sessionMap = ServerSessionMap.getInstance();
	// 日志文件
	private static Log logs = LogFactory.getLog(ServerHandler.class);

	/**
	 * 当一个新客户端连接后触发此方法
	 * 
	 */
	@Override
	public void sessionCreated(IoSession session)
	{
		logs.info("服务器创建链路成功!" + session.getRemoteAddress());
	}

	/**
	 * 当连接打开时调用
	 */
	@Override
	public void sessionOpened(IoSession session) throws Exception
	{
		logs.info("服务器打开了的连接，Session ID为" + session.getRemoteAddress() + session.getId());
		SocketAddress remoteAddress = (SocketAddress) session.getRemoteAddress();
		String clientIp = remoteAddress.toString();

		    sessionMap.add(clientIp, session);
			String mString = "F00A0100AAAAAAAAA3FF";
			// 解码
			byte[] b = CzUtil.jm(mString);
			String[] keys = new String[]{ clientIp };
			logs.info("集中器ID不存在发送数据" + mString);
			// 发送数据
			sessionMap.sendMessage(keys, b);
			try
			{
				Thread.sleep(2000);

			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			// 当动态IP和端口号连接是发送查找区管地址指令
			String SetQgID = "F00A0500AAAAAAAAB4FF";// 改为区管地址 F0 0A 05 00 AA AA
													// AA AA XX FF
			// 解码
			byte[] bQg = CzUtil.jm(SetQgID);
			// 给所有区管发送数据
			sessionMap.sendMessage(keys, bQg);

	}

	/**
	 * 当实现IOHandlerer的类抛出异常时调用
	 */
	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception
	{
		cause.printStackTrace();
		logs.info("{}出现异常{}" + session.getRemoteAddress() + cause);
		sessionMap.remove(session);
	}

	/**
	 * 当接受了一个消息时调用
	 */
	@Override
	public void messageReceived(IoSession session, Object message)
	{
	
		DatabaseUtil dbUtil = DatabaseUtil.getInstance();
		Connection connc = dbUtil.getConnection();
		byte[] base = (byte[]) message;
		String stringMR = Utils.bytesToHexString(base);
		String md = null;
		// 接收数据不能为空并且长度大于15
		if (stringMR != null && stringMR.length()>7 )
		{
				md = stringMR.substring(4, 6);
				
		    if (md.equals("01"))// 集中器查询状态
			{
		    	SocketAddress remoteAddress = (SocketAddress) session.getRemoteAddress();
				String clientIp = remoteAddress.toString();
				jzqCx(base, connc,clientIp);
			} else if (md.equals("05"))// 区管查询
			{
				SocketAddress remoteAddress = (SocketAddress) session.getRemoteAddress();
				String clientIp = remoteAddress.toString();
				qgCx(base, connc, clientIp);
			} else if (md.equals("02"))
			{
				CqRb(base, connc);	// 抄取热表
			} 
		    //抄表接收数据
			else if(md.equals("15")){
				
				rblb=stringMR.substring(16,18);
					if(rblb.equals("01")){
						//汇中表
						Crb(base, connc);
					}else if(rblb.equals("02")){
					 //长度
					 String cd=stringMR.substring(2,4);
					 
					if(cd.equals("b5")){
						HdCrb(base,connc);
					}else if(cd.equals("5d")){
						//联通家苑
						HdCrbS(base,connc);
					}
					
					}else if(rblb.equals("03")){
						 //长度
						String cd=stringMR.substring(2,4);
						if(cd.equals("d8")){
							//舒馨苑
							KmlpCrb(base,connc);
						}else if(cd.equals("2b")){
							//卡姆鲁普
							kmlp(base,connc);
						}
					}
				
//				Crb(base, connc);
			}else if(md.equals("29")){
				 //查询热表Id
				CxRbId(base, connc);
			}else if(md.equals("3a")){
				//更新区管Id
				UpQg(base, connc);
			}else if(md.equals("f4")){
				//自动抄表十分钟前数据
				XqCrb(base, connc);
			}else if(md.equals("1d")){
				//添加热表地址
				AddRbId(base, connc);
			}else if(md.equals("1f")){
				DeleteRbId(base, connc);
			}else if(md.equals("d2")){
				SocketAddress remoteAddress = (SocketAddress) session.getRemoteAddress();
				String clientIp = remoteAddress.toString();
				JzqXt(base, connc,clientIp);
			}
		}
		try
		{
			DatabaseUtil.close(ps, connc);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	Double wc;
	  //新抄热表解析
	  public void HdCrb(byte[] base, Connection connc){
		  logs.info("====荷德鲁美特热表接收数据：" + Utils.bytesToHexString(base));
		   // 接收数据
			String stringH = Utils.bytesToHexString(base);
			// 转换为大写
			String stringHandler = CzUtil.Uppercase(stringH).toString();
			if(stringHandler.length()>130){
			// 截取效验数据
			String jy = CzUtil.getJy(stringHandler);
			// 判断开始和结束
			String start = null;
			String end = null;
			String GsWd;
			start = stringHandler.charAt(0) + "" + stringHandler.charAt(1);
			end = stringHandler.charAt(stringHandler.length() - 2) + ""
					+ stringHandler.charAt(stringHandler.length() - 1);
			// 判断和校验
			String je = CzUtil.getJe(stringHandler);
			if (start.equals("F0") && end.equals("FF") && je.equals("" + jy + ""))
			{
				
				//热表地址
				String rbq=stringHandler.substring(32,34);
				String rbz=stringHandler.substring(34,36);
				String rbzs=stringHandler.substring(36,38);
				String rbh=stringHandler.substring(38,40);
				String RbID=rbh+rbzs+rbz+rbq;
				System.out.println("------热表地址-----"+RbID );
				System.out.println(stringHandler.substring(40,50));
				System.out.println(stringHandler.substring(48,50));
				String status=stringHandler.substring(50,52);
				System.out.println("status----"+status);
				if(status.equals("08")){
					status="Flash或者RAM基本参数被破坏";
				}else if(status.equals("50")){
					status="温度传感器故障";
				}else if(status.equals("B0")){
					status="进回水温度传感器装反";
				}else if(status.equals("70")){
					status="超声波发射器硬件错误";
				}else if(status.equals("F0")){
					status="读表频率过高";
				}else if(status.equals("D0")){
					status="流量传感器内流向错误";
				}else if(status.equals("90")){
					status="无有效超声波信息号";
				}else if(status.equals("30")){
					status="电池需要更换";
				}else if(status.equals("24")){
					status="主电源供电失效，应用备用电池";
				} else if(status.equals("00")){
					status="正常";
				}else{
					status="未知";
				}
				System.out.println("status----"+status);
				//累计热量
				String DqRlf=stringHandler.substring(60,61);
				String DqRlfs=stringHandler.substring(61,62);
				String DqRlfz=stringHandler.substring(62,64);
				String DqRlsz=stringHandler.substring(64,66);
				String DqRs=stringHandler.substring(66,68);
			    Double LdRl=Double.valueOf(DqRs+DqRlsz+DqRlfz+DqRlf+"."+DqRlfs);
			    System.out.println("-------当前累计热量--"+LdRl );
				//累计流量
				String Llf=stringHandler.substring(100,101);
				String Llfs=stringHandler.substring(101,102);
				String Llfz=stringHandler.substring(102,104);
				String Llsz=stringHandler.substring(104,106);
				String Lls=stringHandler.substring(106,108);
				//流量
				String LlS=Lls+Llsz+"."+Llfz+Llf+Llfs;
				System.out.println("-------累计流量----"+LlS );
				
				String LdLlf=stringHandler.substring(112,113);
				String LdLlfs=stringHandler.substring(113,114);
				String LdLlfz=stringHandler.substring(114,116);
				String LdLlsz=stringHandler.substring(116,118);
				String LdLls=stringHandler.substring(118,120);
				//累计流量
				String LjLl=LdLls+LdLlsz+"."+LdLlfz+LdLlf+LdLlfs;
				System.out.println("-----瞬时功率------"+LjLl);
				if(LjLl.equals("DDEB.BDDD")||LjLl.contains("F")){
					LjLl="999";	
				}
				String gswdf=stringHandler.substring(124,125);
				System.out.println("gswdf----------="+gswdf);
				String gswdfs=stringHandler.substring(125,126);
				System.out.println("gswdfs----------="+gswdfs);
				String gswdfz=stringHandler.substring(126,128);
				System.out.println("gswdfz----------="+gswdfz);
				System.out.println(stringHandler.substring(128,130));
			    String gs=stringHandler.substring(128,130);
			    if(gs.contains("F")||gswdf.contains("F")||gswdfs.contains("F")||gswdfz.contains("F")){
			    	 GsWd="999";
			    }else{
//			    	Integer gswds=Integer.valueOf(gs);
			    	//瞬时流量
					 GsWd=gs+gswdfz+gswdf+gswdfs;
					 System.out.println("瞬时流量--------"+GsWd);
					 if(GsWd.equals("EBBDDD")){
						 GsWd="999";
					 }else{
							//瞬时流量
//						String GsWd=gswds+"."+gswdfz+gswdf+gswdfs;
//						System.out.println("-----瞬时流量------"+GsWd );
						 Integer gswds=Integer.valueOf(gs);
						 GsWd=gswds+"."+gswdfz+gswdf+gswdfs;
					 }
			    }
			
				System.out.println("-----瞬时流量------"+GsWd );
				
				String js=stringHandler.substring(134,135);
				String jf=stringHandler.substring(135,136);
				Integer jfS=Integer.valueOf(stringHandler.substring(136,138));

				String Js=jfS+js+"."+jf;
				//回水温度
				System.out.println("------进水温度-----"+ Js);
				String hs=stringHandler.substring(142,143);
				String hf=stringHandler.substring(143,144);
				Integer hfS=Integer.valueOf(stringHandler.substring(144,146));
				String Hs=hfS+hs+"."+hf;
				System.out.println("------回水温度-----"+ Hs);
				String wcsz=stringHandler.substring(150,151);
				String wcf=stringHandler.substring(151,152);
				String wcfz=stringHandler.substring(152,153);
				if(wcfz.equals("F")){
					   wc=Double.valueOf("-"+wcsz+"."+wcf);
				}else{
					   wc=Double.valueOf(wcsz+"."+wcf);
				}
               
//                 System.out.println("------温差-----"+ wc);
				String timeF=stringHandler.substring(158,160);
				String timeSz=stringHandler.substring(160,162);
				String timeS=stringHandler.substring(162,164);
				Double time=Double.valueOf(timeS+timeSz+timeF);
				System.out.println("累计时间--------"+time);
//				String Retime=stringHandler.substring(168,176);
				Integer fTimes=Integer.parseInt(stringHandler.substring(168,170), 16);
//			    String yTimes=stringHandler.substring(170,172);
				Integer fY=Integer.parseInt("3F", 16);
				Integer fTime=fTimes&fY;
				System.out.println("分---"+fTime);
				Integer sTimes=Integer.parseInt(stringHandler.substring(170,172),16);
				Integer sY=Integer.parseInt("1F", 16);
				Integer sTime=sTimes&sY;
				System.out.println("时---"+sTime);
				Integer rTimes=Integer.parseInt(stringHandler.substring(172,174),16);
				Integer rY=Integer.parseInt("1F",16);
				Integer rTime=rTimes&rY;
				System.out.println("日---"+rTime);
				Integer yTimes=Integer.parseInt(stringHandler.substring(174,176),16);
				Integer yY=Integer.parseInt("0F",16);
				Integer yTime=yTimes&yY;
				System.out.println("月---"+yTime);
				Integer yInteger=Integer.parseInt("F0",16);
				Integer rInteger=Integer.parseInt("E0",16);
				Integer NTime=(yTimes&yInteger)/16*8+(rInteger&rTimes)/32;
				System.out.println("年---"+NTime);
				String Time="20"+NTime+"-"+yTime+"-"+rTime+" "+sTime+":"+""+fTime;
				System.out.println("日期---"+Time);
				Rb rb=new Rb();
				rb.setEnergy(Double.valueOf(LdRl));//累计热量
				rb.setEnergyLj(Double.valueOf(LlS));//累计流量
				rb.setPower(LjLl); //瞬时热量
				rb.setFlow(GsWd); //瞬时流量
				rb.setInTmp(Double.valueOf(Js)); //进水温度
				rb.setOperTime(time);
				rb.setOutTmp(Double.valueOf(Hs));//回水温度
				rb.setRecordTime(new Date()); //实时实时间
				rb.setReadMTime(Time);//热表时间
				rb.setStatus(status); //报警状态
				rb.setRbAd(RbID); //热表地址
//				double wc =sub(Double.valueOf(Js),Double.valueOf(Hs));
				System.out.println("温差=="+wc);
				rb.setDiffTmp(Double.valueOf(wc));
				rbService.updateRbById(rb);
				rbService.InsertRbHis(rb);	
				String qgid=stringHandler.substring(8,16);
				System.out.println("qgid----"+qgid);
				if (MapUtilsDf.getMapUtils().get("dRbParam") != null
						&& MapUtilsDf.getMapUtils().get("dRbParam").equals("" + RbID + ""))
				{
					MapUtils.getMapUtils().add("Crb",RbID);
					logs.info("读取热表成功");
					
				} else if (MapUtilsDf.getMapUtils().get("PlDRb") != null
						&& MapUtilsDf.getMapUtils().get("PlDRb").equals(""+qgid+""))
				{
					MapUtilsDf.getMapUtils().add("PldRb", "su");
					logs.info("区管实时热表成功");
				}
				logs.info("----荷德鲁美特读取热表成功");
		    
			}else if (stringHandler.length() - 1 > 362)
			{
				//消息长度
//				String Cd=stringHandler.substring(2,4);
				
				String[] str = stringHandler.split("F0B515");
				for (int i = 0; i < str.length; i++)
				{
					String iString = "F0B515" + str[i];
					System.out.println("istring---"+iString.length());
					if (iString.length()==362) //有问题
					{
						RbCzHd(iString,connc);
					}

				}
			}
			}
	  }
	  String LjLl;
	  String GsWd;
	  //舒馨苑新抄热表解析
	  public void kmlp(byte[] base, Connection connc){
		  logs.info("====舒馨苑卡姆鲁普热表接收数据：" + Utils.bytesToHexString(base));
		 
		   // 接收数据
			String stringH = Utils.bytesToHexString(base);
			 System.out.println(stringH.length());
			// 转换为大写
			String stringHandler = CzUtil.Uppercase(stringH).toString();
			if(stringHandler.length()>85){
			// 截取效验数据
			String jy = CzUtil.getJy(stringHandler);
			// 判断开始和结束
			String start = null;
			String end = null;
			start = stringHandler.charAt(0) + "" + stringHandler.charAt(1);
			end = stringHandler.charAt(stringHandler.length() - 2) + ""
					+ stringHandler.charAt(stringHandler.length() - 1);
			// 判断和校验
			String je = CzUtil.getJe(stringHandler);
			if (start.equals("F0") && end.equals("FF") && je.equals("" + jy + ""))
			{
				DecimalFormat df = new DecimalFormat("0.00");//格式化小数  
				DecimalFormat dfs = new DecimalFormat("0.000");//格式化小数  
				//热表地址
				String rbq=stringHandler.substring(20,22);
				String rbz=stringHandler.substring(22,24);
				String rbzs=stringHandler.substring(24,26);
				String rbh=stringHandler.substring(26,28);
				String RbID=rbh+rbzs+rbz+rbq;
				System.out.println("------热表地址-----"+RbID );
				String status=stringHandler.substring(28,30);
				System.out.println("status----"+status);
				if(status.equals("00")){
					status="正常";
				}
				System.out.println("status----"+status);
				//累计热量
				String DqRlf=stringHandler.substring(30,32);
				String DqRlfs=stringHandler.substring(32,34);
				String DqRlfz=stringHandler.substring(34,36);
				String DqRlsz=stringHandler.substring(36,38);
//				String DqRs=stringHandler.substring(66,68);
				// 把十六进制数，转换为十进制
				Integer LdRl=Integer.parseInt(DqRlsz+DqRlfz+DqRlfs+DqRlf, 16); 
			    System.out.println("-------当前累计热量--"+LdRl );
				//累计流量
				String Llf=stringHandler.substring(38,40);
				String Llfs=stringHandler.substring(40,42);
				String Llfz=stringHandler.substring(42,44);
				String Llsz=stringHandler.substring(44,46);
				//累计流量
				Double LlS=Double.valueOf(df.format((float)Integer.parseInt(Llsz+Llfz+Llfs+Llf, 16)/100));
				System.out.println("-------累计流量----"+LlS );
				String time4=stringHandler.substring(46,48);
				String time3=stringHandler.substring(48,50);
				String time2=stringHandler.substring(50,52);
				String time1=stringHandler.substring(52,54);
				Integer times=Integer.parseInt(time1+time2+time3+time4, 16);
				System.out.println("-------工作小时----"+times );
				
				String js2=stringHandler.substring(54,56);
				String js1=stringHandler.substring(56,58);
				Double js=Double.valueOf(df.format((float)Integer.parseInt(js1+js2, 16)/100));
				System.out.println("-------进水----"+js );
				
				String hs2=stringHandler.substring(58,60);
				String hs1=stringHandler.substring(60,62);
				Double hs=Double.valueOf(df.format((float)Integer.parseInt(hs1+hs2, 16)/100));
				System.out.println("-------回水----"+hs );
				
//				String wc2=stringHandler.substring(182,184);
//				String wc1=stringHandler.substring(184,186);
//				Double wc=Double.valueOf(df.format((float)Integer.parseInt(wc1+wc2, 16)/100));
//				System.out.println("-------温差----"+wc );
				
				
				String LdLlf=stringHandler.substring(66,68);
				String LdLlfs=stringHandler.substring(68,70);
				String LdLlfz=stringHandler.substring(70,72);
				String LdLlfzS=stringHandler.substring(72,74);
				String ld=LdLlfzS+LdLlfz+LdLlfs+LdLlf;
				long dec_num = Long.parseLong(ld, 16);  
				
//				System.out.println(Integer.parseInt(ld,16));
//				Boolean result = ld.matches("[0-9]+");
//				if(result==true){
					//累计功率
					 LjLl=String.valueOf(df.format((float)dec_num/10));
//				}else{
//					 LjLl="999";
//				}
				
				System.out.println("-----瞬时功率------"+LjLl);
				String gswdf=stringHandler.substring(74,76);
				String gswdfs=stringHandler.substring(76,78);
				String gswdfz=stringHandler.substring(78,80);
				String gswdfzs=stringHandler.substring(80,82);
				
//				String Gs=gswdfzs+gswdfz+gswdfs+gswdf;
//				System.out.println(Gs);
//				Boolean resultGs = Gs.matches("[0-9]+");
//				if(resultGs==true){
					//累计功率
					 GsWd=String.valueOf(dfs.format((float)Integer.valueOf(gswdfzs+gswdfz+gswdfs+gswdf,16)/1000));
//				}else{
//					 GsWd="999";
//				}
				
//				String GsWd=String.valueOf(dfs.format((float)Integer.valueOf(gswdfzs+gswdfz+gswdfs+gswdf,16)/1000));
				System.out.println("-----瞬时流量------"+GsWd );	
				Rb rb=new Rb();
				rb.setEnergy(Double.valueOf(LdRl));//累计热量
				rb.setEnergyLj(LlS);//累计流量
				rb.setPower(LjLl); //瞬时热量
				rb.setFlow(GsWd); //瞬时流量
				rb.setInTmp(js); //进水温度
				rb.setOperTime(Double.valueOf(times));//工作时间
				rb.setOutTmp(hs);//回水温度
				rb.setRecordTime(new Date()); //实时实时间
				rb.setReadMTime("");//热表时间
				rb.setStatus(status); //报警状态
				rb.setRbAd(RbID); //热表地址
				double wc =sub(js,hs);
//				rb.setDiffTmp(Double.valueOf(wc));
				rb.setDiffTmp(wc);
				rbService.updateRbById(rb);
				rbService.InsertRbHis(rb);	
				String qgid=stringHandler.substring(8,16);
				System.out.println("qgid----"+qgid);
				if (MapUtilsDf.getMapUtils().get("dRbParam") != null
						&& MapUtilsDf.getMapUtils().get("dRbParam").equals("" + RbID + ""))
				{
					MapUtils.getMapUtils().add("Crb",RbID);
					logs.info("读取热表成功");
					
				} else if (MapUtilsDf.getMapUtils().get("PlDRb") != null
						&& MapUtilsDf.getMapUtils().get("PlDRb").equals(""+qgid+""))
				{
					MapUtilsDf.getMapUtils().add("PldRb", "su");
					logs.info("区管实时热表成功");
				}
				logs.info("----舒馨苑卡姆鲁普读取热表成功");
		    
			}else if (stringHandler.length() - 1 >170)
			{
				System.out.println(stringHandler);
				String[] str = stringHandler.split("F02B15");
				for (int i = 0; i < str.length; i++)
				{
					String iString = "F02B15" + str[i];
					System.out.println(iString.length());
					if (iString.length()==86) //有问题
					{
						KmlpS(iString,connc);
					}

				}
			}
			}
	  }  
	  
	  //舒馨苑新抄热表解析
	  public void KmlpCrb(byte[] base, Connection connc){
		  logs.info("====舒馨苑卡姆鲁普热表接收数据：" + Utils.bytesToHexString(base));
		 
		   // 接收数据
			String stringH = Utils.bytesToHexString(base);
			 System.out.println(stringH.length());
			// 转换为大写
			String stringHandler = CzUtil.Uppercase(stringH).toString();
			if(stringHandler.length()>430){
			// 截取效验数据
			String jy = CzUtil.getJy(stringHandler);
			// 判断开始和结束
			String start = null;
			String end = null;
			start = stringHandler.charAt(0) + "" + stringHandler.charAt(1);
			end = stringHandler.charAt(stringHandler.length() - 2) + ""
					+ stringHandler.charAt(stringHandler.length() - 1);
			// 判断和校验
			String je = CzUtil.getJe(stringHandler);
			if (start.equals("F0") && end.equals("FF") && je.equals("" + jy + ""))
			{
				DecimalFormat df = new DecimalFormat("0.00");//格式化小数  
				DecimalFormat dfs = new DecimalFormat("0.000");//格式化小数  
				//热表地址
				String rbq=stringHandler.substring(32,34);
				String rbz=stringHandler.substring(34,36);
				String rbzs=stringHandler.substring(36,38);
				String rbh=stringHandler.substring(38,40);
				String RbID=rbh+rbzs+rbz+rbq;
				System.out.println("------热表地址-----"+RbID );
				String status=stringHandler.substring(50,52);
				System.out.println("status----"+status);
				if(status.equals("00")){
					status="正常";
				}
				System.out.println("status----"+status);
				//累计热量
				String DqRlf=stringHandler.substring(60,62);
				String DqRlfs=stringHandler.substring(62,64);
				String DqRlfz=stringHandler.substring(64,66);
				String DqRlsz=stringHandler.substring(66,68);
//				String DqRs=stringHandler.substring(66,68);
				// 把十六进制数，转换为十进制
				Integer LdRl=Integer.parseInt(DqRlsz+DqRlfz+DqRlfs+DqRlf, 16); 
			    System.out.println("-------当前累计热量--"+LdRl );
				//累计流量
				String Llf=stringHandler.substring(100,102);
				String Llfs=stringHandler.substring(102,104);
				String Llfz=stringHandler.substring(104,106);
				String Llsz=stringHandler.substring(106,108);
				//累计流量
				Double LlS=Double.valueOf(df.format((float)Integer.parseInt(Llsz+Llfz+Llfs+Llf, 16)/100));
				System.out.println("-------累计流量----"+LlS );
				String time4=stringHandler.substring(142,144);
				String time3=stringHandler.substring(144,146);
				String time2=stringHandler.substring(146,148);
				String time1=stringHandler.substring(148,150);
				Integer times=Integer.parseInt(time1+time2+time3+time4, 16);
				System.out.println("-------工作小时----"+times );
				
				String js2=stringHandler.substring(166,168);
				String js1=stringHandler.substring(168,170);
				Double js=Double.valueOf(df.format((float)Integer.parseInt(js1+js2, 16)/100));
				System.out.println("-------进水----"+js );
				
				String hs2=stringHandler.substring(174,176);
				String hs1=stringHandler.substring(176,178);
				Double hs=Double.valueOf(df.format((float)Integer.parseInt(hs1+hs2, 16)/100));
				System.out.println("-------回水----"+hs );
				
//				String wc2=stringHandler.substring(182,184);
//				String wc1=stringHandler.substring(184,186);
//				Double wc=Double.valueOf(df.format((float)Integer.parseInt(wc1+wc2, 16)/100));
//				System.out.println("-------温差----"+wc );
				
				
				String LdLlf=stringHandler.substring(190,192);
				String LdLlfs=stringHandler.substring(192,194);
				String LdLlfz=stringHandler.substring(194,196);
				String LdLlfzS=stringHandler.substring(196,198);
				System.out.println();
				//累计功率
				String LjLl=String.valueOf(df.format((float)Integer.parseInt(LdLlfzS+LdLlfz+LdLlfs+LdLlf,16)/10));
				System.out.println("-----瞬时功率------"+LjLl);
				String gswdf=stringHandler.substring(214,216);
				String gswdfs=stringHandler.substring(216,218);
				String gswdfz=stringHandler.substring(218,220);
				String gswdfzs=stringHandler.substring(220,222);
				String GsWd=String.valueOf(dfs.format((float)Integer.valueOf(gswdfzs+gswdfz+gswdfs+gswdf,16)/1000));
				System.out.println("-----瞬时流量------"+GsWd );	
				Rb rb=new Rb();
				rb.setEnergy(Double.valueOf(LdRl));//累计热量
				rb.setEnergyLj(LlS);//累计流量
				rb.setPower(LjLl); //瞬时热量
				rb.setFlow(GsWd); //瞬时流量
				rb.setInTmp(js); //进水温度
				rb.setOperTime(Double.valueOf(times));//工作时间
				rb.setOutTmp(hs);//回水温度
				rb.setRecordTime(new Date()); //实时实时间
				rb.setReadMTime("");//热表时间
				rb.setStatus(status); //报警状态
				rb.setRbAd(RbID); //热表地址
				double wc =sub(js,hs);
//				rb.setDiffTmp(Double.valueOf(wc));
				rb.setDiffTmp(wc);
				rbService.updateRbById(rb);
				rbService.InsertRbHis(rb);	
				String qgid=stringHandler.substring(8,16);
				System.out.println("qgid----"+qgid);
				if (MapUtilsDf.getMapUtils().get("dRbParam") != null
						&& MapUtilsDf.getMapUtils().get("dRbParam").equals("" + RbID + ""))
				{
					MapUtils.getMapUtils().add("Crb",RbID);
					logs.info("读取热表成功");
					
				} else if (MapUtilsDf.getMapUtils().get("PlDRb") != null
						&& MapUtilsDf.getMapUtils().get("PlDRb").equals(""+qgid+""))
				{
					MapUtilsDf.getMapUtils().add("PldRb", "su");
					logs.info("区管实时热表成功");
				}
				logs.info("----舒馨苑卡姆鲁普读取热表成功");
		    
			}else if (stringHandler.length() - 1 >860)
			{
				System.out.println(stringHandler);
				String[] str = stringHandler.split("F0D815");
				for (int i = 0; i < str.length; i++)
				{
					String iString = "F0D815" + str[i];
					if (iString.length()==432) //有问题
					{
						KmlpCrbS(iString,connc);
					}

				}
			}
			}
	  }  
	  
	  
	  //新抄热表解析
	  public void KmlpS(String stringHandler, Connection connc){
		  logs.info("========舒馨苑卡姆鲁普热表接收数据：" +stringHandler);
//		   // 接收数据
//			String stringH = Utils.bytesToHexString(base);
//			// 转换为大写
//			String stringHandler = CzUtil.Uppercase(stringH).toString();
		  if(stringHandler.length()>85){
				// 截取效验数据
				String jy = CzUtil.getJy(stringHandler);
				// 判断开始和结束
				String start = null;
				String end = null;
				start = stringHandler.charAt(0) + "" + stringHandler.charAt(1);
				end = stringHandler.charAt(stringHandler.length() - 2) + ""
						+ stringHandler.charAt(stringHandler.length() - 1);
				// 判断和校验
				String je = CzUtil.getJe(stringHandler);
				if (start.equals("F0") && end.equals("FF") && je.equals("" + jy + ""))
				{
					DecimalFormat df = new DecimalFormat("0.00");//格式化小数  
					DecimalFormat dfs = new DecimalFormat("0.000");//格式化小数  
					//热表地址
					String rbq=stringHandler.substring(20,22);
					String rbz=stringHandler.substring(22,24);
					String rbzs=stringHandler.substring(24,26);
					String rbh=stringHandler.substring(26,28);
					String RbID=rbh+rbzs+rbz+rbq;
					System.out.println("------热表地址-----"+RbID );
					String status=stringHandler.substring(28,30);
					System.out.println("status----"+status);
					if(status.equals("00")){
						status="正常";
					}
					System.out.println("status----"+status);
					//累计热量
					String DqRlf=stringHandler.substring(30,32);
					String DqRlfs=stringHandler.substring(32,34);
					String DqRlfz=stringHandler.substring(34,36);
					String DqRlsz=stringHandler.substring(36,38);
//					String DqRs=stringHandler.substring(66,68);
					// 把十六进制数，转换为十进制
					Integer LdRl=Integer.parseInt(DqRlsz+DqRlfz+DqRlfs+DqRlf, 16); 
				    System.out.println("-------当前累计热量--"+LdRl );
					//累计流量
					String Llf=stringHandler.substring(38,40);
					String Llfs=stringHandler.substring(40,42);
					String Llfz=stringHandler.substring(42,44);
					String Llsz=stringHandler.substring(44,46);
					//累计流量
					Double LlS=Double.valueOf(df.format((float)Integer.parseInt(Llsz+Llfz+Llfs+Llf, 16)/100));
					System.out.println("-------累计流量----"+LlS );
					String time4=stringHandler.substring(46,48);
					String time3=stringHandler.substring(48,50);
					String time2=stringHandler.substring(50,52);
					String time1=stringHandler.substring(52,54);
					Integer times=Integer.parseInt(time1+time2+time3+time4, 16);
					System.out.println("-------工作小时----"+times );
					
					String js2=stringHandler.substring(54,56);
					String js1=stringHandler.substring(56,58);
					Double js=Double.valueOf(df.format((float)Integer.parseInt(js1+js2, 16)/100));
					System.out.println("-------进水----"+js );
					
					String hs2=stringHandler.substring(58,60);
					String hs1=stringHandler.substring(60,62);
					Double hs=Double.valueOf(df.format((float)Integer.parseInt(hs1+hs2, 16)/100));
					System.out.println("-------回水----"+hs );
					
//					String wc2=stringHandler.substring(182,184);
//					String wc1=stringHandler.substring(184,186);
//					Double wc=Double.valueOf(df.format((float)Integer.parseInt(wc1+wc2, 16)/100));
//					System.out.println("-------温差----"+wc );
					
					
					String LdLlf=stringHandler.substring(66,68);
					String LdLlfs=stringHandler.substring(68,70);
					String LdLlfz=stringHandler.substring(70,72);
					String LdLlfzS=stringHandler.substring(72,74);
					String ld=LdLlfzS+LdLlfz+LdLlfs+LdLlf;
					long dec_num = Long.parseLong(ld, 16);  
//					System.out.println(Integer.parseInt(ld,16));
//					Boolean result = ld.matches("[0-9]+");
//					if(result==true){
						//累计功率
						 LjLl=String.valueOf(df.format((float)dec_num/10));
//					}else{
//						 LjLl="999";
//					}
					
					System.out.println("-----瞬时功率------"+LjLl);
					String gswdf=stringHandler.substring(74,76);
					String gswdfs=stringHandler.substring(76,78);
					String gswdfz=stringHandler.substring(78,80);
					String gswdfzs=stringHandler.substring(80,82);
					
					String Gs=gswdfzs+gswdfz+gswdfs+gswdf;
//					Boolean resultGs = Gs.matches("[0-9]+");
//					if(resultGs==true){
						//累计功率
						 GsWd=String.valueOf(dfs.format((float)Integer.valueOf(Gs,16)/1000));
//					}else{
//						 GsWd="999";
//					}
					
//					String GsWd=String.valueOf(dfs.format((float)Integer.valueOf(gswdfzs+gswdfz+gswdfs+gswdf,16)/1000));
					System.out.println("-----瞬时流量------"+GsWd );	
					Rb rb=new Rb();
					rb.setEnergy(Double.valueOf(LdRl));//累计热量
					rb.setEnergyLj(LlS);//累计流量
					rb.setPower(LjLl); //瞬时热量
					rb.setFlow(GsWd); //瞬时流量
					rb.setInTmp(js); //进水温度
					rb.setOperTime(Double.valueOf(times));//工作时间
					rb.setOutTmp(hs);//回水温度
					rb.setRecordTime(new Date()); //实时实时间
					rb.setReadMTime("");//热表时间
					rb.setStatus(status); //报警状态
					rb.setRbAd(RbID); //热表地址
					double wc =sub(js,hs);
//					rb.setDiffTmp(Double.valueOf(wc));
					rb.setDiffTmp(wc);
					rbService.updateRbById(rb);
					rbService.InsertRbHis(rb);	
					String qgid=stringHandler.substring(8,16);
					System.out.println("qgid----"+qgid);
					if (MapUtilsDf.getMapUtils().get("dRbParam") != null
							&& MapUtilsDf.getMapUtils().get("dRbParam").equals("" + RbID + ""))
					{
						MapUtils.getMapUtils().add("Crb",RbID);
						logs.info("读取热表成功");
						
					} else if (MapUtilsDf.getMapUtils().get("PlDRb") != null
							&& MapUtilsDf.getMapUtils().get("PlDRb").equals(""+qgid+""))
					{
						MapUtilsDf.getMapUtils().add("PldRb", "su");
						logs.info("区管实时热表成功");
					}
					logs.info("----舒馨苑卡姆鲁普读取热表成功");
				}
			}
	  }
	  
	  
	  //新抄热表解析
	  public void KmlpCrbS(String stringHandler, Connection connc){
		  logs.info("========舒馨苑卡姆鲁普热表接收数据：" +stringHandler);
//		   // 接收数据
//			String stringH = Utils.bytesToHexString(base);
//			// 转换为大写
//			String stringHandler = CzUtil.Uppercase(stringH).toString();
			if(stringHandler.length()>200){
				// 截取效验数据
				String jy = CzUtil.getJy(stringHandler);
				// 判断开始和结束
				String start = null;
				String end = null;
				String GsWd;
				start = stringHandler.charAt(0) + "" + stringHandler.charAt(1);
				end = stringHandler.charAt(stringHandler.length() - 2) + ""
						+ stringHandler.charAt(stringHandler.length() - 1);
				// 判断和校验
				String je = CzUtil.getJe(stringHandler);
				if (start.equals("F0") && end.equals("FF") && je.equals("" + jy + ""))
				{
					
					DecimalFormat df = new DecimalFormat("0.00");//格式化小数  
					DecimalFormat dfs = new DecimalFormat("0.000");//格式化小数  
					//热表地址
					String rbq=stringHandler.substring(32,34);
					String rbz=stringHandler.substring(34,36);
					String rbzs=stringHandler.substring(36,38);
					String rbh=stringHandler.substring(38,40);
					String RbID=rbh+rbzs+rbz+rbq;
					System.out.println("------热表地址-----"+RbID );
					String status=stringHandler.substring(50,52);
					System.out.println("status----"+status);
					if(status.equals("00")){
						status="正常";
					}
					System.out.println("status----"+status);
					//累计热量
					String DqRlf=stringHandler.substring(60,62);
					String DqRlfs=stringHandler.substring(62,64);
					String DqRlfz=stringHandler.substring(64,66);
					String DqRlsz=stringHandler.substring(66,68);
//					String DqRs=stringHandler.substring(66,68);
					// 把十六进制数，转换为十进制
					Integer LdRl=Integer.parseInt(DqRlsz+DqRlfz+DqRlfs+DqRlf, 16); 
				    System.out.println("-------当前累计热量--"+LdRl );
					//累计流量
					String Llf=stringHandler.substring(100,102);
					String Llfs=stringHandler.substring(102,104);
					String Llfz=stringHandler.substring(104,106);
					String Llsz=stringHandler.substring(106,108);
					//累计流量
					Double LlS=Double.valueOf(df.format((float)Integer.parseInt(Llsz+Llfz+Llfs+Llf, 16)/100));
					System.out.println("-------累计流量----"+LlS );
					String time4=stringHandler.substring(142,144);
					String time3=stringHandler.substring(144,146);
					String time2=stringHandler.substring(146,148);
					String time1=stringHandler.substring(148,150);
					Integer times=Integer.parseInt(time1+time2+time3+time4, 16);
					System.out.println("-------工作小时----"+times );
					
					String js2=stringHandler.substring(166,168);
					String js1=stringHandler.substring(168,170);
					Double js=Double.valueOf(df.format((float)Integer.parseInt(js1+js2, 16)/100));
					System.out.println("-------进水----"+js );
					
					String hs2=stringHandler.substring(174,176);
					String hs1=stringHandler.substring(176,178);
					Double hs=Double.valueOf(df.format((float)Integer.parseInt(hs1+hs2, 16)/100));
					System.out.println("-------回水----"+hs );
					
//					String wc2=stringHandler.substring(182,184);
//					String wc1=stringHandler.substring(184,186);
//					Double wc=Double.valueOf(df.format((float)Integer.parseInt(wc1+wc2, 16)/100));
//					System.out.println("-------温差----"+wc );
					
					
					String LdLlf=stringHandler.substring(190,192);
					String LdLlfs=stringHandler.substring(192,194);
					String LdLlfz=stringHandler.substring(194,196);
					String LdLlfzS=stringHandler.substring(196,198);
					System.out.println();
					//累计功率
					String LjLl=String.valueOf(df.format((float)Integer.parseInt(LdLlfzS+LdLlfz+LdLlfs+LdLlf,16)/10));
					System.out.println("-----瞬时功率------"+LjLl);
					String gswdf=stringHandler.substring(214,216);
					String gswdfs=stringHandler.substring(216,218);
					String gswdfz=stringHandler.substring(218,220);
					String gswdfzs=stringHandler.substring(220,222);
					 GsWd=String.valueOf(dfs.format((float)Integer.valueOf(gswdfzs+gswdfz+gswdfs+gswdf,16)/1000));
					System.out.println("-----瞬时流量------"+GsWd );
				
					Rb rb=new Rb();
					rb.setEnergy(Double.valueOf(LdRl));//累计热量
					rb.setEnergyLj(LlS);//累计流量
					rb.setPower(LjLl); //瞬时热量
					rb.setFlow(GsWd); //瞬时流量
					rb.setInTmp(js); //进水温度
					rb.setOperTime(Double.valueOf(times));//工作时间
					rb.setOutTmp(hs);//回水温度
					rb.setRecordTime(new Date()); //实时实时间
					rb.setReadMTime("");//热表时间
					rb.setStatus(status); //报警状态
					rb.setRbAd(RbID); //热表地址
					double wc =sub(js,hs);
					rb.setDiffTmp(wc);
//					rb.setDiffTmp(Double.valueOf(wc));
					rbService.updateRbById(rb);
					rbService.InsertRbHis(rb);	
					String qgid=stringHandler.substring(8,16);
					System.out.println("qgid----"+qgid);
					if (MapUtilsDf.getMapUtils().get("dRbParam") != null
							&& MapUtilsDf.getMapUtils().get("dRbParam").equals("" + RbID + ""))
					{
						MapUtils.getMapUtils().add("Crb",RbID);
						logs.info("读取热表成功");
						
					} else if (MapUtilsDf.getMapUtils().get("PlDRb") != null
							&& MapUtilsDf.getMapUtils().get("PlDRb").equals(""+qgid+""))
					{
						MapUtilsDf.getMapUtils().add("PldRb", "su");
						logs.info("区管实时热表成功");
					}
					logs.info("----舒馨苑卡姆鲁普读取热表成功");
				}
			}
	  }
	  
	  //新抄热表解析
	  public void HdCrbS(byte[] base, Connection connc){
		  logs.info("====联通家苑荷德鲁美特热表接收数据：" + Utils.bytesToHexString(base));
		   // 接收数据
			String stringH = Utils.bytesToHexString(base);
			// 转换为大写
			String stringHandler = CzUtil.Uppercase(stringH).toString();
			if(stringHandler.length()>180){
			// 截取效验数据
			String jy = CzUtil.getJy(stringHandler);
			// 判断开始和结束
			String start = null;
			String end = null;
			String GsWd;
			start = stringHandler.charAt(0) + "" + stringHandler.charAt(1);
			end = stringHandler.charAt(stringHandler.length() - 2) + ""
					+ stringHandler.charAt(stringHandler.length() - 1);
			// 判断和校验
			String je = CzUtil.getJe(stringHandler);
			if (start.equals("F0") && end.equals("FF") && je.equals("" + jy + ""))
			{
				
				//热表地址
				String rbq=stringHandler.substring(32,34);
				String rbz=stringHandler.substring(34,36);
				String rbzs=stringHandler.substring(36,38);
				String rbh=stringHandler.substring(38,40);
				String RbID=rbh+rbzs+rbz+rbq;
				System.out.println("------热表地址-----"+RbID );
				
				String status=stringHandler.substring(50,52);
				System.out.println("status----"+status);
				if(status.equals("08")){
					status="Flash或者RAM基本参数被破坏";
				}else if(status.equals("50")){
					status="温度传感器故障";
				}else if(status.equals("B0")){
					status="进回水温度传感器装反";
				}else if(status.equals("28")){
					status="超声波发射器硬件错误";
				}else if(status.equals("10")){
					status="读表频率过高";
				}else if(status.equals("D0")){
					status="流量传感器内流向错误";
				}else if(status.equals("70")){
					status="无有效超声波信息号";
				}
				else if(status.equals("84")){
					status="电池需要更换";
				}
				else if(status.equals("00")){
					status="正常";
				}else{
					status="未知";
				}
				System.out.println("status----"+status);
				//累计热量
				String DqRlf=stringHandler.substring(60,62);
				String DqRlfs=stringHandler.substring(62,64);
				String DqRlfz=stringHandler.substring(64,66);
				String DqRlsz=stringHandler.substring(66,68);
//				String DqRs=stringHandler.substring(66,68);
			    Double LdRl=Double.valueOf(DqRlsz+DqRlfz+DqRlfs+DqRlf);
			    System.out.println("-------当前累计热量--"+LdRl );
				//累计流量
				String Llf=stringHandler.substring(72,74);
				String Llfs=stringHandler.substring(74,76);
				String Llfz=stringHandler.substring(76,78);
				String Llsz=stringHandler.substring(78,80);
				//累计流量
				String LlS=Integer.valueOf(Llsz+Llfz+Llfs)+"."+Llf;
				System.out.println("-------累计流量----"+LlS );
				
				String LdLlf=stringHandler.substring(84,85);
				String LdLlfs=stringHandler.substring(85,86);
				String LdLlfz=stringHandler.substring(86,87);
				String LdLlfzS=stringHandler.substring(87,88);
				String LdLlsz=stringHandler.substring(88,90);
				String LdLls=stringHandler.substring(90,92);
		
				//累计功率
				String LjLl=LdLls+LdLlsz+LdLlfz+"."+LdLlfzS+LdLlf+LdLlfs;
				System.out.println("-----------LjLl-"+LjLl);
				if(LjLl.equals("DDDDE.BBD")||LjLl.contains("F")){
					LjLl="999";	
				}else{
					LjLl=Integer.valueOf(LdLls+LdLlsz+LdLlfz)+"."+LdLlfzS+LdLlf+LdLlfs;
				}
				System.out.println("-----瞬时功率------"+LjLl);
				String gswdf=stringHandler.substring(96,97);
				String gswdfs=stringHandler.substring(97,98);
				String gswdfz=stringHandler.substring(98,99);
				String gswdfzs=stringHandler.substring(99,100);
			    String gs=stringHandler.substring(100,102);
			    if(gs.contains("F")||gswdf.contains("F")||gswdfs.contains("F")||gswdfz.contains("F")){
			    	 GsWd="999";
			    }else{
//			    	Integer gswds=Integer.valueOf(gs);
			    	//瞬时流量
					 GsWd=gs+gswdfz+gswdfzs+gswdf+gswdfs;
					 System.out.println(GsWd);
					 if(GsWd.equals("DDEBBD")){
						 GsWd="999";
					 }else{
							//瞬时流量
//						String GsWd=gswds+"."+gswdfz+gswdf+gswdfs;
//						System.out.println("-----瞬时流量------"+GsWd );
						 Integer gswds=Integer.valueOf(gs);
						 GsWd=Integer.valueOf(gswds+gswdfz)+"."+gswdfzs+gswdf+gswdfs;
					 }
			    }
			
				System.out.println("-----瞬时流量------"+GsWd );
				
				String js=stringHandler.substring(106,107);
				String jf=stringHandler.substring(107,108);
				Integer jfS=Integer.valueOf(stringHandler.substring(108,110));

				String Js=jfS+js+"."+jf;
				//回水温度
				System.out.println("------进水温度-----"+ Js);
				String hs=stringHandler.substring(114,115);
				String hf=stringHandler.substring(115,116);
				Integer hfS=Integer.valueOf(stringHandler.substring(116,118));
				String Hs=hfS+hs+"."+hf;
				System.out.println("------回水温度-----"+ Hs);
				String wcsz=stringHandler.substring(122,123);
				String wcf=stringHandler.substring(123,124);
				String wcfz=stringHandler.substring(124,125);
				if(wcfz.equals("F")){
					   wc=Double.valueOf("-"+wcsz+"."+wcf);
				}else{
					   wc=Double.valueOf(wcsz+"."+wcf);
				}
               
                 System.out.println("------温差-----"+ wc);
//                 String timeF=stringHandler.substring(158,160);
// 				String timeSz=stringHandler.substring(160,162);
// 				String timeS=stringHandler.substring(162,164);
 				 String timeF=stringHandler.substring(130,132);
  				String timeSz=stringHandler.substring(132,134);
 				Double time=Double.valueOf(timeSz+timeF);
 				System.out.println("累计时间/天数--------"+time);
//				String Retime=stringHandler.substring(168,176);
				Integer fTimes=Integer.parseInt(stringHandler.substring(138,140), 16);
//			    String yTimes=stringHandler.substring(170,172);
				Integer fY=Integer.parseInt("3F", 16);
				Integer fTime=fTimes&fY;
				Integer sTimes=Integer.parseInt(stringHandler.substring(140,142),16);
				Integer sY=Integer.parseInt("1F", 16);
				Integer sTime=sTimes&sY;
				Integer rTimes=Integer.parseInt(stringHandler.substring(142,144),16);
				Integer rY=Integer.parseInt("1F",16);
				Integer rTime=rTimes&rY;
				Integer yTimes=Integer.parseInt(stringHandler.substring(144,146),16);
				Integer yY=Integer.parseInt("0F",16);
				Integer yTime=yTimes&yY;
				Integer yInteger=Integer.parseInt("F0",16);
				Integer rInteger=Integer.parseInt("E0",16);
				Integer NTime=(yTimes&yInteger)/16*8+(rInteger&rTimes)/32;
				String Time="20"+NTime+"-"+yTime+"-"+rTime+" "+sTime+":"+""+fTime;
				System.out.println("日期---"+Time);
				Rb rb=new Rb();
				rb.setEnergy(Double.valueOf(LdRl));//累计热量
				rb.setEnergyLj(Double.valueOf(LlS));//累计流量
				rb.setPower(LjLl); //瞬时热量
				rb.setFlow(GsWd); //瞬时流量
				rb.setInTmp(Double.valueOf(Js)); //进水温度
				rb.setOperTime(time);
				rb.setOutTmp(Double.valueOf(Hs));//回水温度
				rb.setRecordTime(new Date()); //实时实时间
				rb.setReadMTime(Time);//热表时间
				rb.setStatus(status); //报警状态
				rb.setRbAd(RbID); //热表地址
//				double wc =sub(Double.valueOf(Js),Double.valueOf(Hs));
				System.out.println("温差=="+wc);
				rb.setDiffTmp(Double.valueOf(wc));
				rbService.updateRbById(rb);
				rbService.InsertRbHis(rb);	
				String qgid=stringHandler.substring(8,16);
				System.out.println("qgid----"+qgid);
				if (MapUtilsDf.getMapUtils().get("dRbParam") != null
						&& MapUtilsDf.getMapUtils().get("dRbParam").equals("" + RbID + ""))
				{
					MapUtils.getMapUtils().add("Crb",RbID);
					logs.info("读取热表成功");
					
				} else if (MapUtilsDf.getMapUtils().get("PlDRb") != null
						&& MapUtilsDf.getMapUtils().get("PlDRb").equals(""+qgid+""))
				{
					MapUtilsDf.getMapUtils().add("PldRb", "su");
					logs.info("区管实时热表成功");
				}
				logs.info("----联通家苑荷德鲁美特读取热表成功");
		    
			}else if (stringHandler.length() - 1 > 370)
			{
				
				String[] str = stringHandler.split("F05D15");
				for (int i = 0; i < str.length; i++)
				{
					String iString = "F05d15" + str[i];
					System.out.println(iString);
					System.out.println("istring---"+iString.length());
					if (iString.length()==186) //有问题
					{
						RbCzHdS(iString,connc);
					}

				}
			}
			}
	  }
	  public void RbCzHdS(String stringHandler, Connection connc)
		{
			
		  logs.info("====联通家苑荷德鲁美特热表接收数据：" +stringHandler);
//		   // 接收数据
//			String stringH = Utils.bytesToHexString(base);
//			System.out.println("长度----"+stringH.length());
//			// 转换为大写
//			String stringHandler = CzUtil.Uppercase(stringH).toString();
			if(stringHandler.length()>180){
			// 截取效验数据
			String jy = CzUtil.getJy(stringHandler);
			// 判断开始和结束
			String start = null;
			String end = null;
			String GsWd;
			start = stringHandler.charAt(0) + "" + stringHandler.charAt(1);
			end = stringHandler.charAt(stringHandler.length() - 2) + ""
					+ stringHandler.charAt(stringHandler.length() - 1);
			// 判断和校验
			String je = CzUtil.getJe(stringHandler);
			if (start.equals("F0") && end.equals("FF") && je.equals("" + jy + ""))
			{
				
				//热表地址
				String rbq=stringHandler.substring(32,34);
				String rbz=stringHandler.substring(34,36);
				String rbzs=stringHandler.substring(36,38);
				String rbh=stringHandler.substring(38,40);
				String RbID=rbh+rbzs+rbz+rbq;
				System.out.println("------热表地址-----"+RbID );
				
				String status=stringHandler.substring(50,52);
				System.out.println("status----"+status);
				if(status.equals("08")){
					status="Flash或者RAM基本参数被破坏";
				}else if(status.equals("50")){
					status="温度传感器故障";
				}else if(status.equals("B0")){
					status="进回水温度传感器装反";
				}else if(status.equals("28")){
					status="超声波发射器硬件错误";
				}else if(status.equals("10")){
					status="读表频率过高";
				}else if(status.equals("D0")){
					status="流量传感器内流向错误";
				}else if(status.equals("70")){
					status="无有效超声波信息号";
				}
				else if(status.equals("84")){
					status="电池需要更换";
				}
				else if(status.equals("00")){
					status="正常";
				}else{
					status="未知";
				}
				System.out.println("status----"+status);
				//累计热量
				String DqRlf=stringHandler.substring(60,62);
				String DqRlfs=stringHandler.substring(62,64);
				String DqRlfz=stringHandler.substring(64,66);
				String DqRlsz=stringHandler.substring(66,68);
//				String DqRs=stringHandler.substring(66,68);
			    Double LdRl=Double.valueOf(DqRlsz+DqRlfz+DqRlfs+DqRlf);
			    System.out.println("-------当前累计热量--"+LdRl );
				//累计流量
				String Llf=stringHandler.substring(72,74);
				String Llfs=stringHandler.substring(74,76);
				String Llfz=stringHandler.substring(76,78);
				String Llsz=stringHandler.substring(78,80);
				//累计流量
				String LlS=Integer.valueOf(Llsz+Llfz+Llfs)+"."+Llf;
				System.out.println("-------累计流量----"+LlS );
				
				String LdLlf=stringHandler.substring(84,85);
				String LdLlfs=stringHandler.substring(85,86);
				String LdLlfz=stringHandler.substring(86,87);
				String LdLlfzS=stringHandler.substring(87,88);
				String LdLlsz=stringHandler.substring(88,90);
				String LdLls=stringHandler.substring(90,92);
		
				//累计功率
				String LjLl=LdLls+LdLlsz+LdLlfz+"."+LdLlfzS+LdLlf+LdLlfs;
				System.out.println("-----------LjLl-"+LjLl);
				if(LjLl.equals("DDDDE.BBD")||LjLl.contains("F")){
					LjLl="999";	
				}else{
					LjLl=Integer.valueOf(LdLls+LdLlsz+LdLlfz)+"."+LdLlfzS+LdLlf+LdLlfs;
				}
				System.out.println("-----瞬时功率------"+LjLl);
				String gswdf=stringHandler.substring(96,97);
				String gswdfs=stringHandler.substring(97,98);
				String gswdfz=stringHandler.substring(98,99);
				String gswdfzs=stringHandler.substring(99,100);
			    String gs=stringHandler.substring(100,102);
			    if(gs.contains("F")||gswdf.contains("F")||gswdfs.contains("F")||gswdfz.contains("F")){
			    	 GsWd="999";
			    }else{
//			    	Integer gswds=Integer.valueOf(gs);
			    	//瞬时流量
					 GsWd=gs+gswdfz+gswdfzs+gswdf+gswdfs;
					 System.out.println(GsWd);
					 if(GsWd.equals("DDEBBD")){
						 GsWd="999";
					 }else{
							//瞬时流量
//						String GsWd=gswds+"."+gswdfz+gswdf+gswdfs;
//						System.out.println("-----瞬时流量------"+GsWd );
						 Integer gswds=Integer.valueOf(gs);
						 GsWd=Integer.valueOf(gswds+gswdfz)+"."+gswdfzs+gswdf+gswdfs;
					 }
			    }
			
				System.out.println("-----瞬时流量------"+GsWd );
				
				String js=stringHandler.substring(106,107);
				String jf=stringHandler.substring(107,108);
				Integer jfS=Integer.valueOf(stringHandler.substring(108,110));

				String Js=jfS+js+"."+jf;
				//回水温度
				System.out.println("------进水温度-----"+ Js);
				String hs=stringHandler.substring(114,115);
				String hf=stringHandler.substring(115,116);
				Integer hfS=Integer.valueOf(stringHandler.substring(116,118));
				String Hs=hfS+hs+"."+hf;
				System.out.println("------回水温度-----"+ Hs);
				String wcsz=stringHandler.substring(122,123);
				String wcf=stringHandler.substring(123,124);
				String wcfz=stringHandler.substring(124,125);
				if(wcfz.equals("F")){
					   wc=Double.valueOf("-"+wcsz+"."+wcf);
				}else{
					   wc=Double.valueOf(wcsz+"."+wcf);
				}
               
                 System.out.println("------温差-----"+ wc);
//                 String timeF=stringHandler.substring(158,160);
// 				String timeSz=stringHandler.substring(160,162);
// 				String timeS=stringHandler.substring(162,164);
 				 String timeF=stringHandler.substring(130,132);
  				String timeSz=stringHandler.substring(132,134);
 				Double time=Double.valueOf(timeSz+timeF);
 				System.out.println("累计时间/天数--------"+time);
//				String Retime=stringHandler.substring(168,176);
				Integer fTimes=Integer.parseInt(stringHandler.substring(138,140), 16);
//			    String yTimes=stringHandler.substring(170,172);
				Integer fY=Integer.parseInt("3F", 16);
				Integer fTime=fTimes&fY;
				Integer sTimes=Integer.parseInt(stringHandler.substring(140,142),16);
				Integer sY=Integer.parseInt("1F", 16);
				Integer sTime=sTimes&sY;
				Integer rTimes=Integer.parseInt(stringHandler.substring(142,144),16);
				Integer rY=Integer.parseInt("1F",16);
				Integer rTime=rTimes&rY;
				Integer yTimes=Integer.parseInt(stringHandler.substring(144,146),16);
				Integer yY=Integer.parseInt("0F",16);
				Integer yTime=yTimes&yY;
				Integer yInteger=Integer.parseInt("F0",16);
				Integer rInteger=Integer.parseInt("E0",16);
				Integer NTime=(yTimes&yInteger)/16*8+(rInteger&rTimes)/32;
				String Time="20"+NTime+"-"+yTime+"-"+rTime+" "+sTime+":"+""+fTime;
				System.out.println("日期---"+Time);
				Rb rb=new Rb();
				rb.setEnergy(Double.valueOf(LdRl));//累计热量
				rb.setEnergyLj(Double.valueOf(LlS));//累计流量
				rb.setPower(LjLl); //瞬时热量
				rb.setFlow(GsWd); //瞬时流量
				rb.setInTmp(Double.valueOf(Js)); //进水温度
				rb.setOperTime(time);
				rb.setOutTmp(Double.valueOf(Hs));//回水温度
				rb.setRecordTime(new Date()); //实时实时间
				rb.setReadMTime(Time);//热表时间
				rb.setStatus(status); //报警状态
				rb.setRbAd(RbID); //热表地址
//				double wc =sub(Double.valueOf(Js),Double.valueOf(Hs));
				System.out.println("温差=="+wc);
				rb.setDiffTmp(Double.valueOf(wc));
				rbService.updateRbById(rb);
				rbService.InsertRbHis(rb);	
				String qgid=stringHandler.substring(8,16);
				System.out.println("qgid----"+qgid);
				if (MapUtilsDf.getMapUtils().get("dRbParam") != null
						&& MapUtilsDf.getMapUtils().get("dRbParam").equals("" + RbID + ""))
				{
					MapUtils.getMapUtils().add("Crb",RbID);
					logs.info("读取热表成功");
					
				} else if (MapUtilsDf.getMapUtils().get("PlDRb") != null
						&& MapUtilsDf.getMapUtils().get("PlDRb").equals(""+qgid+""))
				{
					MapUtilsDf.getMapUtils().add("PldRb", "su");
					logs.info("区管实时热表成功");
				}
				logs.info("----联通家苑荷德鲁美特读取热表成功");
			}
			}
			}
	  
	  public void RbCzHd(String stringHandler, Connection connc)
		{
			
		  logs.info("====荷德鲁美特热表接收数据：" + stringHandler);
//		   // 接收数据
//			String stringH = Utils.bytesToHexString(base);
			// 转换为大写
//			String stringHandler = CzUtil.Uppercase(stringH).toString();
			if(stringHandler.length()>130){
			// 截取效验数据
			String jy = CzUtil.getJy(stringHandler);
			// 判断开始和结束
			String start = null;
			String end = null;
			String GsWd;
			start = stringHandler.charAt(0) + "" + stringHandler.charAt(1);
			end = stringHandler.charAt(stringHandler.length() - 2) + ""
					+ stringHandler.charAt(stringHandler.length() - 1);
			// 判断和校验
			String je = CzUtil.getJe(stringHandler);
			if (start.equals("F0") && end.equals("FF") && je.equals("" + jy + ""))
			{
				
				//热表地址
				String rbq=stringHandler.substring(32,34);
				String rbz=stringHandler.substring(34,36);
				String rbzs=stringHandler.substring(36,38);
				String rbh=stringHandler.substring(38,40);
				String RbID=rbh+rbzs+rbz+rbq;
				System.out.println("------热表地址-----"+RbID );
				System.out.println(stringHandler.substring(40,50));
				System.out.println(stringHandler.substring(48,50));
				String status=stringHandler.substring(50,52);
				System.out.println("status----"+status);
				if(status.equals("08")){
					status="Flash或者RAM基本参数被破坏";
				}else if(status.equals("50")){
					status="温度传感器故障";
				}else if(status.equals("B0")){
					status="进回水温度传感器装反";
				}else if(status.equals("70")){
					status="超声波发射器硬件错误";
				}else if(status.equals("F0")){
					status="读表频率过高";
				}else if(status.equals("D0")){
					status="流量传感器内流向错误";
				}else if(status.equals("90")){
					status="无有效超声波信息号";
				}else if(status.equals("30")){
					status="电池需要更换";
				}else if(status.equals("24")){
					status="主电源供电失效，应用备用电池";
				} else if(status.equals("00")){
					status="正常";
				}else{
					status="未知";
				}
				System.out.println("status----"+status);
				//累计热量
				String DqRlf=stringHandler.substring(60,61);
				String DqRlfs=stringHandler.substring(61,62);
				String DqRlfz=stringHandler.substring(62,64);
				String DqRlsz=stringHandler.substring(64,66);
				String DqRs=stringHandler.substring(66,68);
			    Double LdRl=Double.valueOf(DqRs+DqRlsz+DqRlfz+DqRlf+"."+DqRlfs);
			    System.out.println("-------当前累计热量--"+LdRl );
				//累计流量
				String Llf=stringHandler.substring(100,101);
				String Llfs=stringHandler.substring(101,102);
				String Llfz=stringHandler.substring(102,104);
				String Llsz=stringHandler.substring(104,106);
				String Lls=stringHandler.substring(106,108);
				//流量
				String LlS=Lls+Llsz+"."+Llfz+Llf+Llfs;
				System.out.println("-------累计流量----"+LlS );
				
				String LdLlf=stringHandler.substring(112,113);
				String LdLlfs=stringHandler.substring(113,114);
				String LdLlfz=stringHandler.substring(114,116);
				String LdLlsz=stringHandler.substring(116,118);
				String LdLls=stringHandler.substring(118,120);
				//累计流量
				String LjLl=LdLls+LdLlsz+"."+LdLlfz+LdLlf+LdLlfs;
				System.out.println("-----瞬时功率------"+LjLl);
				if(LjLl.equals("DDEB.BDDD")||LjLl.contains("F")){
					LjLl="999";	
				}
				String gswdf=stringHandler.substring(124,125);
				System.out.println("gswdf----------="+gswdf);
				String gswdfs=stringHandler.substring(125,126);
				System.out.println("gswdfs----------="+gswdfs);
				String gswdfz=stringHandler.substring(126,128);
				System.out.println("gswdfz----------="+gswdfz);
				System.out.println(stringHandler.substring(128,130));
			    String gs=stringHandler.substring(128,130);
			    if(gs.contains("F")||gswdf.contains("F")||gswdfs.contains("F")||gswdfz.contains("F")){
			    	 GsWd="999";
			    }else{
//			    	Integer gswds=Integer.valueOf(gs);
			    	//瞬时流量
					 GsWd=gs+gswdfz+gswdf+gswdfs;
					 if(GsWd.equals("EBBDDD")){
						 GsWd="999";
					 }else{
							//瞬时流量
//						String GsWd=gswds+"."+gswdfz+gswdf+gswdfs;
//						System.out.println("-----瞬时流量------"+GsWd );
						 Integer gswds=Integer.valueOf(gs);
						 GsWd=gswds+"."+gswdfz+gswdf+gswdfs;
					 }
			    }
			
				System.out.println("-----瞬时流量------"+GsWd );
				
				String js=stringHandler.substring(134,135);
				String jf=stringHandler.substring(135,136);
				Integer jfS=Integer.valueOf(stringHandler.substring(136,138));

				String Js=jfS+js+"."+jf;
				//回水温度
				System.out.println("------进水温度-----"+ Js);
				String hs=stringHandler.substring(142,143);
				String hf=stringHandler.substring(143,144);
				Integer hfS=Integer.valueOf(stringHandler.substring(144,146));
				String Hs=hfS+hs+"."+hf;
				System.out.println("------回水温度-----"+ Hs);
				String wcsz=stringHandler.substring(150,151);
				String wcf=stringHandler.substring(151,152);
				String wcfz=stringHandler.substring(152,153);
				if(wcfz.equals("F")){
					   wc=Double.valueOf("-"+wcsz+"."+wcf);
				}else{
					   wc=Double.valueOf(wcsz+"."+wcf);
				}
               
//                 System.out.println("------温差-----"+ wc);
				String timeF=stringHandler.substring(158,160);
				String timeSz=stringHandler.substring(160,162);
				String timeS=stringHandler.substring(162,164);
				Double time=Double.valueOf(timeS+timeSz+timeF);
				System.out.println("累计时间--------"+time);
//				String Retime=stringHandler.substring(168,176);
				Integer fTimes=Integer.parseInt(stringHandler.substring(168,170), 16);
//			    String yTimes=stringHandler.substring(170,172);
				Integer fY=Integer.parseInt("3F", 16);
				Integer fTime=fTimes&fY;
				Integer sTimes=Integer.parseInt(stringHandler.substring(170,172),16);
				Integer sY=Integer.parseInt("1F", 16);
				Integer sTime=sTimes&sY;
				Integer rTimes=Integer.parseInt(stringHandler.substring(172,174),16);
				Integer rY=Integer.parseInt("1F",16);
				Integer rTime=rTimes&rY;
				Integer yTimes=Integer.parseInt(stringHandler.substring(174,176),16);
				Integer yY=Integer.parseInt("0F",16);
				Integer yTime=yTimes&yY;
				Integer yInteger=Integer.parseInt("F0",16);
				Integer rInteger=Integer.parseInt("E0",16);
				Integer NTime=(yTimes&yInteger)/16*8+(rInteger&rTimes)/32;
				String Time="20"+NTime+"-"+yTime+"-"+rTime+" "+sTime+":"+""+fTime;
				System.out.println("日期---"+Time);
				Rb rb=new Rb();
				rb.setEnergy(Double.valueOf(LdRl));//累计热量
				rb.setEnergyLj(Double.valueOf(LlS));//累计流量
				rb.setPower(LjLl); //瞬时热量
				rb.setFlow(GsWd); //瞬时流量
				rb.setInTmp(Double.valueOf(Js)); //进水温度
				rb.setOperTime(time);
				rb.setOutTmp(Double.valueOf(Hs));//回水温度
				rb.setRecordTime(new Date()); //实时实时间
				rb.setReadMTime(Time);//热表时间
				rb.setStatus(status); //报警状态
				rb.setRbAd(RbID); //热表地址
//				double wc =sub(Double.valueOf(Js),Double.valueOf(Hs));
				System.out.println("温差=="+wc);
				rb.setDiffTmp(Double.valueOf(wc));
				rbService.updateRbById(rb);
				rbService.InsertRbHis(rb);	
				String qgid=stringHandler.substring(8,16);
				System.out.println("qgid----"+qgid);
				if (MapUtilsDf.getMapUtils().get("dRbParam") != null
						&& MapUtilsDf.getMapUtils().get("dRbParam").equals("" + RbID + ""))
				{
					MapUtils.getMapUtils().add("Crb",RbID);
					logs.info("读取热表成功");
					
				} else if (MapUtilsDf.getMapUtils().get("PlDRb") != null
						&& MapUtilsDf.getMapUtils().get("PlDRb").equals(""+qgid+""))
				{
					MapUtilsDf.getMapUtils().add("PldRb", "su");
					logs.info("区管实时热表成功");
				}
				logs.info("------荷德鲁美特读取热表成功"); 
			}
			}
			}
	public void JzqXt(byte[] base, Connection connc,String clientIp)
	{
		 // 接收数据
		String stringH = Utils.bytesToHexString(base);
		String[] ipPortString = clientIp.split(":");
		String IP = ipPortString[0];

		String[] ip = IP.split("/");
		Integer port = Integer.valueOf(ipPortString[1]);
		String Ip = ip[1];
		SimpleDateFormat Sdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 获取发送的时间
		String time = Sdate.format(new Date());
		// 转换为大写
//		String stringHandler = CzUtil.Uppercase(stringH).toString();
		//根据心跳更新集中器ip和端口号
		jzqService.updateIpPortByXt(Ip, port, time, stringH);
		
	}
	// 抽取相同部分
	public boolean cz(String ja, String pt)
	{

		// 把十六进制数，转换为十进制相加
		int jia = CzUtil.FsZh(ja);
		// 十进制转换为十六进制
		String hex = Integer.toHexString(jia);
		// 截取相加结果后两位
		String je = null;
		for (int j = 0; j < hex.length() - 1; j++)
		{
			je = hex.charAt(hex.length() - 2) + "" + hex.charAt(hex.length() - 1);
		}
		String[] keys = new String[]{ pt };
		String mString = ja + je + "FF";
		// 转换为大写
		String stringsj = CzUtil.Uppercase(mString).toString();
		// 解码
		byte[] b = CzUtil.jm(stringsj);
		ServerSessionMap sessionMap = ServerSessionMap.getInstance();
		boolean sessionmap = sessionMap.sendMessage(keys, b);
		return sessionmap;
	}

	public String CzUtils(String jaString)
	{
		// 把十六进制数，转换为十进制相加
		int jia = CzUtil.FsZh(jaString);
		// 十进制转换为十六进制
		String hex = Integer.toHexString(jia);
		// 截取相加结果后两位
		String jeq = null;
		for (int j = 0; j < hex.length() - 1; j++)
		{
			jeq = hex.charAt(hex.length() - 2) + "" + hex.charAt(hex.length() - 1);
		}

		String stringSJ = jaString + jeq + "FF";
		// 转换为大写
		String stringsj = CzUtil.Uppercase(stringSJ).toString();
		return stringsj;
	}

	int jzqPort;
	String qgID;
	String JzqIP;

	Integer hTemSet;
	Integer mTemSet;
	Integer lTemSet;
	public void CxRbId(byte[] base, Connection connc)
	{
		       logs.info("查询热表ID--接收------：" + Utils.bytesToHexString(base));
		       // 接收数据
				String stringH = Utils.bytesToHexString(base);
				// 转换为大写
				String stringHandler = CzUtil.Uppercase(stringH).toString();
				// 截取效验数据
				String jy = CzUtil.getJy(stringHandler);
//				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// 获取当前
//				String jTime = df.format(new Date());
				// 判断开始和结束
				String start = null;
				String end = null;
				start = stringHandler.charAt(0) + "" + stringHandler.charAt(1);
				end = stringHandler.charAt(stringHandler.length() - 2) + ""
						+ stringHandler.charAt(stringHandler.length() - 1);
				// 判断和校验
				String je = CzUtil.getJe(stringHandler);
				System.out.println(je);
				System.out.println(jy);
//				if (start.equals("f0") && end.equals("ff") && je.equals("" + jy + ""))
//				{
//					//区管地址
					String qgid=stringHandler.substring(8,16);
					
					logs.info("查询区管地址成功"+qgid);
					//热表地址
//					String RbIds=stringHandler.substring(16, stringHandler.length()-4);
					//热表类别
//					Integer rbfl =null;
					//查询到的热表地址更新存入数据库
//					cxRbService.update(RbIds, rbfl,qgid);
//					List<String> list =RbidSDataUtil.getStrList(RbIds,14);
					
					//每七个字节为一个热表id 存入数据库
//					for(int i=0;i<list.size();i++){
////						String rbAd=list.get(i);
//						String rbAd=list.get(i);
//						rbAd=rbAd.replace("F", "");
//						rbService.InsertRbId(rbAd, jTime);
//					}
					MapUtils.getMapUtils().add("CxRbId",qgid);
//				}	
	}
//	public void KfWx(byte[] base, Connection connc)
//	{
//		// 接收数据
//		String stringH = Utils.bytesToHexString(base);
//		String varAd = stringH.substring(6, 14);
//		// 转换十进制
//		int Fms = Integer.parseInt("" + varAd + "", 16);
//		// 根据阀门地址查找区管地址,IP地址端口号
//		String fmId=String.valueOf(Fms);
//		//根据阀门Id更新信息
//		rb=rbService.findWxxByFmId(fmId);
//		jzqPort=rb.getYh().getFm().getQg().getJzq().getJzqPort();
//		qgID=rb.getYh().getFm().getQgID();
//		JzqIP=rb.getYh().getFm().getQg().getJzq().getJzqIp();
//		hTemSet=rb.getYh().getFm().gethTemSet();
//		mTemSet=rb.getYh().getFm().getmTemSet();
//		lTemSet=rb.getYh().getFm().getlTemSet();
//		// 参数十进制转换为十六进制
//		int WDsd = Integer.valueOf(hTemSet);
//		int TJzq = Integer.valueOf(mTemSet);
//		int TJcs = Integer.valueOf(lTemSet);
//		String Wdsd = "00" + Integer.toHexString(WDsd);
//		String subwdsd = Wdsd.substring(Wdsd.length() - 2);
//		String Tjzq = "00" + Integer.toHexString(TJzq);
//		String subtjzq = Tjzq.substring(Tjzq.length() - 2);
//		String Tjcs = "00" + Integer.toHexString(TJcs);
//		String subtjcs = Tjcs.substring(Tjcs.length() - 2);
//		String UppWdsd = CzUtil.Uppercase(subwdsd).toString();
//		String UppTjzq = CzUtil.Uppercase(subtjzq).toString();
//		String UppTjcs = CzUtil.Uppercase(subtjcs).toString();
//		String ja = "F0160900" + qgID + "04" + varAd + "01FFFF01" + UppWdsd + "" + UppTjzq + "" + UppTjcs + "";
//		// 微信开阀门
//		// String ja = "F0160900" + qgID + "04" + varAd + "01FFFF01FFFFFF";
//		// IP地址和端口号
//		String pt = "/" + JzqIP + ":" + jzqPort;
//		log.info("微信开阀门发送数据：" + ja);
//		boolean sessionmap = cz(ja, pt);
//		try
//		{
//			Thread.sleep(8000);
//		} catch (InterruptedException e)
//		{
//			e.printStackTrace();
//		}
//		// fmId十进制
//		String jas = "F00F0400" + qgID + "04" + varAd;
//		log.info("微信读阀发送数据：" + jas);
//		boolean sessionmap1 = cz(jas, pt);
//	}
//
//	public void GfWx(byte[] base, Connection connc)
//	{
//		// 接收数据
//		String stringH = Utils.bytesToHexString(base);
//		String varAd = stringH.substring(6, 14);
//		// 转换十进制
//		int Fms = Integer.parseInt("" + varAd + "", 16);
//		String fmId=String.valueOf(Fms);
//		//根据阀门Id更新信息
//		rb=rbService.findWxxByFmId(fmId);
//		jzqPort=rb.getYh().getFm().getQg().getJzq().getJzqPort();
//		qgID=rb.getYh().getFm().getQgID();
//		JzqIP=rb.getYh().getFm().getQg().getJzq().getJzqIp();
//		hTemSet=rb.getYh().getFm().gethTemSet();
//		mTemSet=rb.getYh().getFm().getmTemSet();
//		lTemSet=rb.getYh().getFm().getlTemSet();
//		//根据阀门Id更新信息
//		// 参数十进制转换为十六进制
//		int WDsd = Integer.valueOf(hTemSet);
//		int TJzq = Integer.valueOf(mTemSet);
//		int TJcs = Integer.valueOf(lTemSet);
//		String Wdsd = "00" + Integer.toHexString(WDsd);
//		String subwdsd = Wdsd.substring(Wdsd.length() - 2);
//		String Tjzq = "00" + Integer.toHexString(TJzq);
//		String subtjzq = Tjzq.substring(Tjzq.length() - 2);
//		String Tjcs = "00" + Integer.toHexString(TJcs);
//		String subtjcs = Tjcs.substring(Tjcs.length() - 2);
//		String UppWdsd = CzUtil.Uppercase(subwdsd).toString();
//		String UppTjzq = CzUtil.Uppercase(subtjzq).toString();
//		String UppTjcs = CzUtil.Uppercase(subtjcs).toString();
//		// fmId十进制
//		String ja = "F0160900" + qgID + "04" + varAd + "00FFFF00" + UppWdsd + "" + UppTjzq + "" + UppTjcs + "";
//		// 微信关阀门
//		// String ja = "F0160900" + qgID + "04" + varAd + "00FFFF00FFFFFF";
//		// IP地址和端口号
//		String pt = "/" + JzqIP + ":" + jzqPort;
//		log.info("微信关阀门发送数据：" + ja);
//		boolean sessionmap = cz(ja, pt);
//		try
//		{
//			Thread.sleep(8000);
//		} catch (InterruptedException e)
//		{
//			e.printStackTrace();
//		}
//		// fmId十进制
//		String jas = "F00F0400" + qgID + "04" + varAd;
//		log.info("微信读阀发送数据：" + jas);
//		boolean sessionmap1 = cz(jas, pt);
//	}
	
	
	  public void rbjx(byte[] base, Connection connc){
		logs.info("热表接收数据====：" + Utils.bytesToHexString(base));
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 获取发送的时间
		String fTime = MapUtils.getMapUtils().get("time");
		String jTime = df.format(new Date());
		int ms = 0;
		String sumTime = CzUtil.getSubtract(fTime, jTime);
		if (sumTime == null)
		{
			sumTime = "00:00:01";
		}
		if (sumTime != null)
		{
			ms = CzUtil.transform(sumTime);
			// 判断时间是否超时
				// 接收数据
				String stringH = Utils.bytesToHexString(base);
				// 转换为大写
				String stringHandler = CzUtil.Uppercase(stringH).toString();
				// 截取效验数据
				String jy = CzUtil.getJy(stringHandler);
				// 判断开始和结束
				String start = null;
				String end = null;
				start = stringHandler.charAt(0) + "" + stringHandler.charAt(1);
				end = stringHandler.charAt(stringHandler.length() - 2) + ""
						+ stringHandler.charAt(stringHandler.length() - 1);
				// 判断和校验
				String je = CzUtil.getJe(stringHandler);
				if (start.equals("F0") && end.equals("FF") && je.equals("" + jy + ""))
				{
					
					// 区管ID
					String qgID = stringHandler.substring(8, 16);
					//热表类型 01汇中02荷德鲁美特03泰语
					String RbType=stringHandler.substring(16,18);
					
					
			}
		}
	}
	 public String   status ;
	  //新抄热表解析
	  public void Crb(byte[] base, Connection connc){
		  logs.info("====汇中热表接收数据：" + Utils.bytesToHexString(base));
		  String Ldrb;
		  String LjLl;
		  // 接收数据
			String stringH = Utils.bytesToHexString(base);
			// 转换为大写
			String stringHandler = CzUtil.Uppercase(stringH).toString();
			if(stringHandler.length()>130){
			// 截取效验数据
			String jy = CzUtil.getJy(stringHandler);
			// 判断开始和结束
			String start = null;
			String end = null;
			start = stringHandler.charAt(0) + "" + stringHandler.charAt(1);
			end = stringHandler.charAt(stringHandler.length() - 2) + ""
					+ stringHandler.charAt(stringHandler.length() - 1);
			// 判断和校验
			String je = CzUtil.getJe(stringHandler);
			if (start.equals("F0") && end.equals("FF") && je.equals("" + jy + ""))
			{
				
				//热表地址
				String rbid=stringHandler.substring(22,36);
				String RbId=rbid.replace("F","");
				
				System.out.println("------热表地址-----"+RbId );
				//报警状态
				Integer sus=Integer.valueOf(stringHandler.substring(130,132));
				//状态与
				int stst=sus&0x0f;
				// FmID十进制转换为十六进制
    			String statu = Integer.toHexString(stst);
    			//ox10
    			String st= Integer.toHexString(sus&0x10);
    			//0x40
    			String sts=Integer.toHexString(sus&0x40);
				if(statu.equals("1")){
					status="需要更换电池";
				}else if(statu.equals("2")){
					status="空管或者换能器故障";
				}else if(statu.equals("4")){
					status="必须更换电池";
				}else if(statu.equals("5")){
					status="传感器和换能器之间通讯故障";
				}else if(statu.equals("6")){
					status="E2PROM损坏";
				}else if(st.equals("10")){
					status="供水温度故障";
				}else if(sts.equals("40")){
					status="回水温度传感器故障";
				}else if(sus==00) {
					status="正常";
				} else {
					status="未知";
				}	   		
				String ldrl=stringHandler.substring(56,62);
				if(ldrl.contains("F")){
					status="未知";
					 Ldrb="999";
				}else{
					 Integer ldrb=Integer.valueOf(ldrl);
					String ldrbs=stringHandler.substring(62,64); //两位小数
					System.out.println("-----ldrb-----"+ldrb);
					System.out.println("-----ldrbs-----"+ldrbs);
					 Ldrb=ldrb+"."+ldrbs;
					System.out.println("----累计热量-------"+Ldrb );	
				}
				System.out.println("----累计热量-------"+Ldrb );
				

//			    Integer ldrb=Integer.valueOf(stringHandler.substring(56,62));
//				Integer ldrb=Integer.valueOf(ldrl);
//				String ldrbs=stringHandler.substring(62,64); //两位小数
//				System.out.println("-----ldrb-----"+ldrb);
//				System.out.println("-----ldrbs-----"+ldrbs);
//				String Ldrb=ldrb+"."+ldrbs;
//				 System.out.println("----累计热量-------"+Ldrb );
				    Integer ldgl=Integer.valueOf(stringHandler.substring(66,72));
					String ldgls=stringHandler.substring(72,74);//两位小数
					//热功率 
					String rgl=ldgl+"."+ldgls;
					System.out.println("------热功率-----"+rgl );
					Integer Ll=Integer.valueOf(stringHandler.substring(76,80));
					String Lls=stringHandler.substring(80,84);//四位小数
					//流量
					String LlS=Ll+"."+Lls;
					System.out.println("-------瞬时流量----"+LlS );
					String ldLls=stringHandler.substring(86,92);
					if(ldLls.contains("F")){
						status="未知";
						LjLl="999";
					}else{
						Integer LdLl=Integer.valueOf(stringHandler.substring(86,92));
						String LdLls=stringHandler.substring(92,94);//两位小数
						//累计流量
						 LjLl=LdLl+"."+LdLls;
						System.out.println("-----累计流量------"+LjLl);
//						LdLl=Integer.valueOf(ldLls);
					}
					System.out.println("-----累计流量------"+LjLl);
//				Integer LdLl=Integer.valueOf(stringHandler.substring(86,92));
//				String LdLls=stringHandler.substring(92,94);//两位小数
//				//累计流量
//				String LjLl=LdLl+"."+LdLls;
//				System.out.println("-----累计流量------"+LjLl);
				
				Integer gswd=Integer.valueOf(stringHandler.substring(96,100));
				String gswds=stringHandler.substring(100,102);//两位小数
				//供水温度
				Double GsWd=Double.valueOf(gswd+"."+gswds);
				System.out.println("-----进水温度------"+GsWd );
				
				Integer hswd=Integer.valueOf(stringHandler.substring(102,106));
				String hswds=stringHandler.substring(106,108);
				//回水温度
				Double HsWd=Double.valueOf(hswd+"."+hswds);
				System.out.println("------回水温度-----"+ HsWd);
				
				Integer ldgzTime=Integer.valueOf(stringHandler.substring(108,114));
				//累计时间
				System.out.println("-----累计工作时间------"+ldgzTime );
				
				String ssTimeN=stringHandler.substring(114,118);
				String ssTimeY=stringHandler.substring(118,120);
				String sstimeR=stringHandler.substring(120,122);
				String sstimeS=stringHandler.substring(122,124);
				String sstimeF=stringHandler.substring(124,126);
				String sstimeM=stringHandler.substring(126,128);
			   //实时时间
				String ssTime=ssTimeN+"-"+ssTimeY+"-"+sstimeR+" "+sstimeS+":"+sstimeF+":"+sstimeM;
				System.out.println("-----实时时间------"+ssTime );
//				//报警状态
//				Integer sus=Integer.valueOf(stringHandler.substring(130,132));
//				//状态与
//				int stst=sus&0x0f;
//				// FmID十进制转换为十六进制
//    			String statu = Integer.toHexString(stst);
//    			//ox10
//    			String st= Integer.toHexString(sus&0x10);
//    			//0x40
//    			String sts=Integer.toHexString(sus&0x40);
//				if(statu.equals("1")){
//					status="需要更换电池";
//				}else if(statu.equals("2")){
//					status="空管或者换能器故障";
//				}else if(statu.equals("4")){
//					status="必须更换电池";
//				}else if(statu.equals("5")){
//					status="传感器和换能器之间通讯故障";
//				}else if(statu.equals("6")){
//					status="E2PROM损坏";
//				}else if(st.equals("10")){
//					status="供水温度故障";
//				}else if(sts.equals("40")){
//					status="回水温度传感器故障";
//				}else if(sus==00) {
//					status="正常";
//				} else {
//					status="未知";
//				}	   			
////				String status=stringHandler.substring(128,132);
//				System.out.println("-------报警状态----"+status );
				System.out.println("----status-------"+status );
				Rb rb=new Rb();
				rb.setEnergy(Double.valueOf(Ldrb));//累计热量
				rb.setEnergyLj(Double.valueOf(LjLl));//累计流量
				rb.setPower(rgl); //瞬时热量
				rb.setFlow(LlS); //瞬时流量
				rb.setInTmp(GsWd); //进水温度
				rb.setOperTime(Double.valueOf(ldgzTime));
				rb.setOutTmp(HsWd);//回水温度
				double wc =sub(GsWd,HsWd);
				System.out.println("温差---"+wc);
				rb.setDiffTmp(wc);
				rb.setRecordTime(new Date()); //实时实时间
				rb.setReadMTime(ssTime);//热表时间
				rb.setStatus(status); //报警状态
				rb.setRbAd("1"+RbId); //热表地址
				rbService.updateRbById(rb);
				rbService.InsertRbHis(rb);	
				String qgid=stringHandler.substring(8,16);
				System.out.println("qgid----"+qgid);
				if (MapUtilsDf.getMapUtils().get("dRbParam") != null
						&& MapUtilsDf.getMapUtils().get("dRbParam").equals("" + RbId + ""))
				{
					MapUtils.getMapUtils().add("Crb",RbId);
					logs.info("读取热表成功");
					
				} else if (MapUtilsDf.getMapUtils().get("PlDRb") != null
						&& MapUtilsDf.getMapUtils().get("PlDRb").equals(""+qgid+""))
				{
					MapUtilsDf.getMapUtils().add("PldRb", "su");
					logs.info("区管实时热表成功");
				}
				logs.info("----汇中读取热表成功");
			  }
			}else if (stringHandler.length() - 1 > 200)
			{
				//消息长度
				String Cd=stringHandler.substring(2,4);
				
				String[] str = stringHandler.split("F04615");
				for (int i = 0; i < str.length; i++)
				{
					String iString = "F04615" + str[i];
					if (iString.length()==140) //有问题
					{
						// 判断和校验
						String jes = CzUtil.getJe(iString);
						String en=iString.substring(iString.length()-2);
						String sta = stringHandler.substring(0,2);
						// 截取效验数据
						String jys = CzUtil.getJy(iString);
						if( sta.equals("F0") && en.equals("FF") && jys.equals("" + jes + "")){
						RbCz(iString,connc);
						}
					}

				}
			}
			}
	  //新抄热表解析
	  public void XqCrb(byte[] base, Connection connc){
		  logs.info("-----自动抄表热表接收数据：" + Utils.bytesToHexString(base));
		   // 接收数据
			String stringH = Utils.bytesToHexString(base);
			// 转换为大写
			String stringHandler = CzUtil.Uppercase(stringH).toString();
			// 截取效验数据
			String jy = CzUtil.getJy(stringHandler);
			// 判断开始和结束
			String start = null;
			String end = null;
			start = stringHandler.charAt(0) + "" + stringHandler.charAt(1);
			end = stringHandler.charAt(stringHandler.length() - 2) + ""
					+ stringHandler.charAt(stringHandler.length() - 1);
			// 判断和校验
			String je = CzUtil.getJe(stringHandler);
			if (start.equals("F0") && end.equals("FF") && je.equals("" + jy + ""))
			{
				//热表地址
//				String rbid=stringHandler.substring(4,18);
				String rbid=stringHandler.substring(22,36);
				String RbId=rbid.replace("F","");
				
				System.out.println("------热表地址-----"+RbId );
				//累计热量
				Integer DqRl=Integer.valueOf(stringHandler.substring(46,52));
				String DqRls=stringHandler.substring(52,54);
			    String LdRl=DqRl+"."+DqRls;
			    System.out.println("-------热量---"+LdRl );
				
			    Integer ldrb=Integer.valueOf(stringHandler.substring(56,62));
				String ldrbs=stringHandler.substring(62,64);
				
				String Ldrb=ldrb+"."+ldrbs;
				 System.out.println("----累计热量-------"+Ldrb );
				 
				Integer ldgl=Integer.valueOf(stringHandler.substring(66,72));
				String ldgls=stringHandler.substring(72,74);
				//热功率
				String rgl=ldgl+"."+ldgls;
				System.out.println("------热功率-----"+rgl );
				
				Integer Ll=Integer.valueOf(stringHandler.substring(76,82));
				String Lls=stringHandler.substring(82,84);
				//流量
				String LlS=Ll+"."+Lls;
				System.out.println("-------瞬时流量----"+LlS );
				
				Integer LdLl=Integer.valueOf(stringHandler.substring(86,92));
				String LdLls=stringHandler.substring(92,94);
				//累计流量
				String LjLl=LdLl+"."+LdLls;
				System.out.println("-----累计流量------"+LjLl);
				
				Integer gswd=Integer.valueOf(stringHandler.substring(96,100));
				String gswds=stringHandler.substring(82,84);
				//供水温度
				String GsWd=gswd+"."+gswds;
				System.out.println("-----供水温度------"+GsWd );
				
				Integer hswd=Integer.valueOf(stringHandler.substring(102,106));
				String hswds=stringHandler.substring(106,108);
				
				
				
				//回水温度
				String HsWd=hswd+"."+hswds;
				System.out.println("------回水温度-----"+ HsWd);
				
				Integer ldgzTime=Integer.valueOf(stringHandler.substring(108,114));
//				String ldgzTImesl=stringHandler.substring(112,114);
				//累计时间
//				String ljsj=ldgzTime+"."+ldgzTImesl;
				System.out.println("-----累计工作时间------"+ldgzTime );
				
				String ssTimeN=stringHandler.substring(114,118);
				String ssTimeY=stringHandler.substring(118,120);
				String sstimeR=stringHandler.substring(120,122);
				String sstimeS=stringHandler.substring(122,124);
				String sstimeF=stringHandler.substring(124,126);
				String sstimeM=stringHandler.substring(126,128);
			   //实时时间
				String ssTime=ssTimeN+"-"+ssTimeY+"-"+sstimeR+" "+sstimeS+":"+sstimeF+":"+sstimeM;
				System.out.println("-----实时时间------"+ssTime );
				//报警状态
				String status=stringHandler.substring(128,132);
				System.out.println("-------报警状态----"+status );
				
				Rb rb=new Rb();
				rb.setEnergy(Double.valueOf(LdRl));//累计热量
				rb.setEnergyLj(Double.valueOf(LjLl));//累计流量
				rb.setPower(LdRl); //瞬时热量
				rb.setFlow(LlS); //瞬时流量
				rb.setInTmp(Double.valueOf(GsWd)); //进水温度
				rb.setOperTime(Double.valueOf(ldgzTime));
				rb.setOutTmp(Double.valueOf(HsWd));//回水温度
				rb.setRecordTime(new Date()); //实时实时间
				rb.setReadMTime(ssTime);//热表时间
				rb.setStatus(status); //报警状态
				rb.setRbAd(RbId); //热表地址
				rbService.updateRbById(rb);
				rbService.InsertRbHis(rb);		
//				if (MapUtilsDf.getMapUtils().get("dRbParam") != null
//						&& MapUtilsDf.getMapUtils().get("dRbParam").equals("" + RbId + ""))
//				{
//					MapUtils.getMapUtils().add("Crb",RbId);
//					logs.info("读取热表成功");
//				} else if (MapUtilsDf.getMapUtils().get("PlDRb") != null
//						&& MapUtilsDf.getMapUtils().get("PlDRb").equals("rb"))
//				{
//					MapUtilsDf.getMapUtils().add("PldRb", "success");
//					logs.info("区管实时热表成功");
//				}else{
//					MapUtilsSkq.getMapUtils().add("Crb", "fail");
//					logs.info("读取热表失败");
//				}
				
			} else if (stringHandler.length() - 1 > 129)
			{
				//消息长度
				String Cd=stringHandler.substring(2,4);
				
				String[] str = stringHandler.split("F046F4");
				for (int i = 0; i < str.length; i++)
				{
					String iString = "F046F4" + str[i];
					if (iString.length()==140) //有问题
					{
						RbCzS(iString,connc);
					} else
					{
						MapUtilsDf.getMapUtils().add("Crb", "fail");
						logs.info("读取热表失败");
					}

				}
			} else
			{
				MapUtilsDf.getMapUtils().add("Crb", "fail");
				logs.info("读取热表失败");
			}
	  }
	  public void RbCz(String stringHandler, Connection connc)
		{
			
				// 截取效验数据
				String jy = CzUtil.getJy(stringHandler);
				// 判断和校验
				String je = CzUtil.getJe(stringHandler);
				String end = null;
				String start = null;
				String Ldrb;
				String LjLl;
				end = stringHandler.charAt(stringHandler.length() - 2) + ""
						+ stringHandler.charAt(stringHandler.length() - 1);
				start = stringHandler.charAt(0) + "" + stringHandler.charAt(1);
				if (start.equals("F0") && end.equals("FF") && je.equals("" + jy + ""))
				{
					//热表地址
					String rbid=stringHandler.substring(22,36);
					String RbId=rbid.replace("F","");
					
					System.out.println("------热表地址-----"+RbId );
					//报警状态
					Integer sus=Integer.valueOf(stringHandler.substring(130,132));
					//状态与
					int stst=sus&0x0f;
					// FmID十进制转换为十六进制
	    			String statu = Integer.toHexString(stst);
	    			//ox10
	    			String st= Integer.toHexString(sus&0x10);
	    			//0x40
	    			String sts=Integer.toHexString(sus&0x40);
					if(statu.equals("1")){
						status="需要更换电池";
					}else if(statu.equals("2")){
						status="空管或者换能器故障";
					}else if(statu.equals("4")){
						status="必须更换电池";
					}else if(statu.equals("5")){
						status="传感器和换能器之间通讯故障";
					}else if(statu.equals("6")){
						status="E2PROM损坏";
					}else if(st.equals("10")){
						status="供水温度故障";
					}else if(sts.equals("40")){
						status="回水温度传感器故障";
					}else if(sus==00) {
						status="正常";
					} else {
						status="未知";
					}	   		
					String ldrl=stringHandler.substring(56,62);
					if(ldrl.contains("F")){
						status="未知";
						 Ldrb="999";
					}else{
						 Integer ldrb=Integer.valueOf(ldrl);
						String ldrbs=stringHandler.substring(62,64); //两位小数
						System.out.println("-----ldrb-----"+ldrb);
						System.out.println("-----ldrbs-----"+ldrbs);
						 Ldrb=ldrb+"."+ldrbs;
						System.out.println("----累计热量-------"+Ldrb );	
					}
					System.out.println("----累计热量-------"+Ldrb );
//				    Integer ldrb=Integer.valueOf(stringHandler.substring(56,62));
//					Integer ldrb=Integer.valueOf(ldrl);
//					String ldrbs=stringHandler.substring(62,64); //两位小数
//					System.out.println("-----ldrb-----"+ldrb);
//					System.out.println("-----ldrbs-----"+ldrbs);
//					String Ldrb=ldrb+"."+ldrbs;
//					 System.out.println("----累计热量-------"+Ldrb );
					    Integer ldgl=Integer.valueOf(stringHandler.substring(66,72));
						String ldgls=stringHandler.substring(72,74);//两位小数
						//热功率 
						String rgl=ldgl+"."+ldgls;
						System.out.println("------热功率-----"+rgl );
						Integer Ll=Integer.valueOf(stringHandler.substring(76,80));
						String Lls=stringHandler.substring(80,84);//四位小数
						//流量
						String LlS=Ll+"."+Lls;
						System.out.println("-------瞬时流量----"+LlS );
						String ldLls=stringHandler.substring(86,92);
						if(ldLls.contains("F")){
							status="未知";
							LjLl="999";
						}else{
							Integer LdLl=Integer.valueOf(stringHandler.substring(86,92));
							String LdLls=stringHandler.substring(92,94);//两位小数
							//累计流量
							 LjLl=LdLl+"."+LdLls;
							System.out.println("-----累计流量------"+LjLl);
//							LdLl=Integer.valueOf(ldLls);
						}
						System.out.println("-----累计流量------"+LjLl);
//					Integer LdLl=Integer.valueOf(stringHandler.substring(86,92));
//					String LdLls=stringHandler.substring(92,94);//两位小数
//					//累计流量
//					String LjLl=LdLl+"."+LdLls;
//					System.out.println("-----累计流量------"+LjLl);
					
					Integer gswd=Integer.valueOf(stringHandler.substring(96,100));
					String gswds=stringHandler.substring(100,102);//两位小数
					//供水温度
					Double GsWd=Double.valueOf(gswd+"."+gswds);
					System.out.println("-----进水温度------"+GsWd );
					
					Integer hswd=Integer.valueOf(stringHandler.substring(102,106));
					String hswds=stringHandler.substring(106,108);
					//回水温度
					Double HsWd=Double.valueOf(hswd+"."+hswds);
					System.out.println("------回水温度-----"+ HsWd);
					
					Integer ldgzTime=Integer.valueOf(stringHandler.substring(108,114));
					//累计时间
					System.out.println("-----累计工作时间------"+ldgzTime );
					
					String ssTimeN=stringHandler.substring(114,118);
					String ssTimeY=stringHandler.substring(118,120);
					String sstimeR=stringHandler.substring(120,122);
					String sstimeS=stringHandler.substring(122,124);
					String sstimeF=stringHandler.substring(124,126);
					String sstimeM=stringHandler.substring(126,128);
				   //实时时间
					String ssTime=ssTimeN+"-"+ssTimeY+"-"+sstimeR+" "+sstimeS+":"+sstimeF+":"+sstimeM;
					System.out.println("-----实时时间------"+ssTime );			
					Rb rb=new Rb();
					rb.setEnergy(Double.valueOf(Ldrb));//累计热量
					rb.setEnergyLj(Double.valueOf(LjLl));//累计流量
					rb.setPower(rgl); //瞬时热量
					rb.setFlow(LlS); //瞬时流量
					rb.setInTmp(GsWd); //进水温度
					rb.setOperTime(Double.valueOf(ldgzTime));
					rb.setOutTmp(HsWd);//回水温度
					double wc =sub(GsWd,HsWd);
					System.out.println("温差---"+wc);
					rb.setDiffTmp(wc);
					rb.setRecordTime(new Date()); //实时实时间
					rb.setReadMTime(ssTime);//热表时间
					rb.setStatus(status); //报警状态
					rb.setRbAd("1"+RbId); //热表地址
					rbService.updateRbById(rb);
					rbService.InsertRbHis(rb);	
					String qgid=stringHandler.substring(8,16);
					System.out.println("qgid----"+qgid);
					if (MapUtilsDf.getMapUtils().get("dRbParam") != null
							&& MapUtilsDf.getMapUtils().get("dRbParam").equals("" + RbId + ""))
					{
						MapUtils.getMapUtils().add("Crb",RbId);
						logs.info("读取热表成功");
						
					} else if (MapUtilsDf.getMapUtils().get("PlDRb") != null
							&& MapUtilsDf.getMapUtils().get("PlDRb").equals(""+qgid+""))
					{
						MapUtilsDf.getMapUtils().add("PldRb", "su");
						logs.info("区管实时热表成功");
					}
					logs.info("----汇中读取热表成功");
				}
			}
	  public void RbCzS(String stringHandler, Connection connc)
		{
			
				// 截取效验数据
				String jy = CzUtil.getJy(stringHandler);
				// 判断和校验
				String je = CzUtil.getJe(stringHandler);
				String end = null;
				String start = null;
				end = stringHandler.charAt(stringHandler.length() - 2) + ""
						+ stringHandler.charAt(stringHandler.length() - 1);
				start = stringHandler.charAt(0) + "" + stringHandler.charAt(1);
				if (start.equals("F0") && end.equals("FF") && je.equals("" + jy + ""))
				{
					//热表地址
//					String rbid=stringHandler.substring(4,18);
					String rbid=stringHandler.substring(22,36);
					String RbId=rbid.replace("F","");
					
					System.out.println("------热表地址-----"+RbId );
					//累计热量
					Integer DqRl=Integer.valueOf(stringHandler.substring(46,52));
					String DqRls=stringHandler.substring(52,54);
				    String LdRl=DqRl+"."+DqRls;
				    System.out.println("-------热量---"+LdRl );
					
				    Integer ldrb=Integer.valueOf(stringHandler.substring(56,62));
					String ldrbs=stringHandler.substring(62,64);
					
					String Ldrb=ldrb+"."+ldrbs;
					 System.out.println("----累计热量-------"+Ldrb );
					 
					Integer ldgl=Integer.valueOf(stringHandler.substring(66,72));
					String ldgls=stringHandler.substring(72,74);
					//热功率
					String rgl=ldgl+"."+ldgls;
					System.out.println("------热功率-----"+rgl );
					
					Integer Ll=Integer.valueOf(stringHandler.substring(76,82));
					String Lls=stringHandler.substring(82,84);
					//流量
					String LlS=Ll+"."+Lls;
					System.out.println("-------瞬时流量----"+LlS );
					
					Integer LdLl=Integer.valueOf(stringHandler.substring(86,92));
					String LdLls=stringHandler.substring(92,94);
					//累计流量
					String LjLl=LdLl+"."+LdLls;
					System.out.println("-----累计流量------"+LjLl);
					
					Integer gswd=Integer.valueOf(stringHandler.substring(96,100));
					String gswds=stringHandler.substring(82,84);
					//供水温度
					String GsWd=gswd+"."+gswds;
					System.out.println("-----供水温度------"+GsWd );
					
					Integer hswd=Integer.valueOf(stringHandler.substring(102,106));
					String hswds=stringHandler.substring(106,108);
					//回水温度
					String HsWd=hswd+"."+hswds;
					System.out.println("------回水温度-----"+ HsWd);
					
					Integer ldgzTime=Integer.valueOf(stringHandler.substring(108,114));
//					String ldgzTImesl=stringHandler.substring(112,114);
					//累计时间
//					String ljsj=ldgzTime+"."+ldgzTImesl;
					System.out.println("-----累计工作时间------"+ldgzTime );
					
					String ssTimeN=stringHandler.substring(114,118);
					String ssTimeY=stringHandler.substring(118,120);
					String sstimeR=stringHandler.substring(120,122);
					String sstimeS=stringHandler.substring(122,124);
					String sstimeF=stringHandler.substring(124,126);
					String sstimeM=stringHandler.substring(126,128);
				   //实时时间
					String ssTime=ssTimeN+"-"+ssTimeY+"-"+sstimeR+" "+sstimeS+":"+sstimeF+":"+sstimeM;
					System.out.println("-----实时时间------"+ssTime );
					//报警状态
					String status=stringHandler.substring(128,132);
					System.out.println("-------报警状态----"+status );
					
					Rb rb=new Rb();
					rb.setEnergy(Double.valueOf(LdRl));//累计热量
					rb.setEnergyLj(Double.valueOf(LjLl));//累计流量
					rb.setPower(LdRl); //瞬时热量
					rb.setFlow(LlS); //瞬时流量
					rb.setInTmp(Double.valueOf(GsWd)); //进水温度
					rb.setOperTime(Double.valueOf(ldgzTime));
					rb.setOutTmp(Double.valueOf(HsWd));//回水温度
					rb.setRecordTime(new Date()); //实时实时间
					rb.setReadMTime(ssTime);//热表时间
					rb.setStatus(status); //报警状态
					rb.setRbAd(RbId); //热表地址
					rbService.updateRbById(rb);
					rbService.InsertRbHis(rb);	
					
//					Integer ldgzTime=Integer.valueOf(stringHandler.substring(108,112));
//					String ldgzTImesl=stringHandler.substring(112,114);
//					//累计时间
//					String ljsj=ldgzTime+"."+ldgzTImesl;
//					System.out.println("-----累计工作时间------"+ljsj );
//					
//					String ssTimeN=stringHandler.substring(114,118);
//					String ssTimeY=stringHandler.substring(118,120);
//					String sstimeR=stringHandler.substring(120,122);
//					String sstimeS=stringHandler.substring(122,124);
//					String sstimeF=stringHandler.substring(124,126);
//					String sstimeM=stringHandler.substring(126,128);
//				   //实时时间
//					String ssTime=ssTimeN+"-"+ssTimeY+"-"+sstimeR+" "+sstimeS+":"+sstimeF+":"+sstimeM;
//					System.out.println("-----实时时间------"+ssTime );
//					//报警状态
//					String status=stringHandler.substring(110,114);
//					System.out.println("-------报警状态----"+status );
//					
//					Rb rb=new Rb();
//					rb.setEnergy(Double.valueOf(LdRl));//累计热量
//					rb.setEnergyLj(Double.valueOf(LjLl));//累计流量
//					rb.setPower(LdRl); //瞬时热量
//					rb.setFlow(LlS); //瞬时流量
//					rb.setInTmp(Double.valueOf(GsWd)); //进水温度
//					rb.setOperTime(Double.valueOf(ljsj));
//					rb.setOutTmp(Double.valueOf(HsWd));//回水温度
//					rb.setRecordTime(new Date()); //实时实时间
//					rb.setReadMTime(ssTime);//热表时间
//					rb.setStatus(status); //报警状态
//					rb.setRbAd(RbId); //热表地址
//					rbService.updateRbById(rb);
//					rbService.InsertRbHis(rb);	
//					
//					if (MapUtilsDf.getMapUtils().get("dRbParam") != null
//							&& MapUtilsDf.getMapUtils().get("dRbParam").equals("" + RbId + ""))
//					{
//						MapUtils.getMapUtils().add("Crb",RbId);
//						logs.info("读取热表成功");
//					} else if (MapUtilsDf.getMapUtils().get("PlDRb") != null
//							&& MapUtilsDf.getMapUtils().get("PlDRb").equals("rb"))
//					{
//						MapUtilsDf.getMapUtils().add("PldRb", "success");
//						logs.info("区管实时热表成功");
//					} 
				}
			}
		
  
	  
	// 抄取热表
	public void CqRb(byte[] base, Connection connc)
	{
		logs.info("热表接收数据：" + Utils.bytesToHexString(base));
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 获取发送的时间
		String fTime = MapUtils.getMapUtils().get("time");
		String jTime = df.format(new Date());
		int ms = 0;
		String sumTime = CzUtil.getSubtract(fTime, jTime);
		if (sumTime == null)
		{
			sumTime = "00:00:01";
		}
		if (sumTime != null)
		{
			ms = CzUtil.transform(sumTime);
			// 判断时间是否超时
			if (ms <= 60)
			{
				// 接收数据
				String stringH = Utils.bytesToHexString(base);
				// 转换为大写
				String stringHandler = CzUtil.Uppercase(stringH).toString();
				// 截取效验数据
				String jy = CzUtil.getJy(stringHandler);
				// 判断开始和结束
				String start = null;
				String end = null;
				start = stringHandler.charAt(0) + "" + stringHandler.charAt(1);
				end = stringHandler.charAt(stringHandler.length() - 2) + ""
						+ stringHandler.charAt(stringHandler.length() - 1);
				// 判断和校验
				String je = CzUtil.getJe(stringHandler);
				if (start.equals("F0") && end.equals("FF") && je.equals("" + jy + ""))
				{
					// 区管ID
					String qgID = stringHandler.substring(8, 16);
					// 热表ID
					String RbID = stringHandler.substring(21, 30);
					String dd=stringHandler.substring(30,50);
					System.out.println("30-------------------------"+dd);
					// 当前热量
					String DqRL = stringHandler.substring(50, 60);
					String DqRLS = DqRL.substring(0, 6);
					String DqRLF = DqRL.substring(6, 8);
					int dqrls = Integer.valueOf(DqRLS);
					int dqrlf = Integer.valueOf(DqRLF);
					// 累计热量
					String DqRLSF = dqrls + "." + dqrlf;
					// 热功率
					String RGL = stringHandler.substring(60, 70);
					String RGLS = RGL.substring(0, 6);
					String RGLF = RGL.substring(6, 8);
					int rgls = Integer.valueOf(RGLS);
					int rglf = Integer.valueOf(RGLF);
					// 拼接热功率
					String RGLSF = rgls + "." + rglf;
					// 顺时流量
					String LM = stringHandler.substring(70, 80);
					String LMS = LM.substring(0, 4);
					int lms = Integer.valueOf(LMS);
					String LMF = LM.substring(4, 8);
					int lmf = Integer.valueOf(LMF);
					// 顺时流量
					String LMSF = lms + "." + lmf;
					// 累计流量
					String JLM = stringHandler.substring(80, 90);
					String JLMS = JLM.substring(0, 6);
					String JLMF = JLM.substring(6, 8);
					int jlms = Integer.valueOf(JLMS);
					int jlmf = Integer.valueOf(JLMF);
					// 累计流量拼接
					String JLMSF = jlms + "." + jlmf;
					// 供水温度
					String GsWd = stringHandler.substring(90, 96);
					String GsWdS = GsWd.substring(0, 4);
					String GsWdF = GsWd.substring(4);
					int gswds = Integer.valueOf(GsWdS);
					int gswdf = Integer.valueOf(GsWdF);
					// 供水温度
					String GsWdSF = gswds + "." + gswdf;
					// 回水温度
					String HsWd = stringHandler.substring(96, 102);

					String HsWdS = HsWd.substring(0, 4);
					String HsWdF = HsWd.substring(4);
					int hswds = Integer.valueOf(HsWdS);
					int hswdf = Integer.valueOf(HsWdF);
					// 回水温度
					String HsWdSF = hswds + "." + hswdf;
					// 累计工作时间 2小时
					String GzTime = stringHandler.substring(102, 108);
					int time = Integer.valueOf(GzTime);
					// 实时时间
					String SsTime = stringHandler.substring(108, 122);
					Integer nString = Integer.valueOf(SsTime.substring(0, 4));
					Integer sString = Integer.valueOf(SsTime.substring(4, 6));
					Integer mString = Integer.valueOf(SsTime.substring(6, 8));
					Integer fString = Integer.valueOf(SsTime.substring(8, 10));
					Integer fStrings = Integer.valueOf(SsTime.substring(10, 12));
					Integer fStrings1 = Integer.valueOf(SsTime.substring(12, 14));
					String time1 = nString + "/" + sString + "/" + mString + " " + fString + ":" + fStrings + ":"
							+ fStrings1;
					// 状态码
					String status = stringHandler.substring(122, 126);
					Rb rb=new Rb();
					rb.setEnergy(Double.valueOf(DqRLSF));
					rb.setEnergyLj(Double.valueOf(JLMSF));
					rb.setPower(RGLSF);
					rb.setFlow(LMSF);
					rb.setInTmp(Double.valueOf(GsWdSF));
					rb.setOperTime(Double.valueOf(time));
					rb.setOutTmp(Double.valueOf(HsWdSF));
					rb.setRecordTime(new Date());
					rb.setReadMTime(time1);
					rb.setStatus(status);
					rb.setRbAd(RbID);
					rbService.updateRbById(rb);
					rbService.InsertRbHis(rb);
					// 更新
					if (MapUtilsDf.getMapUtils().get("dRbParam") != null
							&& MapUtilsDf.getMapUtils().get("dRbParam").equals("" + RbID + ""))
					{
						MapUtils.getMapUtils().add("Crb", "success");
					} else if (MapUtilsDf.getMapUtils().get("PlDRb") != null
							&& MapUtilsDf.getMapUtils().get("PlDRb").equals("rb"))
					{
						MapUtilsDf.getMapUtils().add("PldRb", "success");
					}

					logs.info("读取热表成功");
				} else if (stringHandler.length() - 1 > 129)
				{
					String[] str = stringHandler.split("F04102");
					for (int i = 0; i < str.length; i++)
					{
						String iString = "F04102" + str[i];
						if (iString.length() - 1 == 129)
						{
							RbCz(iString, jTime, connc);
						} else
						{
							MapUtilsDf.getMapUtils().add("Crb", "fail");
							logs.info("读取热表失败");
						}

					}
				} else
				{
					MapUtilsDf.getMapUtils().add("Crb", "fail");
					logs.info("读取热表失败");
				}
			} else
			{
				MapUtilsDf.getMapUtils().add("Crb", "cs");
				logs.info("读取热表超时");
			}
		}
	}

	public void RbCz(String stringHandler, String jTime, Connection connc)
	{
		
			// 截取效验数据
			String jy = CzUtil.getJy(stringHandler);
			// 判断和校验
			String je = CzUtil.getJe(stringHandler);
			String end = null;
			end = stringHandler.charAt(stringHandler.length() - 2) + ""
					+ stringHandler.charAt(stringHandler.length() - 1);
			if (end.equals("FF") && je.equals("" + jy + ""))
			{
				// 区管ID
				String qgID = stringHandler.substring(8, 16);
				// 热表ID
				String RbID = stringHandler.substring(21, 30);
				// 当前热量
				String DqRL = stringHandler.substring(50, 60);
				String DqRLS = DqRL.substring(0, 6);
				String DqRLF = DqRL.substring(6, 8);
				int dqrls = Integer.valueOf(DqRLS);
				int dqrlf = Integer.valueOf(DqRLF);
				// 拼接当前热量
				String DqRLSF = dqrls + "." + dqrlf;
				// 热功率
				String RGL = stringHandler.substring(60, 70);
				String RGLS = RGL.substring(0, 6);
				String RGLF = RGL.substring(6, 8);
				int rgls = Integer.valueOf(RGLS);
				int rglf = Integer.valueOf(RGLF);
				// 拼接热功率
				String RGLSF = rgls + "." + rglf;
				// 顺时流量
				String LM = stringHandler.substring(70, 80);
				String LMS = LM.substring(0, 4);
				int lms = Integer.valueOf(LMS);
				String LMF = LM.substring(4, 8);
				int lmf = Integer.valueOf(LMF);
				// 顺时流量
				String LMSF = lms + "." + lmf;
				// 累计流量
				String JLM = stringHandler.substring(80, 90);
				String JLMS = JLM.substring(0, 6);
				String JLMF = JLM.substring(6, 8);
				int jlms = Integer.valueOf(JLMS);
				int jlmf = Integer.valueOf(JLMF);
				// 累计流量拼接
				String JLMSF = jlms + "." + jlmf;
				// 供水温度
				String GsWd = stringHandler.substring(90, 96);
				String GsWdS = GsWd.substring(0, 4);
				String GsWdF = GsWd.substring(4);
				int gswds = Integer.valueOf(GsWdS);
				int gswdf = Integer.valueOf(GsWdF);
				// 供水温度
				String GsWdSF = gswds + "." + gswdf;
				// 回水温度
				String HsWd = stringHandler.substring(96, 102);

				String HsWdS = HsWd.substring(0, 4);
				String HsWdF = HsWd.substring(4);
				int hswds = Integer.valueOf(HsWdS);
				int hswdf = Integer.valueOf(HsWdF);
				// 回水温度
				String HsWdSF = hswds + "." + hswdf;
				
				
				// 累计工作时间 2小时
				String GzTime = stringHandler.substring(102, 108);
				int time = Integer.valueOf(GzTime);
				// 实时时间
				String SsTime = stringHandler.substring(108, 122);
				Integer nString = Integer.valueOf(SsTime.substring(0, 4));
				Integer sString = Integer.valueOf(SsTime.substring(4, 6));
				Integer mString = Integer.valueOf(SsTime.substring(6, 8));
				Integer fString = Integer.valueOf(SsTime.substring(8, 10));
				Integer fStrings = Integer.valueOf(SsTime.substring(10, 12));
				Integer fStrings1 = Integer.valueOf(SsTime.substring(12, 14));
				String time1 = nString + "/" + sString + "/" + mString + " " + fString + ":" + fStrings + ":"
						+ fStrings1;
				// 状态码
				String status = stringHandler.substring(122, 126);
				Rb rb=new Rb();
				rb.setEnergy(Double.valueOf(DqRLSF));
				rb.setEnergyLj(Double.valueOf(JLMSF));
				rb.setPower(RGLSF);
				rb.setFlow(LMSF);
				rb.setInTmp(Double.valueOf(GsWdSF));
				rb.setOperTime(Double.valueOf(time));
				rb.setOutTmp(Double.valueOf(HsWdSF));
				rb.setRecordTime(new Date());
				rb.setReadMTime(time1);
				rb.setStatus(status);
				rb.setRbAd(RbID);
				rbService.updateRbById(rb);
				rbService.InsertRbHis(rb);
				// 更新
				if (MapUtilsDf.getMapUtils().get("dRbParam") != null
						&& MapUtilsDf.getMapUtils().get("dRbParam").equals("" + RbID + ""))
				{
					MapUtils.getMapUtils().add("Crb", "success");
				} else if (MapUtilsDf.getMapUtils().get("PlDRb") != null
						&& MapUtilsDf.getMapUtils().get("PlDRb").equals("rb"))
				{
					MapUtilsDf.getMapUtils().add("PldRb", "success");
				}
				logs.info("读取热表成功");

				
			} else
			{
				MapUtilsSkq.getMapUtils().add("Crb", "fail");
				logs.info("读取热表失败");
			}
		}
	
	 public static double sub(Double value1, Double value2) {
	      BigDecimal b1 = new BigDecimal(Double.toString(value1));
	     BigDecimal b2 = new BigDecimal(Double.toString(value2));
	     return b1.subtract(b2).doubleValue();
	 }
	
	// 更新区管ID
	public void UpQg(byte[] base, Connection connc)
	{
		logs.info("更新区管ID接收数据：" + Utils.bytesToHexString(base));
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// 接收的数据
				String stringH = Utils.bytesToHexString(base);
				// 转换为大写
				String stringHandler = CzUtil.Uppercase(stringH).toString();
				// 截取效验数据
				String jy = CzUtil.getJy(stringHandler);
				// 判断开始和结束
				String start = null;
				String end = null;
				start = stringHandler.charAt(0) + "" + stringHandler.charAt(1);
				end = stringHandler.charAt(stringHandler.length() - 2) + ""
						+ stringHandler.charAt(stringHandler.length() - 1);
				String je = CzUtil.getJe(stringHandler);
				if (start.equals("F0") && end.equals("FF") && je.equals("" + jy + ""))
				{
					String jeq = stringHandler.substring(16, 18);
					if (jeq.equals("01"))
					{
						String qgid=stringHandler.substring(8,16);
						//更新新的区管
						logs.info("更新区管ID成功：" + stringHandler);
						logs.info("更新区管ID成功");
						MapUtils.getMapUtils().add("UpQg", qgid);
					}
				}
	}
	
	// 添加热表ID
	public void AddRbId(byte[] base, Connection connc)
	{
		logs.info("添加热表ID接收数据：" + Utils.bytesToHexString(base));
				// 接收的数据
				String stringH = Utils.bytesToHexString(base);
				// 转换为大写
				String stringHandler = CzUtil.Uppercase(stringH).toString();
				// 截取效验数据
				String jy = CzUtil.getJy(stringHandler);
				// 判断开始和结束
				String start = null;
				String end = null;
				start = stringHandler.charAt(0) + "" + stringHandler.charAt(1);
				end = stringHandler.charAt(stringHandler.length() - 2) + ""
						+ stringHandler.charAt(stringHandler.length() - 1);
				String je = CzUtil.getJe(stringHandler);
				if (start.equals("F0") && end.equals("FF") && je.equals("" + jy + ""))
				{
					String jeq = stringHandler.substring(16, 18);
					if (jeq.equals("01"))
					{
						//0 成功，1失败
						String status=stringHandler.substring(18,20);
						//更新新的区管
						if(status.equals("0")){
						logs.info("添加热表ID成功：" + stringHandler);
						MapUtils.getMapUtils().add("addRbId", "success");
						}
					}
				}
	}
	// 删除热表ID
		public void DeleteRbId(byte[] base, Connection connc)
		{
			       logs.info("删除热表ID接收数据：" + Utils.bytesToHexString(base));
					// 接收的数据
					String stringH = Utils.bytesToHexString(base);
					// 转换为大写
					String stringHandler = CzUtil.Uppercase(stringH).toString();
					// 截取效验数据
					String jy = CzUtil.getJy(stringHandler);
					// 判断开始和结束
					String start = null;
					String end = null;
					start = stringHandler.charAt(0) + "" + stringHandler.charAt(1);
					end = stringHandler.charAt(stringHandler.length() - 2) + ""
							+ stringHandler.charAt(stringHandler.length() - 1);
					String je = CzUtil.getJe(stringHandler);
					if (start.equals("F0") && end.equals("FF") && je.equals("" + jy + ""))
					{
						String jeq = stringHandler.substring(16, 18);
						if (jeq.equals("01"))
						{
							//0 成功，1失败
							String status=stringHandler.substring(18,20);
							//区管地址为 
							String qgId=stringHandler.substring(8,16);
							//更新新的区管
							if(status.equals("0")){
							logs.info("删除ID成功：" + stringHandler);
							MapUtils.getMapUtils().add("deleteRbId", qgId);
							}
						}
					}
		}
	// 区管查询
	public void qgCx(byte[] base, Connection connc, String clientIp)
	{
		String[] ipPortString = clientIp.split(":");
		String IP = ipPortString[0];

		String[] ip = IP.split("/");
		Integer port = Integer.valueOf(ipPortString[1]);
		String Ip = ip[1];
		// 接收数据F00B0501D0D0D0200192FF
		logs.info("区管查询接收数据：" + Utils.bytesToHexString(base));
		// 获取发送的时间
				String qgId = null;
				SimpleDateFormat Sdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// 获取发送的时间
				String time = Sdate.format(new Date());
				// 接收的数据
				String stringH = Utils.bytesToHexString(base);
				// 转换为大写
				String stringHandler = CzUtil.Uppercase(stringH).toString();

				// 截取效验数据
				String jy = CzUtil.getJy(stringHandler);
				// 判断开始和结束
				String start = null;
				String end = null;
				start = stringHandler.charAt(0) + "" + stringHandler.charAt(1);
				end = stringHandler.charAt(stringHandler.length() - 2) + ""
						+ stringHandler.charAt(stringHandler.length() - 1);
				String je = CzUtil.getJe(stringHandler);
				if (start.equals("F0") && end.equals("FF") && je.equals("" + jy + ""))
				{
		
//									String sqlcx = "select JzqID from T_JzqInfo where JzqIP='" + Ip + "' and JzqPort='"+port+"'";
										try
										{
											// 截取qgID,
											qgId = stringHandler.substring(8, 16);
												//更新区管状态和时间
												qgService.updateQgSta(time,qgId);
												 String qgString="update T_QgInfo set RecordTime='"+time+"',QgStatus=1 where QgID='"+qgId+"'";
											ps = connc.prepareStatement(qgString);
											rst = ps.executeQuery();
										} catch (SQLException e)
										{
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										
						
						Qg	qg=	qgService.findQgID(qgId);
						String jzqId=qg.getJzqID();
						//根据集中器ID 更新IP和端口号
						qgService.updateQgIP(Ip, port,jzqId,time);
						logs.info("更新区管地址的IP和Port" + qgId);
						logs.info("区管查询成功：" + stringHandler);
						MapUtils.getMapUtils().add("qg",qgId);
						logs.info("区管查询成功");

				}
			}

	// 集中器查询
	public void jzqCx(byte[] base, Connection connc,String clientIp)
	{
		logs.info("集中器查询状态接收数据：" + Utils.bytesToHexString(base));
		String jzqPort = null;
		String[] ipPortString = clientIp.split(":");
		String IP = ipPortString[0];

		String[] ip = IP.split("/");
		Integer port = Integer.valueOf(ipPortString[1]);
		String Ip = ip[1];
		SimpleDateFormat Sdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 获取发送的时间
		String time = Sdate.format(new Date());
		// 接收的数据
		String stringH = Utils.bytesToHexString(base);
		// 转换为大写
		String stringHandler = CzUtil.Uppercase(stringH).toString();
		// 截取jzqID
		String JzqId = stringHandler.substring(8, 16);

		// 截取效验数据
		String jy = CzUtil.getJy(stringHandler);
		// 判断开始和结束
		String start = null;
		String end = null;
		String id =null;
		start = stringHandler.charAt(0) + "" + stringHandler.charAt(1);
		end = stringHandler.charAt(stringHandler.length() - 2) + "" + stringHandler.charAt(stringHandler.length() - 1);
		String je = CzUtil.getJe(stringHandler);
		if (start.equals("F0") && end.equals("FF") && je.equals("" + jy + ""))
		{
			//根据集中器IP和端口号查找集中器ID
//		    Jzq jzq=jzqService.findJzqID(Ip, port);
//			// 如果集中器ID不为空
//			if (jzq != null)
//			{
//				// 根据集中器ID更新集中器端口
//				 jzqService.updateStTim("1", time, JzqId);
//			}else{
//				// 根据集中器ID更新集中器端口
//				jzqService.updateIpPort(Ip, port, time, JzqId);
//
//			}
			
     	String sqlcx = "select JzqID from T_JzqInfo where JzqIP='" + Ip + "' and JzqPort='"+port+"'";
			try
			{
				ps = connc.prepareStatement(sqlcx);
				rst = ps.executeQuery();
				int col = rst.getMetaData().getColumnCount();
				while (rst.next())
				{
					id = rst.getString("JzqID");
				}
			//System.out.println("id---------"+id);
		
			// 如果集中器ID不为空
			if (id != null)
			{ 
				// 根据集中器ID更新集中器端口
				String sql = "update T_JzqInfo set Status='1',UpdateTime='" + time
						+ "' where JzqID='" + JzqId + "'";
				ps = connc.prepareStatement(sql);
				rs = ps.executeUpdate();
			//	System.out.println("id不为空----------"+sql);
			}else{
				// 根据集中器ID更新集中器端口
				String sql = "update T_JzqInfo set JzqPort='" + port + "',JzqIP='"+Ip+"', Status='1',UpdateTime='" + time
						+ "' where JzqID='" + JzqId + "'";
				try
				{
					ps = connc.prepareStatement(sql);
					rs = ps.executeUpdate();
				} catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			} catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				MapUtils.getMapUtils().add("jzq", JzqId);
				logs.info("集中器查询状态成功接收数据：------------------" + stringHandler);

		}
	}

	/**
	 * 当连接进入空闲状态时调用̬
	 */
	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception
	{
		logs.info("当前连接" + session.getRemoteAddress() + "处于空闲状态:{}" + status);
	}

	/**
	 * 当消息已经送给客户端后触发此方法
	 */
	@Override
	public void messageSent(IoSession session, Object message) throws Exception
	{
		logs.info("服务器发送给" + session.getRemoteAddress() + "的消息:" + message);
	}

	/**
	 * 当关闭时调用
	 */
	@Override
	public void sessionClosed(IoSession session) throws Exception
	{
		@SuppressWarnings("deprecation")
		CloseFuture closeFuture = session.close(true);
		closeFuture.addListener(new IoFutureListener<IoFuture>()
		{
			public void operationComplete(IoFuture future)
			{
				if (future instanceof CloseFuture)
				{
					((CloseFuture) future).setClosed();
					logs.info("sessionClosed CloseFuture setClosed-->" + future.getSession().getId());
				}
			}
		});
		sessionMap.remove(session);
		logs.info("关闭当前session：" + session.getId() + session.getRemoteAddress() + "..已移除");
	}

}
