package com.hnzy.socket;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hnzy.socket.server.ServerSocket;

public class ServerListener implements ServletContextListener{
	 private final static Logger log = LoggerFactory.getLogger(ServerListener.class);
	 private ReplyTimer rt = null;
	 private ServerSocket server;
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		server.stopServer();
		event.getServletContext().log("监听器销毁");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		server=new ServerSocket();
		boolean flag=server.startServer();
			rt =new ReplyTimer(1);
			rt.start();
	        
		if (flag) {
			log.info("--服务器Socket已经启动成功！");
		}else{
			log.info("服务器Socket启动失败---");
		}
	}

}
