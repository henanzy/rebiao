package com.hnzy.socket.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * oracle数据连接
 * @author Administrator
 *
 */
public class oracleHelper {
	 private static oracleHelper dbUtil;   
	    private String drivers;   
	    private String url;   
	    private String username;   
	    private String password;   
	    //加反斜线就表示在默认包目录，不加则表示在与当前类同路径去查找该属性文件   
	    private static String FILE_PATH_NAME = "/jdbc.properties"; 
	    // 日志文件
		private static Log logs = LogFactory.getLog(oracleHelper.class);
	    private void init() {   
	        try {   
	            InputStream in = getClass().getResourceAsStream(FILE_PATH_NAME);   
	            Properties props = new Properties();   
	           
	            props.load(in);   
	            in.close();   
	            drivers = props.getProperty("oracle.driver");   
	            url = props.getProperty("oracle.url");   
	            username = props.getProperty("oracle.username");   
	            password = props.getProperty("oracle.password");   
	        } catch (IOException e) {   
	            e.printStackTrace();   
	        }   
	           
	    }   
	       
	    private oracleHelper() {   
	        init();   
	    }   
	    public static oracleHelper getInstance() {   
	        if(dbUtil == null) {   
	            dbUtil = new oracleHelper();   
	        }   
	        return dbUtil;    
	    }   
	    public Connection getConnection() {   
	           
	        Connection conn = null;   
	        try {   
	            Class.forName(drivers);   
	            conn = DriverManager.getConnection(url, username, password);   
	        } catch (SQLException e) {   
	            e.printStackTrace();
	          //错误日志打印信息
				logs.error(e,e.fillInStackTrace());
	        } catch (ClassNotFoundException e) {   
	            e.printStackTrace();   
	          //错误日志打印信息
				logs.error(e,e.fillInStackTrace());
	        }   
	        return conn;   
	    }   
}
