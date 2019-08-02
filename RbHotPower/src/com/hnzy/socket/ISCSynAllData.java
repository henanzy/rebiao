package com.hnzy.socket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.hnzy.rb.pojo.CsTime;
import com.hnzy.rb.service.CsTimeService;
import com.hnzy.socket.server.ServerSessionMap;
import com.hnzy.socket.util.CzUtil;
import com.hnzy.socket.util.DatabaseUtil;

public class ISCSynAllData  {
	//定时执行任务的类
	private static Logger log = Logger.getLogger(ISCSynAllData.class);
	String qgId = null;
	String JzqIP = null;
	int QgFl=0;
	int JzqPort = 0;
	public void run() {
		try
		{
			doSomething();
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doSomething() throws SQLException {
		 log.info("----抄表开始-");
		 //连接数据库
		  DatabaseUtil dbUtil = DatabaseUtil.getInstance();   
	      Connection connc = dbUtil.getConnection(); 
	      ResultSet rstqg = null;
	      ResultSet rst;
	      PreparedStatement psqg = null;
	      PreparedStatement ps;
	      String sqlcx = "select distinct T_QgInfo.QgID,T_QgInfo.JzqID from T_JzqInfo,T_QgInfo where (QgFl=1 or QgFl=2)order by T_QgInfo.QgID ";
	      ps=connc.prepareStatement(sqlcx);
		  rst = ps.executeQuery();
		int col = rst.getMetaData().getColumnCount();
		while (rst.next()) {
			qgId = rst.getString("QgID");
            String jzqid=rst.getString("JzqID");
			//根据区管ID查询阀门总数
			String sqlqg="select Count(RbAd)  as RbCount from T_RbInfo where  QgID='"+qgId+"'";
		     psqg=connc.prepareStatement(sqlqg);
			 rstqg = psqg.executeQuery();
			 int rowCount = 0;      
			 if(rstqg.next())      
			 {      
			    rowCount = rstqg.getInt(1);  
			 }   
			 //获取区管下的IP地址和端口号
			 String iprt="select distinct T_JzqInfo.jzqIP,T_JzqInfo.jzqport from T_JzqInfo where JzqID='"+jzqid+"'";
			 psqg=connc.prepareStatement(iprt);
			 rstqg = psqg.executeQuery();
			 if(rstqg.next())      
			 {      
				 JzqIP = rstqg.getString("jzqIP") ;
				 JzqPort=rstqg.getInt("jzqport");
			 }  
			// IP地址和端口号
			String pt = "/" + JzqIP + ":" + JzqPort;
				//输出日志
				 log.info(qgId+"区管下阀门数量"+rowCount);  
				 String ja = "F00B1500" + qgId+"04";
				String je=CzUtil.getTimerJe(ja);
				String[] keys = new String[] { pt };
				String mString = ja + "" + je + "FF";
				//输出日志
				 log.info("--自动抄热表发送数据--------pt==="+pt+"-------------------------"+mString); 
				// 解码
				byte[] b = CzUtil.jm(mString);
				ServerSessionMap sessionMap = ServerSessionMap.getInstance();
				boolean sessionmap = sessionMap.sendMessage(keys, b);
				//根据阀门总数设置停留时间
				try {
					Thread.sleep(rowCount*2000);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
//			}
			
		}
		log.info("----抄表结束-");
		try
		{
			DatabaseUtil.close(rst,ps, connc);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
