package com.hnzy.socket.server;

import org.apache.mina.core.service.IoHandlerAdapter;

//
//import java.math.BigDecimal;
//import java.net.SocketAddress;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.apache.mina.core.future.CloseFuture;
//import org.apache.mina.core.future.IoFuture;
//import org.apache.mina.core.future.IoFutureListener;
//import org.apache.mina.core.service.IoHandlerAdapter;
//import org.apache.mina.core.session.IdleStatus;
//import org.apache.mina.core.session.IoSession;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.hnzy.hot.controller.DataController;
//import com.hnzy.hot.pojo.Data;
//import com.hnzy.hot.pojo.FyFl;
//import com.hnzy.hot.pojo.Jf;
//import com.hnzy.hot.pojo.YhMessage;
//import com.hnzy.hot.service.DataService;
//import com.hnzy.hot.service.FyFlService;
//import com.hnzy.hot.service.JfService;
//import com.hnzy.hot.service.JzqService;
//import com.hnzy.hot.service.YhMessageService;
//import com.hnzy.hot.util.Utils;
//import com.hnzy.socket.util.CzUtil;
//import com.hnzy.socket.util.MapUtilsDf;
public class ServerHandler extends IoHandlerAdapter
{
}
//	PreparedStatement ps;
//	ResultSet rst;
//	int rs = 0;
//	@Autowired
//	private JzqService jzqService;
//	@Autowired
//	private DataService dataService;
//	@Autowired
//	public JfService jfServce;
//	@Autowired
//	private FyFlService fyFlService;
//	@Autowired
//	private YhMessageService yhMessageService;
//	public String js;
//	public String state;
//
//	Data jszl=new Data();
//	// 日志文件
//	private static Log logs = LogFactory.getLog(ServerHandler.class);
//	ServerSessionMap sessionMap = ServerSessionMap.getInstance();
//	DataController da=new DataController();
//	/**
//	 * 当一个新客户端连接后触发此方法
//	 */
//	public void sessionCreated(IoSession session)
//	{
//		logs.info("服务器创建链路成功!" + session.getRemoteAddress());
//	}
//
//	/**
//	 * 当链接打开时调用
//	 */
//	@Override
//	public void sessionOpened(IoSession session) throws Exception
//	{
//
//		logs.info("服务器打开了的连接，Session ID为" + session.getRemoteAddress() + session.getId());
//		SocketAddress remoteAddress = (SocketAddress) session.getRemoteAddress();
//		if (remoteAddress != null)
//		{
//			String clientIp = remoteAddress.toString();
//			// 判断连接的ip是否为空
//			sessionMap.add(clientIp, session);
//			int port = 0;
//			String Ip = null;
//			String id = null;
//
//			String[] ipPortString = clientIp.split(":");
//			String IP = ipPortString[0];
//
//			String[] ip = IP.split("/");
//			port = Integer.valueOf(ipPortString[1]);
//			Ip = ip[1];
//			// }
////			SimpleDateFormat Sdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			// 查找集中器ID
////			String sqlcx = "select  id from k_jzqb5 where jzqip='" + Ip + "'";// jzqnet
////			ps = connc.prepareStatement(sqlcx);// 执行语句
////			rst = ps.executeQuery(); // 结果
////			int col = rst.getMetaData().getColumnCount();
////			while (rst.next()) // 遍历结果集
////			{
////				id = rst.getString("id");
////			}
////
////			// 如果集中器ID不为空
////			if (id != null)
////			{
////				String jzqip = null;
////				String jzqnet = null;
////				jzqService.updateIpPort(jzqip, jzqport, jzqnet);
////
////				String sql = "update k_jzqb5 set jzqport='" + port + "',UpdateTime='" + time + "' where jzqip='" + Ip
////						+ "'";
////				ps = connc.prepareStatement(sql);
////				rs = ps.executeUpdate();
//			}
////			DatabaseUtil.close(rst, ps, connc); // 关闭连接对象
////		}
//	}
//
//	/**
//	 * 当实现IOHandlerer的类抛出异常时调用
//	 */
//
//	@Override
//	public void exceptionCaught(IoSession session, Throwable cause) throws Exception
//	{
//		cause.printStackTrace();
//		logs.info("{}出现异常{}" + session.getRemoteAddress() + cause);
//		sessionMap.remove(session);
//	}
//
//	/**
//	 * 当接受了一个消息时调用
//	 */
//	@Override
//	public void messageReceived(IoSession session, Object message)
//	{
//		byte[] base = (byte[]) message;
//		String stringMR = Utils.bytesToHexString(base);
//		String md = null;
//		System.out.println("------stringMR--接收数据----" + stringMR);
//		// 接收数据不能为空并且长度大于15
//				md = stringMR.substring(4, 6);
//			System.out.println("md-----"+md);
//			if(md.equals("a5")){//新抄表返回数据
//				SocketAddress remoteAddress = (SocketAddress) session.getRemoteAddress();
//				String clientIp = remoteAddress.toString();
//				Xcb(stringMR, clientIp, session);
//			}else if (md.equals("a1"))
//			{
//				SocketAddress remoteAddress = (SocketAddress) session.getRemoteAddress();
//				String clientIp = remoteAddress.toString();
//				// 接收数据
//				String stringH = Utils.bytesToHexString(base);
//				String cd=stringH.substring(2,4);
//				if(cd.equals("10")){
//					xkg(stringH);//新电脑开关接收数据
//				}else{
//					// 对某一户的单个风盘
//					sbfs(stringH,clientIp,session);
//				}
//				
//			}else if (md.equals("a2"))
//			{
//				Xwxfh( stringMR);// X微信开关接收数据
//			}
//
//			if (md.equals("0c"))// 查询集中器状态
//			{
//				SocketAddress remoteAddress = (SocketAddress) session.getRemoteAddress();
//				String clientIp = remoteAddress.toString();
//				jzqCx(stringMR,  clientIp);
//			}
//			else if (md.equals("0a"))
//			{// 对某一户的所有风盘返回
//				SF(stringMR);
//			}
//			else if (md.equals("f0"))
//			{
//				wxkg(stringMR); // 所有接收微信数据并转发设备指令
//			} else if (md.equals("a3"))
//			{
//				SocketAddress remoteAddress = (SocketAddress) session.getRemoteAddress();
//				String clientIp = remoteAddress.toString();
//				wxfh(stringMR,clientIp, session);// 微信接收数据
//			}
//		}
//	
//	public void jzqCx(String stringHandler, String clientIp)
//	{
//		logs.info("集中器查询状态接收数据：" + stringHandler);
//
//		String[] ipPortString = clientIp.split(":");
//		String IP = ipPortString[0];
//
//		String[] ip = IP.split("/");
//		Integer port = Integer.valueOf(ipPortString[1]);
//		String Ip = ip[1];
//
//		// 截取jzqnet
//		String jzqnet = stringHandler.substring(6, 8);
//
//		// 截取效验数据
//		String jy = CzUtil.getJy(stringHandler);
//		// 判断开始和结束
//		String start = null;
//		String end = null;
//		start = stringHandler.charAt(0) + "" + stringHandler.charAt(1);
//		end = stringHandler.charAt(stringHandler.length() - 2) + "" + stringHandler.charAt(stringHandler.length() - 1);
//		String je = CzUtil.getJe(stringHandler);
//		System.out.println("前面数据相加je---------" + je);
//		System.out.println("校验数据jy-----" + jy);
//		if (start.equals("f0") && end.equals("ff") && je.equals("" + jy + ""))// 开始F0
//																				// 结束FF校验数据3A
//		{
//			// 根据集中器IP和端口号查找集中器ID
//			// 如果集中器ID不为空
//				jzqService.updateIpPort(Ip, port, jzqnet);
//				logs.info("集中器查询状态成功接收数据：" + stringHandler);
//		}
//	}
//
//	private void Xcb(String stringH, String clientIp,IoSession session)
//	{
//		
//		logs.info("X中央空调抄表接收数据：" + stringH);
//		System.out.println("接收数据长度---"+stringH.length());
//		String[] ipPortString = clientIp.split(":");
//		String IP = ipPortString[0];
//
//		String[] ip = IP.split("/");
//		Integer port = Integer.valueOf(ipPortString[1]);
//		String Ip = ip[1];
//		// 截取效验数据
//		String jy = CzUtil.getJy(stringH);
//		
//
//		// 判断开始和结束
//		String start = null;
//		String end = null;
//		start = stringH.charAt(0) + "" + stringH.charAt(1);
//		end = stringH.charAt(stringH.length() - 2) + "" + stringH.charAt(stringH.length() - 1);
//
//		// 判断和校验
//		String je = CzUtil.getJe(stringH);
//		System.out.println("----------je-----" + je);
//		System.out.println("---------jy------" + jy);
//
//		if (start.equals("f0") && end.equals("ff") && je.equals(jy))
//		{
//		//用户编号
//		String yhbh=stringH.substring(18, 24);
//		String yhbhs = String.valueOf(Integer.parseInt(yhbh, 16));
//		//风盘地址
//		String fpdz=stringH.substring(24,26);
//		String fpdzs = String.valueOf(Integer.parseInt(fpdz, 16));
//		if(fpdzs.length()==1){
//			fpdzs="0"+fpdzs;
//		}
//		
//		// 根据用户编码和风盘地址查找用户
//		Data findData = dataService.findData(yhbhs, fpdzs);
//	
//		//开关
//		String kg=stringH.substring(26,28);
//		 if(kg.equals("ff")){
//			kg=findData.getKg();
//		}
//		//计费
//		String jf=stringH.substring(28,30);
//		 if(jf.equals("ff")){
//				jf=findData.getKg();
//			}
//		//季节
//		String jj=stringH.substring(30,32);
//		if(jj.equals("ff")){
//			jj=findData.getJj();
//		}
//		//制冷高档时间
//		String zlgdTime=String.valueOf(jsMin(Integer.parseInt(stringH.substring(32,38),16)));
//		//制冷中档时间
//		String zlzdTime=String.valueOf( jsMin(Integer.parseInt(stringH.substring(38,44),16)));
//		//制冷抵挡时间
//		String zlddTime= String.valueOf(jsMin(Integer.parseInt(stringH.substring(44,50),16)));
//		//制热高档时间
//		String zrgdTime=String.valueOf( jsMin(Integer.parseInt(stringH.substring(50,56),16)));
//		//制热中档时间
//		String zrzdTime=String.valueOf( jsMin(Integer.parseInt(stringH.substring(56,62),16)));
//		//制热抵挡时间
//		String zrddTime=String.valueOf( jsMin(Integer.parseInt(stringH.substring(62,68),16)));
//		//模式
//		String ms=stringH.substring(68,70);
//		if (ms.equals("ff"))
//		{
//			ms = findData.getMs();
//		}
//		//档位
//		String dw=stringH.substring(70,72);
//		if (dw.equals("ff"))
//		{
//			dw = findData.getDw();
//		}
//		//设定温度
//		String sdwd=stringH.substring(72,74);
//
//		if (sdwd.equals("ff"))
//		{
//			sdwd = findData.getSdwd();
//		}else{
//		    sdwd = Integer.parseInt( sdwd, 16)+"";
//		}
//		//室内温度
//		String snwd=stringH.substring(74,76);
//		
//		if (snwd.equals("ff"))
//		{
//			snwd = findData.getSnwd();
//		}else{
//			snwd = Integer.parseInt( snwd, 16)+"";
//		}
//		//报警
//		String bj=stringH.substring(76,78);
//		Date now = new Date();
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String time = dateFormat.format(now);
//		Data data = new Data();
//		data.setGdtime(zlgdTime);
//		data.setZdtime(zlzdTime);
//		data.setDdtime(zlddTime);
//		data.setDgdtime(zrgdTime);
//		data.setDzdtime(zrzdTime);
//		data.setDddtime(zrddTime);
//		data.setJf(jf);
//		data.setMs(ms);
//		data.setSdwd(sdwd);
//		data.setDw(dw);
//		data.setSnwd(snwd);
//		data.setBj(bj);
//		data.setTime(time);
//		data.setKg(kg);
//		data.setJj(jj);
//		data.setYhbh(yhbhs);
//		data.setFpdz(fpdzs);
//		dataService.updateYhbhF(data);// 更新实时表
//		  //按流量计算价格
//		 FyFl price=fyFlService.byFyFl(2);
//		 double dlPrice=price.getDj(); // 获取流量单价
//		 double yh=price.getYh(); //获取优惠
//		 Data zyzbh=dataService.findZyydl(yhbhs);
//		 Double zyydl=zyzbh.getZyydl();
//		 String yzbh=zyzbh.getYzbh();
//			 //用户已用金额
//		 double yyje= zyydl*dlPrice*yh;
//		 Jf jfs=new Jf();
//		 jfs.setYyje(yyje);
//		 jfs.setGetime(time);
//		 jfs.setYydl(zyydl);
//		 jfs.setYzbh(yzbh);
//		 //-----------------------------
//		 jfServce.updateJf(jfs);
//		 // 根据实时表查找月份
//		 double yydl=findData.getYydl();
//	    int yf=zyzbh.getYf();
//		data.setYydl(yydl);
//		data.setYf(yf);
//		dataService.InsertYh(data);// 插入历史表
//		
//		//根据业主地址查抄剩余金额
//		Double syje=jfServce.selSyje(yzbh);
//		Data find = dataService.findData(yhbhs,fpdzs);
//		 if(syje<0){
//			 String ld =find.getYhMessage().getLdh();
//			 String dy=find.getYhMessage().getDyh();
//			 String cgbh =find.getYhMessage().getCgbh();
//		     String xqh=find.getYhMessage().getXqh();
//			 if(ld.length()==1){
//					ld=0+ld;
//				}
//				if(dy.length()==1){
//					dy=0+dy;
//				}
//			String cg=cgbh.substring(4);
//			//发送关阀指令
//		    String ja =ld+dy+"F014B1"+xqh+ld+"00"+ld+dy+cg+yhbh+fpdz+"00FFFFFFFF";
//			logs.info("X中央空调抄表接收数据,用户编码"+yhbh+"风盘地址"+fpdzs+"欠费发送关闭指令"+ja);
//			 // 解码
//			boolean sessionmap = cz(ja, clientIp);
//			if(sessionmap==false){
//			try
//			{
//				Thread.sleep(2000);
//			} catch (InterruptedException e)
//			{
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			 // 解码
//			sessionmap= cz(ja, clientIp);
//			if(sessionmap==false){
//				cz(ja, clientIp);
//			}
//			}
//		 }
//
//		 logs.info("X中央空调抄表接收数据成功");
//			if(null!=MapUtilsDf.getMapUtils().get("fs")&&MapUtilsDf.getMapUtils().get("fs").equals(yhbhs+fpdzs)){
//				MapUtilsDf.getMapUtils().add("state",yhbhs+fpdzs);
//			}
//		
//	} else if (stringH.length() >= 168)
//	{
//		String[] str = stringH.split("f02aa5");
//		for (int i = 0; i < str.length; i++)
//		{
//			String iString = "f02aa5" + str[i];
//			System.out.println(iString.length());
//			if (iString.length()==84)
//			{
//				XCb(iString,Ip,port, clientIp, session);
//			}
//
//		}
//
//	}
//}
//	
//	
//	private void sbfs(String stringHandler, String clientIp,IoSession session)
//	{
//		
//		logs.info("L中央空调接收数据：" +stringHandler);
//		System.out.println(stringHandler.length());
//		String[] ipPortString = clientIp.split(":");
//		String IP = ipPortString[0];
//
//		String[] ip = IP.split("/");
//		Integer port = Integer.valueOf(ipPortString[1]);
//		String Ip = ip[1];
//
//		// 截取效验数据
//		String jy = CzUtil.getJy(stringHandler);
//
//		// 判断开始和结束
//		String start = null;
//		String end = null;
//		start = stringHandler.charAt(0) + "" + stringHandler.charAt(1);
//		end = stringHandler.charAt(stringHandler.length() - 2) + "" + stringHandler.charAt(stringHandler.length() - 1);
//
//		// 判断和校验
//		String je = CzUtil.getJe(stringHandler);
//		System.out.println("----------je-----" + je);
//		System.out.println("---------jy------" + jy);
//
//		if (start.equals("f0") && end.equals("ff") && je.equals("" + jy + ""))
//		{
//			// 用户编码
//			String yhbh = stringHandler.substring(8, 14);
//			System.out.println("yhbh---------" + yhbh);
//			String yhbhS = String.valueOf(Integer.parseInt("" + yhbh + "", 16));
//			System.out.println("yhbhS---------" + yhbhS);
//
//			// 风盘地址
//			String fpidS = stringHandler.substring(14, 16);
//			System.out.println("fpidS-" + fpidS);
//			String fpdz = String.valueOf(Integer.parseInt(fpidS, 16));
//             if(fpdz.length()==1){
//            	 fpdz="0"+fpdz;
//             }
//			// 根据用户编码和风盘地址查找用户
//			Data findData = dataService.findData(yhbhS, fpdz);
//			if(findData!=null){
//			System.out.println("--fpid-" + fpdz);
//			// 风盘模式，00制冷01制热
//			String ms = stringHandler.substring(16, 18);
//
//			if (ms.equals("ff"))
//			{
//				ms = findData.getMs();
//			}
//			System.out.println("ms------" + ms);
//			// 档位
//			String dw = stringHandler.substring(18, 20);
//			if (dw.equals("ff"))
//			{
//				dw = findData.getDw();
//			}
//			System.out.println("dw------" + dw);
//			// 高档运行时间高 00停止 01低档 02中档03高档
//			double gdg = jsMin( Integer.parseInt(stringHandler.substring(20, 26), 16));
//			System.out.println("gdg------" + gdg);
//
//			// 中档运行时间
//			double zdS = jsMin(Integer.parseInt( stringHandler.substring(26, 32), 16));
//			System.out.println("zdS------" + zdS);
//			// 低档运行时间
//			double gdd = jsMin(Integer.parseInt(stringHandler.substring(32, 38), 16));
//			System.out.println("gdd------" + gdd);
//
//			// (制热)高档运行时间高 00停止 01低档 02中档03高档
//			double dgdg = jsMin(Integer.parseInt(stringHandler.substring(38, 44), 16));
//
//			// (制热)中档运行时间
//			double dzdS = jsMin(Integer.parseInt(stringHandler.substring(44, 50), 16));
//
//			// (制热)低档运行时间
//			double dgdd = jsMin(Integer.parseInt(stringHandler.substring(50, 56), 16));
//
//			// 计费模式 00计费01允许计费
//			String Jf = stringHandler.substring(56, 58);
//			if (Jf.equals("ff"))
//			{
//				Jf = findData.getJf();
//			}
//			System.out.println("计费模式-------" + Jf);
//
//			// 设定温度
//			String sdwS = stringHandler.substring(58, 60);
//			System.out.println("sdwS---" + sdwS);
//			if (sdwS.equals("ff"))
//			{
//				sdwS = findData.getSdwd();
//			}
//			int sdw = Integer.parseInt("" + sdwS + "", 16);
//			System.out.println("设定温度----------" + sdwS);
//
//			// 室内温度 实时温度
//			String swS = stringHandler.substring(60, 62);
//			System.out.println("swS---" + swS);
//			if (swS.equals("ff"))
//			{
//				swS = findData.getSnwd();
//			}
//			int sw = Integer.parseInt("" + swS + "", 16);
//
//			System.out.println("室内温度 --------" + swS);
//			System.out.println("室内温度十六进制" + sw);
//
//			// 远程开关
//			String kg = stringHandler.substring(62, 64);
//			System.out.println("kg---" + kg);
//			if (kg.equals("ff"))
//			{
//				kg = findData.getKg();
//			}
//			System.out.println("远程开关-----------" + kg);// FF
//
//			// 报警
//			String bjs = stringHandler.substring(64, 66);
//			System.out.println("bjs---" + bjs);
//			if (bjs.equals("ff"))
//			{
//				bjs = findData.getBj();
//			}
//			System.out.println("报警信息 --------" + bjs);
//
//			// 季节
//			String jj = stringHandler.substring(66, 68);
//			System.out.println("jj---" + jj);
//			if (jj.equals("ff"))
//			{
//				jj = findData.getJj();
//			}
//			System.out.println("季节 --------" + jj);
//			String  jzqId=stringHandler.substring(74,76);
//			if(jzqId.equals("ff")){
//				jzqId="01";
//			}
//			jzqService.updateIpPort(Ip, port, jzqId);
//			// 转换为时间格式 方便地修改日期格式
//			Date now = new Date();
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			String time = dateFormat.format(now);
//			Data data = new Data();
//			String gdString = String.valueOf(gdg);
//			String ztString = String.valueOf(zdS);
//			String gddString = String.valueOf(gdd);
//			String dgdgString = String.valueOf(dgdg);
//			String dgzgString = String.valueOf(dzdS);
//			String dgddString = String.valueOf(dgdd);
//			String sdwString = String.valueOf(sdw);
//			String swString = String.valueOf(sw);
//			data.setGdtime(gdString);
//			data.setZdtime(ztString);
//			data.setDdtime(gddString);
//			data.setDgdtime(dgdgString);
//			data.setDzdtime(dgzgString);
//			data.setDddtime(dgddString);
//			data.setJf(Jf);
//			data.setMs(ms);
//			data.setSdwd(sdwString);
//			data.setDw(dw);
//			data.setSnwd(swString);
//			data.setBj(bjs);
//			data.setTime(time);
//			data.setKg(kg);
//			data.setJj(jj);
//			data.setYhbh(yhbhS);
//			data.setFpdz(fpdz);
//			dataService.updateYhbhF(data);// 更新实时表
//
//			 //按流量计算价格
//			 FyFl price=fyFlService.byFyFl(2);
//			 double dlPrice=price.getDj(); // 获取流量单价
//			 double yh=price.getYh(); //获取优惠
//			 Data zyzbh=dataService.findZyydl(yhbhS);//获取总已用当量，和月份，业主编号
//			 Double zyydl=zyzbh.getZyydl();
//			 String yzbh=zyzbh.getYzbh();
//				 //用户已用金额
//			 double yyje= zyydl*dlPrice*yh;
//			 Jf jfs=new Jf();
//			 jfs.setYyje(yyje);
//			 jfs.setGetime(time);
//			 jfs.setYydl(zyydl);
//			 jfs.setYzbh(yzbh);
//			 //-----------------------------
//			 jfServce.updateJf(jfs);
//			
//			// 更新实时表已用当量
//			double yydl=findData.getYydl();
//		    int yf=zyzbh.getYf();
//			data.setYydl(yydl);
//			data.setYf(yf);
//			dataService.InsertYh(data);// 插入历史表
//			Data find = dataService.findYh(yhbhS, Integer.valueOf(fpdz));
//			//根据业主地址查抄剩余金额
//			Double syje=jfServce.selSyje(yzbh);
//			 if(syje<0){
//				 String ld =find.getYhMessage().getLdh();
//				 String dy=find.getYhMessage().getDyh();
//				 String cgbh =find.getYhMessage().getCgbh();
//				
//				 if(ld.length()==1){
//						ld=0+ld;
//					}
//					if(dy.length()==1){
//						dy=0+dy;
//					}
//				String cg=cgbh.substring(4);
//			    String ja =ld+dy+"F010B1"+cg+""+yhbh+fpidS+"00FFFF"+ld+dy+"FF";
//				 // 解码
//				boolean sessionmap = cz(ja, clientIp);
//				if(sessionmap==false){
//				try
//				{
//					Thread.sleep(2000);
//				} catch (InterruptedException e)
//				{
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				 // 解码
//				boolean sessionmap1 = cz(ja, clientIp);
//				if(sessionmap1==false){
//					try
//					{
//						Thread.sleep(2000);
//					} catch (InterruptedException e)
//					{
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					 // 解码
//					 sessionmap1 = cz(ja, clientIp);
//				}
//				}
//			 }
//			 
//				if(null!=MapUtilsDf.getMapUtils().get("fs")&&MapUtilsDf.getMapUtils().get("fs").equals(yhbhS+fpdz)){
//					MapUtilsDf.getMapUtils().add("state",yhbhS+fpdz);
//				}
//			
//		} 
//		}else if (stringHandler.length() >= 82)
//		{
//			String[] str = stringHandler.split("f029a1");
//			for (int i = 0; i < str.length; i++)
//			{
//				String iString = "f029a1" + str[i];
//				System.out.println(iString.length());
//				if (iString.length() == 82)
//				{
//					LCb(iString,Ip,port, clientIp, session);
//				}
//		   }
//		}
//	}
//	
//	
//	  // 抽取相同部分
//			public boolean cz(String ja, String pt) {
//				// 把十六进制数，转换为十进制相加
//				int jia = CzUtil.FsZh(ja);
//				// 十进制转换为十六进制
//				String hex = Integer.toHexString(jia);
//				// 截取相加结果后两位
//				String je = null;
//				for (int j = 0; j < hex.length() - 1; j++) {
//					je = hex.charAt(hex.length() - 2) + "" + hex.charAt(hex.length() - 1);
//				}
//				String[] keys = new String[] { pt };
//				String mString =ja+je+"FF";
//				logs.info("StringHandler指令发送---------------"+mString);
//				// 解码
//				byte[] b = CzUtil.jm(mString);
//				ServerSessionMap sessionMap = ServerSessionMap.getInstance();
//				boolean sessionmap = sessionMap.sendMessage(keys, b);
//				return sessionmap;
//			}
//	
//	private void wxfh(String stringHandler,String clientIp,IoSession session)
//	{
//		logs.info("中央空调微信接收数据：" +stringHandler);
//		System.out.println("微信长度---"+stringHandler.length());
//		String[] ipPortString = clientIp.split(":");
//		String IP = ipPortString[0];
//
//		String[] ip = IP.split("/");
//		Integer port = Integer.valueOf(ipPortString[1]);
//		String Ip = ip[1];
//		// 接收数据
////		String stringHandler = Utils.bytesToHexString(base);
//		// 转换为大写
////		String stringHandler = CzUtil.Uppercase(stringH).toString();
//		// 截取效验数据
//		String jy = CzUtil.getJy(stringHandler);
//
//		// 判断开始和结束
//		String start = null;
//		String end = null;
//		start = stringHandler.charAt(0) + "" + stringHandler.charAt(1);
//		end = stringHandler.charAt(stringHandler.length() - 2) + "" + stringHandler.charAt(stringHandler.length() - 1);
//
//		// 判断和校验
//		String je = CzUtil.getJe(stringHandler);
//		System.out.println("----------je-----" + je);
//		System.out.println("---------jy------" + jy);
//
//		if (start.equals("f0") && end.equals("ff") && je.equals(jy))
//		{
//			// 用户编码
//			String yhbh = stringHandler.substring(8, 14);
//			System.out.println("yhbh---------" + yhbh);
//			String yhbhS = String.valueOf(Integer.parseInt(yhbh, 16));
//			System.out.println("yhbhS---------" + yhbhS);
//			// 风盘地址
//			String fpidS = stringHandler.substring(14, 16);
//			System.out.println("fpidS-" + fpidS);
//			String fpid = String.valueOf(Integer.parseInt(fpidS, 16));
//             if(fpid.length()==1){
//            	 fpid="0"+fpid;
//             }
//			// 风盘地址
//			// String fpid = stringHandler.substring(14, 16);
////			Integer fpdz = Integer.valueOf(fpid);
//			// 根据用户编码和风盘地址查找用户
//			Data findData = dataService.findData(yhbhS, fpid);
//			if(findData!=null){
//			System.out.println("--fpid-" + fpid);
//			// 风盘模式，00制冷01制热
//			String ms = stringHandler.substring(16, 18);
//
//			if (ms.equals("FF"))
//			{
//				ms = findData.getMs();
//			}
//			System.out.println("ms------" + ms);
//			// 档位
//			String dw = stringHandler.substring(18, 20);
//			if (dw.equals("FF"))
//			{
//				dw = findData.getDw();
//			}
//			System.out.println("dw------" + dw);
//			// 高档运行时间高 00停止 01低档 02中档03高档
//			String gdgS = stringHandler.substring(20, 26);
//			System.out.println("gdgS-" + gdgS);
//			int gdgJS = Integer.parseInt("" + gdgS + "", 16);
//			System.out.println(gdgJS);
//			double gdg = jsMin(gdgJS);
//			System.out.println("gdg------" + gdg);
//			// 中档运行时间
//			String zdSS = stringHandler.substring(26, 32);
//
//			int zdSJS = Integer.parseInt("" + zdSS + "", 16);
//			double zdS = jsMin(zdSJS);
//			System.out.println("zdS------" + zdS);
//			// 低档运行时间
//			String gddS = stringHandler.substring(32, 38);
//
//			int gddJS = Integer.parseInt("" + gddS + "", 16);
//			double gdd = jsMin(gddJS);
//			System.out.println("gdd------" + gdd);
//
//			// (制热)高档运行时间高 00停止 01低档 02中档03高档
//			String dgdgS = stringHandler.substring(38, 44);
//			int dgdgSD = Integer.parseInt("" + dgdgS + "", 16);
//			double dgdg = jsMin(dgdgSD);
//
//			// (制热)中档运行时间
//			String dzdSS = stringHandler.substring(44, 50);
//			int dzdSJS = Integer.parseInt("" + dzdSS + "", 16);
//			double dzdS = jsMin(dzdSJS);
//
//			// (制热)低档运行时间
//			String dgddS = stringHandler.substring(50, 56);
//			int dgddJS = Integer.parseInt("" + dgddS + "", 16);
//			double dgdd = jsMin(dgddJS);
//
//			// 计费模式 00计费01允许计费
//			String Jf = stringHandler.substring(56, 58);
//			System.out.println("Jf-------------" + Jf);
//			if (Jf.equals("FF"))
//			{
//				Jf = findData.getJf();
//			}
//			System.out.println("计费模式-------" + Jf);
//
//			// 设定温度
//			String sdwS = stringHandler.substring(58, 60);
//			System.out.println("sdwS-------------" + sdwS);
//			if (sdwS.equals("FF"))
//			{
//				sdwS = findData.getSdwd();
//			}
//			int sdw = Integer.parseInt("" + sdwS + "", 16);
//			System.out.println("设定温度----------" + sdwS);
//
//			// 室内温度 实时温度
//			String swS = stringHandler.substring(60, 62);
//			System.out.println("swS-------------" + swS);
//			if (swS.equals("FF"))
//			{
//				swS = findData.getSnwd();
//			}
//			int sw = Integer.parseInt("" + swS + "", 16);
//
//			System.out.println("室内温度 --------" + swS);
//
//			// 远程开关
//			String kg = stringHandler.substring(62, 64);
//			System.out.println("远程开关-----------" + kg);// FF
//			if (kg.equals("FF"))
//			{
//				kg = findData.getKg();
//			}
//			System.out.println("远程开关-----------" + kg);// FF
//			System.out.println("kg-------------" + kg);
//			// 报警
//			String bjs = stringHandler.substring(64, 66);
//			System.out.println("远程开关-----------" + bjs);// FF
//			if (bjs.equals("FF"))
//			{
//				bjs = findData.getBj();
//			}
//			System.out.println("报警信息 --------" + bjs);
//
//			// 季节
//			String jj = stringHandler.substring(66, 68);
//			if (jj.equals("FF"))
//			{
//				jj = findData.getJj();
//			}
//			System.out.println("季节 --------" + jj);
//			String  jzqId=stringHandler.substring(74,76);
//			if(jzqId.equals("FF")){
//				jzqId="01";
//			}
//			jzqService.updateIpPort(Ip, port, jzqId);
//			// 转换为时间格式 方便地修改日期格式
//			Date now = new Date();
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			String time = dateFormat.format(now);
//			Data data = new Data();
//			String gdString = String.valueOf(gdg);
//			String ztString = String.valueOf(zdS);
//			String gddString = String.valueOf(gdd);
//			String dgdgString = String.valueOf(dgdg);
//			String dgzgString = String.valueOf(dzdS);
//			String dgddString = String.valueOf(dgdd);
//			String sdwString = String.valueOf(sdw);
//			String swString = String.valueOf(sw);
//			data.setGdtime(gdString);
//			data.setZdtime(ztString);
//			data.setDdtime(gddString);
//			data.setDgdtime(dgdgString);
//			data.setDzdtime(dgzgString);
//			data.setDddtime(dgddString);
//			data.setJf(Jf);
//			data.setMs(ms);
//			data.setSdwd(sdwString);
//			data.setDw(dw);
//			data.setSnwd(swString);
//			data.setBj(bjs);
//			data.setTime(time);
//			data.setKg(kg);
//			data.setJj(jj);
//			data.setYhbh(yhbhS);
//			data.setFpdz(fpid);
//			dataService.updateYhbhF(data);// 更新实时表
//			//按流量计算价格
//			 FyFl price=fyFlService.byFyFl(2);
//			 double dlPrice=price.getDj(); // 获取流量单价
//			 double yh=price.getYh(); //获取优惠
//			 Data zyzbh=dataService.findZyydl(yhbhS);//获取总已用当量，和月份，业主编号
//			 Double zyydl=zyzbh.getZyydl();
//			 String yzbh=zyzbh.getYzbh();
//				 //用户已用金额
//			 double yyje= zyydl*dlPrice*yh;
//			 Jf jfs=new Jf();
//			 jfs.setYyje(yyje);
//			 jfs.setGetime(time);
//			 jfs.setYydl(zyydl);
//			 jfs.setYzbh(yzbh);
//			 //-----------------------------
//			 jfServce.updateJf(jfs);
//			// 根据实时表查找月份
//			double yydl=findData.getYydl();
//		    int yf=zyzbh.getYf();
//			data.setYydl(yydl);
//			data.setYf(yf);
//			dataService.InsertYh(data);// 插入历史表 
//			Data find = dataService.findYh(yhbhS, Integer.valueOf(fpid));
//			//根据业主地址查抄剩余金额
//			Double syje=jfServce.selSyje(yzbh); 
//			 
//			 if(syje<0){
//				 String ld =find.getYhMessage().getLdh();
//				 String dy=find.getYhMessage().getDyh();
//				 String cgbh =find.getYhMessage().getCgbh();
//				
//				 if(ld.length()==1){
//						ld=0+ld;
//					}
//					if(dy.length()==1){
//						dy=0+dy;
//					}
//				String cg=cgbh.substring(4);
//			    String ja =ld+dy+"F010B1"+cg+""+yhbh+fpidS+"00FFFF"+ld+dy+"FF";
//				 // 解码
//				boolean sessionmap = cz(ja, clientIp);
//				if(sessionmap==false){
//				try
//				{
//					Thread.sleep(2000);
//				} catch (InterruptedException e)
//				{
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				 // 解码
//				  cz(ja, clientIp);
//				}
//			 }
//		     }
//			}
//			else if (stringHandler.length() > 82)
//		{
//			String[] str = stringHandler.split("f029a3");
//			for (int i = 0; i < str.length; i++)
//			{
//				String iString = "f029a3" + str[i];
//				System.out.println(iString.length());
//				if (iString.length() == 82)
//				{
//					LCb(iString, Ip, port, clientIp, session);
//				}
//
//			}
//		}
//	}
//	private void wxkg(String stringHandler)
//	{
//		String fpdzS;
//		boolean sessionmap = false;
//		logs.info("中央空调app微信开关转发接收数据---------------------------：" + stringHandler);
//		// 接收数据
////		String stringHandler = Utils.bytesToHexString(base);
//		// 截取效验数据
//		String jy = CzUtil.getJy(stringHandler);
//
//		// 判断开始和结束
//		String start = null;
//		String end = null;
//		String yhbm;
//		 String fpdz;
//		start = stringHandler.charAt(4) + "" + stringHandler.charAt(5);
//		end = stringHandler.charAt(stringHandler.length() - 2) + "" + stringHandler.charAt(stringHandler.length() - 1);
//
//		// 判断和校验
//		String je = CzUtil.getJeS(stringHandler);
//		System.out.println("----------je-----" + je);
//		System.out.println("---------jy------" + jy);
//
//		if (start.equals("f0") && end.equals("ff") && je.equals("" + jy + ""))
//		{
//			String cd=stringHandler.substring(6,8);
//			if(cd.equals("14")){
//				// 用户编码
//				 yhbm = stringHandler.substring(20, 26);
//				//风盘地址
//				  fpdz=stringHandler.substring(26,28);
//			}else{
//			// 用户编码
//			 yhbm = stringHandler.substring(12, 18);
//			//风盘地址
//			  fpdz=stringHandler.substring(18,20);
//			}
//			int yhm = Integer.parseInt(yhbm, 16);
//			String yhString = String.valueOf(yhm);
//			System.out.println("--yh--" + yhString);
//			YhMessage yhmess = yhMessageService.findJzq(yhString);
//			String ip = yhmess.getJzqip();
//			String port = yhmess.getJzqport();
//			// IP地址和端口号
//			String pt = "/" + ip + ":" + port;
//			 String fpid = String.valueOf(Integer.parseInt(fpdz, 16));
////			Integer fp=Integer.valueOf(fpid);
//			if(fpid.length()<2){
//				fpdzS="0"+fpid;//16进制   
//			}else{
//				fpdzS=fpid;
//			}
//
//			logs.info("微信接收数据+pt：" + pt);
//			logs.info("微信接收数据：" + stringHandler);
//
//			System.out.println("pt-------------" + pt);
//			String[] keys = new String[]{ pt };
//			System.out.println("------stringHandler----" + stringHandler);
//			String xqh=yhmess.getXqh();
//			
//			if(xqh!=null&& xqh!=""){
//				
//				
//			String ld=stringHandler.substring(0,2);
//			String dy=stringHandler.substring(2,4);
//			String ch=stringHandler.substring(10,12);
//			String ms=stringHandler.substring(20,22);//档位
//			String kg=stringHandler.substring(22,24);//风速
//			String wd=stringHandler.substring(24,26);
//			String ja=ld+dy+"F014B2"+xqh+ld+"00"+ld+dy+ch+yhbm+fpdz+ms+kg+wd+"FFFF";		
//			System.out.println("------Xkg转发----" + ja);	
//			// 把十六进制数，转换为十进制相加
//			int jia = CzUtil.FsZh(ja);
//			// 十进制转换为十六进制
//			String hex = Integer.toHexString(jia);
//			// 截取相加结果后两位
//			 je = null;
//			 je = hex.charAt(hex.length() - 2) + "" + hex.charAt(hex.length() - 1);
//			keys = new String[] { pt };
//			String mString =ja+je+"FF";
//			logs.info("StringHandler指令发送---------------"+mString);
//			// 解码
//			byte[] b = CzUtil.jm(mString);
//			ServerSessionMap sessionMap = ServerSessionMap.getInstance();
//			 sessionmap = sessionMap.sendMessage(keys, b);
//			// 根据用户编码和风盘地址查找用户
//			Data findData = dataService.findData(yhString, fpdzS);
//		    //发送成功 
//			if(sessionmap==true){
//				
//				jszl.setYhbh(yhString);
//				jszl.setFpdz(fpdzS);
//				if(kg.equals("FF")){
//					jszl.setKg(findData.getKg()); //风速
//				}else{
//					jszl.setKg(kg);
//				}
//			    if(ms.equals("FF")){ //制冷，制热
//			    	jszl.setDw(findData.getDw());
//			    }else{
//			    	jszl.setYhbh(ms);
//			    }
//				if(wd.equals("FF")){
//					jszl.setSdwd(findData.getSdwd());
//				}else{
//					jszl.setJf(wd);
//				}
//				dataService.updateSbJs(jszl);
//				
//		     }else{
//		    		try
//					{
//						Thread.sleep(2000);
//					} catch (InterruptedException e)
//					{
//						e.printStackTrace();
//					}	
//		    		sessionmap=	sessionMap.sendMessage(keys, b);
//					
//					if(sessionmap==true){
//						
//						// 根据用户编码和风盘地址查找用户
////						Data findData = dataService.findData(yhString, fpdzS);
//						jszl.setYhbh(yhString);
//						jszl.setFpdz(fpdz);
//						if(kg.equals("FF")){
//							jszl.setKg(findData.getKg());
//						}else{
//							jszl.setKg(kg);
//						}
//					    if(ms.equals("FF")){
//					    	jszl.setDw(findData.getDw());
//					    }else{
//					    	jszl.setYhbh(ms);
//					    }
//						if(wd.equals("FF")){
//							jszl.setSdwd(findData.getSdwd());
//						}else{
//							jszl.setJf(wd);
//						}
//						dataService.updateSbJs(jszl);	
//						
//						
//					}else{
//						try
//						{
//							Thread.sleep(2000);
//						} catch (InterruptedException e)
//						{
//							e.printStackTrace();
//						}	
//						sessionmap=sessionMap.sendMessage(keys, b);
//						if(sessionmap==true){
//							
//							// 根据用户编码和风盘地址查找用户
////							Data findData = dataService.findData(yhString, fpdzS);
//							jszl.setYhbh(yhString);
//							jszl.setFpdz(fpdz);
//							if(kg.equals("FF")){
//								jszl.setKg(findData.getKg());
//							}else{
//								jszl.setKg(kg);
//							}
//						    if(ms.equals("FF")){
//						    	jszl.setDw(findData.getDw());
//						    }else{
//						    	jszl.setYhbh(ms);
//						    }
//							if(wd.equals("FF")){
//								jszl.setSdwd(findData.getSdwd());
//							}else{
//								jszl.setJf(wd);
//							}
//							dataService.updateSbJs(jszl);	
//							
//							
//						}
//					}
//		     }
//				
//			}else{
//				
//				// 解码
//				byte[] b = CzUtil.jm(stringHandler);
//				ServerSessionMap sessionMap = ServerSessionMap.getInstance();
//				sessionmap=sessionMap.sendMessage(keys, b);
//				if(sessionmap==false){
//				try
//				{
//					Thread.sleep(2000);
//				} catch (InterruptedException e)
//				{
//					e.printStackTrace();
//				}
//
//				sessionmap=sessionMap.sendMessage(keys, b);
//				
//				if(sessionmap==false){
//				
//				try
//				{
//					Thread.sleep(2000);
//				} catch (InterruptedException e)
//				{
//					e.printStackTrace();
//				}
//				sessionmap=sessionMap.sendMessage(keys, b);
//				if(sessionmap==false){
//					sessionMap.sendMessage(keys, b);
//				 }
//			    }
//			   }
//			}
//		}
//	}
//
//	public void Xwxfh(String stringHandler)
//	{
//		logs.info("X开关接收数据：" +stringHandler);
//
//		// 截取效验数据
//		String jy = CzUtil.getJy(stringHandler);
//		// 判断开始和结束
//		String start = null;
//		String end = null;
//		start = stringHandler.charAt(0) + "" + stringHandler.charAt(1);
//		end = stringHandler.charAt(stringHandler.length() - 2) + "" + stringHandler.charAt(stringHandler.length() - 1);
//		String je = CzUtil.getJe(stringHandler);
//		System.out.println("前面数据相加je---------" + je);
//		System.out.println("校验数据jy-----" + jy);
//		if (start.equals("f0") && end.equals("ff") && je.equals("" + jy + ""))// 开始F0
//																				// 结束FF校验数据3A
//		{
//			System.out.println("新接收数据成功-----------");  
//		}
//	}
//	public void xkg(String stringHandler)
//	{
//		logs.info("X开关接收数据：" + stringHandler);
//
//		// 截取效验数据
//		String jy = CzUtil.getJy(stringHandler);
//		// 判断开始和结束
//		String start = null;
//		String end = null;
//		start = stringHandler.charAt(0) + "" + stringHandler.charAt(1);
//		end = stringHandler.charAt(stringHandler.length() - 2) + "" + stringHandler.charAt(stringHandler.length() - 1);
//		String je = CzUtil.getJe(stringHandler);
//		System.out.println("前面数据相加je---------" + je);
//		System.out.println("校验数据jy-----" + jy);
//		if (start.equals("f0") && end.equals("ff") && je.equals("" + jy + ""))// 开始F0
//																				// 结束FF校验数据3A
//		{
//			
//			String yhbh= String.valueOf(Integer.parseInt(stringHandler.substring(18,24), 16));
//			String fpdz= String.valueOf(Integer.parseInt(stringHandler.substring(24,26), 16));
//			if(fpdz.length()==1){
//				fpdz="0"+fpdz;
//			}
//		    //更新用户开关
//		    
//			if(null!=MapUtilsDf.getMapUtils().get("fs")&&MapUtilsDf.getMapUtils().get("fs").equals(yhbh+fpdz)){
//				MapUtilsDf.getMapUtils().add("state",yhbh+fpdz);
//				
//			}  
//		}
//	}
//	public void LCb(String stringHandler,String Ip,Integer port, String clientIp,IoSession session)
//	{
//		// 截取效验数据
//				String jy = CzUtil.getJy(stringHandler);
//
//				// 判断开始和结束
//				String start = null;
//				String end = null;
//				start = stringHandler.charAt(0) + "" + stringHandler.charAt(1);
//				end = stringHandler.charAt(stringHandler.length() - 2) + "" + stringHandler.charAt(stringHandler.length() - 1);
//
//				// 判断和校验
//				String je = CzUtil.getJe(stringHandler);
//				System.out.println("----------je-----" + je);
//				System.out.println("---------jy------" + jy);
//
//				if (start.equals("f0") && end.equals("ff") && je.equals("" + jy + ""))
//				{
//					// 用户编码
//					String yhbh = stringHandler.substring(8, 14);
//					System.out.println("yhbh---------" + yhbh);
//					String yhbhS = String.valueOf(Integer.parseInt("" + yhbh + "", 16));
//					System.out.println("yhbhS---------" + yhbhS);
//
//					// 风盘地址
//					String fpidS = stringHandler.substring(14, 16);
//					System.out.println("fpidS-" + fpidS);
//					String fpdz = String.valueOf(Integer.parseInt(fpidS, 16));
//					if(fpdz.length()==1){
//						fpdz="0"+fpdz;
//					}
//					// 根据用户编码和风盘地址查找用户
//					Data findData = dataService.findData(yhbhS, fpdz);
//					if(findData!=null){
//					System.out.println("--fpid-" + fpdz);
//					// 风盘模式，00制冷01制热
//					String ms = stringHandler.substring(16, 18);
//
//					if (ms.equals("ff"))
//					{
//						ms = findData.getMs();
//					}
//					System.out.println("ms------" + ms);
//					// 档位
//					String dw = stringHandler.substring(18, 20);
//					if (dw.equals("ff"))
//					{
//						dw = findData.getDw();
//					}
//					System.out.println("dw------" + dw);
//					// 高档运行时间高 00停止 01低档 02中档03高档
//					double gdg = jsMin( Integer.parseInt(stringHandler.substring(20, 26), 16));
//					System.out.println("gdg------" + gdg);
//
//					// 中档运行时间
//					double zdS = jsMin(Integer.parseInt( stringHandler.substring(26, 32), 16));
//					System.out.println("zdS------" + zdS);
//					// 低档运行时间
//					double gdd = jsMin(Integer.parseInt(stringHandler.substring(32, 38), 16));
//					System.out.println("gdd------" + gdd);
//
//					// (制热)高档运行时间高 00停止 01低档 02中档03高档
//					double dgdg = jsMin(Integer.parseInt(stringHandler.substring(38, 44), 16));
//
//					// (制热)中档运行时间
//					double dzdS = jsMin(Integer.parseInt(stringHandler.substring(44, 50), 16));
//
//					// (制热)低档运行时间
//					double dgdd = jsMin(Integer.parseInt(stringHandler.substring(50, 56), 16));
//
//					// 计费模式 00计费01允许计费
//					String Jf = stringHandler.substring(56, 58);
//					if (Jf.equals("ff"))
//					{
//						Jf = findData.getJf();
//					}
//					System.out.println("计费模式-------" + Jf);
//
//					// 设定温度
//					String sdwS = stringHandler.substring(58, 60);
//					System.out.println("sdwS---" + sdwS);
//					if (sdwS.equals("ff"))
//					{
//						sdwS = findData.getSdwd();
//					}
//					int sdw = Integer.parseInt("" + sdwS + "", 16);
//					System.out.println("设定温度----------" + sdwS);
//
//					// 室内温度 实时温度
//					String swS = stringHandler.substring(60, 62);
//					System.out.println("swS---" + swS);
//					if (swS.equals("ff"))
//					{
//						swS = findData.getSnwd();
//					}
//					int sw = Integer.parseInt("" + swS + "", 16);
//
//					System.out.println("室内温度 --------" + swS);
//					System.out.println("室内温度十六进制" + sw);
//
//					// 远程开关
//					String kg = stringHandler.substring(62, 64);
//					System.out.println("kg---" + kg);
//					if (kg.equals("ff"))
//					{
//						kg = findData.getKg();
//					}
//					System.out.println("远程开关-----------" + kg);// FF
//
//					// 报警
//					String bjs = stringHandler.substring(64, 66);
//					System.out.println("bjs---" + bjs);
//					if (bjs.equals("ff"))
//					{
//						bjs = findData.getBj();
//					}
//					System.out.println("报警信息 --------" + bjs);
//
//					// 季节
//					String jj = stringHandler.substring(66, 68);
//					System.out.println("jj---" + jj);
//					if (jj.equals("ff"))
//					{
//						jj = findData.getJj();
//					}
//					System.out.println("季节 --------" + jj);
//					String  jzqId=stringHandler.substring(74,76);
//					if(jzqId.equals("ff")){
//						jzqId="01";
//					}
//					jzqService.updateIpPort(Ip, port, jzqId);
//					// 转换为时间格式 方便地修改日期格式
//					Date now = new Date();
//					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//					String time = dateFormat.format(now);
//					Data data = new Data();
//					String gdString = String.valueOf(gdg);
//					String ztString = String.valueOf(zdS);
//					String gddString = String.valueOf(gdd);
//					String dgdgString = String.valueOf(dgdg);
//					String dgzgString = String.valueOf(dzdS);
//					String dgddString = String.valueOf(dgdd);
//					String sdwString = String.valueOf(sdw);
//					String swString = String.valueOf(sw);
//					data.setGdtime(gdString);
//					data.setZdtime(ztString);
//					data.setDdtime(gddString);
//					data.setDgdtime(dgdgString);
//					data.setDzdtime(dgzgString);
//					data.setDddtime(dgddString);
//					data.setJf(Jf);
//					data.setMs(ms);
//					data.setSdwd(sdwString);
//					data.setDw(dw);
//					data.setSnwd(swString);
//					data.setBj(bjs);
//					data.setTime(time);
//					data.setKg(kg);
//					data.setJj(jj);
//					data.setYhbh(yhbhS);
//					data.setFpdz(fpdz);
//					dataService.updateYhbhF(data);// 更新实时表
//
//					 //按流量计算价格
//					 FyFl price=fyFlService.byFyFl(2);
//					 double dlPrice=price.getDj(); // 获取流量单价
//					 double yh=price.getYh(); //获取优惠
//					 Data zyzbh=dataService.findZyydl(yhbhS);//获取总已用当量，和月份，业主编号
//					 Double zyydl=zyzbh.getZyydl();
//					 String yzbh=zyzbh.getYzbh();
//						 //用户已用金额
//					 double yyje= zyydl*dlPrice*yh;
//					 Jf jfs=new Jf();
//					 jfs.setYyje(yyje);
//					 jfs.setGetime(time);
//					 jfs.setYydl(zyydl);
//					 jfs.setYzbh(yzbh);
//					 //-----------------------------
//					 jfServce.updateJf(jfs);
//					
//					// 更新实时表已用当量
//					double yydl=findData.getYydl();
//				    int yf=zyzbh.getYf();
//					data.setYydl(yydl);
//					data.setYf(yf);
//					dataService.InsertYh(data);// 插入历史表
//					Data find = dataService.findYh(yhbhS, Integer.valueOf(fpdz));
//					//根据业主地址查抄剩余金额
//					Double syje=jfServce.selSyje(yzbh);
//					 if(syje<0){
//						 String ld =find.getYhMessage().getLdh();
//						 String dy=find.getYhMessage().getDyh();
//						 String cgbh =find.getYhMessage().getCgbh();
//						
//						 if(ld.length()==1){
//								ld=0+ld;
//							}
//							if(dy.length()==1){
//								dy=0+dy;
//							}
//						String cg=cgbh.substring(4);
//					    String ja =ld+dy+"F010B1"+cg+""+yhbh+fpidS+"00FFFF"+ld+dy+"FF";
//						 // 解码
//						boolean sessionmap = cz(ja, clientIp);
//						if(sessionmap==false){
//						try
//						{
//							Thread.sleep(2000);
//						} catch (InterruptedException e)
//						{
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						 // 解码
//						boolean sessionmap1 = cz(ja, clientIp);
//						if(sessionmap1==false){
//							cz(ja, clientIp);
//						}
//						}
//					 }
//					}
//
//					
//				}
//	}
//	public void XCb(String stringH,String Ip,Integer port, String clientIp,IoSession session)
//	{
//				// 截取效验数据
//				String jy = CzUtil.getJy(stringH);
//
//				// 判断开始和结束
//				String start = null;
//				String end = null;
//				start = stringH.charAt(0) + "" + stringH.charAt(1);
//				end = stringH.charAt(stringH.length() - 2) + "" + stringH.charAt(stringH.length() - 1);
//
//				// 判断和校验
//				String je = CzUtil.getJe(stringH);
//				System.out.println("----------je-----" + je);
//				System.out.println("---------jy------" + jy);
//
//				if (start.equals("f0") && end.equals("ff") && je.equals(jy))
//				{
//				//用户编号
//				String yhbh=stringH.substring(18, 24);
//				String yhbhs = String.valueOf(Integer.parseInt(yhbh, 16));
//				//风盘地址
//				String fpdz=stringH.substring(24,26);
//				String fpdzs = String.valueOf(Integer.parseInt(fpdz, 16));
//				if(fpdzs.length()==1){
//					fpdzs="0"+fpdzs;
//				}
//				
//				// 根据用户编码和风盘地址查找用户
//				Data findData = dataService.findData(yhbhs, fpdzs);
//			
//				//开关
//				String kg=stringH.substring(26,28);
//				 if(kg.equals("ff")){
//					kg=findData.getKg();
//				}
//				//计费
//				String jf=stringH.substring(28,30);
//				 if(jf.equals("ff")){
//						jf=findData.getKg();
//					}
//				//季节
//				String jj=stringH.substring(30,32);
//				if(jj.equals("ff")){
//					jj=findData.getJj();
//				}
//				//制冷高档时间
//				String zlgdTime=String.valueOf(jsMin(Integer.parseInt(stringH.substring(32,38),16)));
//				//制冷中档时间
//				String zlzdTime=String.valueOf( jsMin(Integer.parseInt(stringH.substring(38,44),16)));
//				//制冷抵挡时间
//				String zlddTime= String.valueOf(jsMin(Integer.parseInt(stringH.substring(44,50),16)));
//				//制热高档时间
//				String zrgdTime=String.valueOf( jsMin(Integer.parseInt(stringH.substring(50,56),16)));
//				//制热中档时间
//				String zrzdTime=String.valueOf( jsMin(Integer.parseInt(stringH.substring(56,62),16)));
//				//制热抵挡时间
//				String zrddTime=String.valueOf( jsMin(Integer.parseInt(stringH.substring(62,68),16)));
//				//模式
//				String ms=stringH.substring(68,70);
//				if (ms.equals("ff"))
//				{
//					ms = findData.getMs();
//				}
//				//档位
//				String dw=stringH.substring(70,72);
//				if (dw.equals("ff"))
//				{
//					dw = findData.getDw();
//				}
//				//设定温度
//				String sdwd=stringH.substring(72,74);
//
//				if (sdwd.equals("ff"))
//				{
//					sdwd = findData.getSdwd();
//				}else{
//				    sdwd = Integer.parseInt( sdwd, 16)+"";
//				}
//				//室内温度
//				String snwd=stringH.substring(74,76);
//				
//				if (snwd.equals("ff"))
//				{
//					snwd = findData.getSnwd();
//				}else{
//					snwd = Integer.parseInt( snwd, 16)+"";
//				}
//				//报警
//				String bj=stringH.substring(76,78);
//				Date now = new Date();
//				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//				String time = dateFormat.format(now);
//				Data data = new Data();
//				data.setGdtime(zlgdTime);
//				data.setZdtime(zlzdTime);
//				data.setDdtime(zlddTime);
//				data.setDgdtime(zrgdTime);
//				data.setDzdtime(zrzdTime);
//				data.setDddtime(zrddTime);
//				data.setJf(jf);
//				data.setMs(ms);
//				data.setSdwd(sdwd);
//				data.setDw(dw);
//				data.setSnwd(snwd);
//				data.setBj(bj);
//				data.setTime(time);
//				data.setKg(kg);
//				data.setJj(jj);
//				data.setYhbh(yhbhs);
//				data.setFpdz(fpdzs);
//				dataService.updateYhbhF(data);// 更新实时表
//				  //按流量计算价格
//				 FyFl price=fyFlService.byFyFl(2);
//				 double dlPrice=price.getDj(); // 获取流量单价
//				 double yh=price.getYh(); //获取优惠
//				 Data zyzbh=dataService.findZyydl(yhbhs);
//				 Double zyydl=zyzbh.getZyydl();
//				 String yzbh=zyzbh.getYzbh();
//					 //用户已用金额
//				 double yyje= zyydl*dlPrice*yh;
//				 Jf jfs=new Jf();
//				 jfs.setYyje(yyje);
//				 jfs.setGetime(time);
//				 jfs.setYydl(zyydl);
//				 jfs.setYzbh(yzbh);
//				 //-----------------------------
//				 jfServce.updateJf(jfs);
//				 // 根据实时表查找月份
//				 double yydl=findData.getYydl();
//			    int yf=zyzbh.getYf();
//				data.setYydl(yydl);
//				data.setYf(yf);
//				dataService.InsertYh(data);// 插入历史表
//				
//				//根据业主地址查抄剩余金额
//				Double syje=jfServce.selSyje(yzbh);
//				Data find = dataService.findData(yhbhs,fpdzs);
//				 if(syje<0){
//					 String ld =find.getYhMessage().getLdh();
//					 String dy=find.getYhMessage().getDyh();
//					 String cgbh =find.getYhMessage().getCgbh();
//				     String xqh=find.getYhMessage().getXqh();
//					 if(ld.length()==1){
//							ld=0+ld;
//						}
//						if(dy.length()==1){
//							dy=0+dy;
//						}
//					String cg=cgbh.substring(4);
//					//发送关阀指令
//				    String ja =ld+dy+"F014B1"+xqh+ld+"00"+ld+dy+cg+yhbh+fpdz+"00FFFFFFFF";
//					 // 解码
//					boolean sessionmap = cz(ja, clientIp);
//					if(sessionmap==false){
//					try
//					{
//						Thread.sleep(2000);
//					} catch (InterruptedException e)
//					{
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					 // 解码
//					sessionmap= cz(ja, clientIp);
//					if(sessionmap==false){
//						cz(ja, clientIp);
//					}
//					}
//					logs.info("X中央空调抄表接收数据,用户编码"+yhbh+"风盘地址"+fpdzs+"欠费发送关闭指令"+ja);
//				 }
//				if(null!=MapUtilsDf.getMapUtils().get("fs")&&MapUtilsDf.getMapUtils().get("fs").equals(yhbhs+fpdzs)){
//						MapUtilsDf.getMapUtils().add("state",yhbhs+fpdzs);
//					}
//				logs.info("X中央空调抄表接收数据成功");
//				}
//	}
////	/**
////	 * 某一户的所有风盘操作
////	 * 
////	 * @param base
////	 * @param connc
////	 */
//	private void SF(String stringHandler)
//	{
//		logs.info("对多个风盘操作---" +stringHandler);
//		// 接收数据
////		String stringH = Utils.bytesToHexString(base);
//		// 转换为大写
////		String stringHandler = CzUtil.Uppercase(stringH).toString();
//		// 截取效验数据
//		String jy = CzUtil.getJy(stringHandler);
//
//		// 判断开始和结束
//		String start = null;
//		String end = null;
//		start = stringHandler.charAt(0) + "" + stringHandler.charAt(1);
//		end = stringHandler.charAt(stringHandler.length() - 2) + "" + stringHandler.charAt(stringHandler.length() - 1);
//
//		// 判断和校验
//		String je = CzUtil.getJe(stringHandler);
//		System.out.println(je);
//		System.out.println(jy);
//		if (start.equals("f0") && end.equals("ff") && je.equals("" + jy + ""))
//		{
//			logs.info("-----------------------对多个风盘操作接收数据成功---------------");
////			MapUtilsDf.getMapUtils().add("dg", "success");
//		} else
//		{
////			MapUtilsDf.getMapUtils().add("dg", "fail");
//		}
//	}
//	// long value;
//
//
//	// 标识需要精确到小数点以后两位 返回的是两个参数的商
//	public double jsMin(int minute)
//	{
//		BigDecimal b1 = new BigDecimal(Double.toString(minute));
//		BigDecimal b2 = new BigDecimal(Double.toString(60));
//		return b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP).doubleValue();// ROUND_HALF_UP:
//																		// 遇到.5的情况时往上近似,例:
//																		// 1.5
//																		// ->;2
//	}
//
//	/**
//	 * 当连接进入空闲状态时调用̬
//	 */
//	@Override
//	public void sessionIdle(IoSession session, IdleStatus status) throws Exception
//	{
//		logs.info("当前连接" + session.getRemoteAddress() + "处于空闲状态:{}" + status);
//	}
//
//	/**
//	 * 当消息已经发送给客户端后触发此方法
//	 */
//	@Override
//	public void messageSent(IoSession session, Object message) throws Exception
//	{
//		logs.info("服务器发送给" + session.getRemoteAddress() + "的消息:" + message);
//	}
//
//	/**
//	 * 当关闭时调用
//	 */
//	@Override
//	public void sessionClosed(IoSession session) throws Exception
//	{ 
//
//		@SuppressWarnings("deprecation")
//		CloseFuture closeFuture = session.close(true);
//		closeFuture.addListener(new IoFutureListener<IoFuture>()
//		{
//			public void operationComplete(IoFuture future)
//			{
//				if (future instanceof CloseFuture)
//				{
//					((CloseFuture) future).setClosed();
//					logs.info("sessionClosed CloseFuture setClosed-->" + future.getSession().getId());
//				}
//			}
//		});
//		sessionMap.remove(session);
//		logs.info("关闭当前session：" + session.getId() + session.getRemoteAddress() + "..已移除");
//	}
//
//	public static double sub(double d1, double d2)
//	{
//		BigDecimal bd1 = new BigDecimal(Double.toString(d1));
//		BigDecimal bd2 = new BigDecimal(Double.toString(d2));
//		return bd1.subtract(bd2).doubleValue();
//	}
//
//	public String getJs() {
//		return js;
//	}
//
//	public void setJs(String js) {
//		this.js = js;
//	}
//
//	public String getState() {
//		return state;
//	}
//
//	public void setState(String state) {
//		this.state = state;
//	}
//	
//}
