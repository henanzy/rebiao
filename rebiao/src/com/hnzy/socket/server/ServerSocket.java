package com.hnzy.socket.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.filter.keepalive.KeepAliveFilter;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hnzy.socket.codec.Str16CodecFactory;
import com.hnzy.socket.util.Constants;

public class ServerSocket {
	private static final int PORT = 6000;   //端口号6000
    //相当于网络应用程序中的服务端
	private IoAcceptor acceptor; 
	private final static Logger log = LoggerFactory.getLogger(ServerSocket.class);
		
	public ServerSocket() {
		acceptor = new NioSocketAcceptor();
	}
	/**
	 * 开启服务
	 * @return
	 */
	public boolean startServer() {
		acceptor.getSessionConfig().setReadBufferSize(2048);//读
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, Constants.IDEL_TIME_OUT);
		acceptor.getFilterChain().addLast("logger", new LoggingFilter());
		acceptor.getFilterChain().addLast("mycodec",new ProtocolCodecFilter(new Str16CodecFactory()));
		// ----------------------------------------心跳包的使用
		KeepAliveMessageFactory heartBeatFactory = new ServerKeepAliveFactory();
		KeepAliveFilter heartBeat = new KeepAliveFilter(heartBeatFactory, IdleStatus.BOTH_IDLE);
		//设置是否forward到下一个filter
		heartBeat.setForwardEvent(true);
		//设置心跳频率
		heartBeat.setRequestInterval(Constants.HEARTBEAT);
		heartBeat.setRequestTimeout(Constants.HEARTBEAT_TIME_OUT);//读写通道在10秒内无任何操作进入空闲状态
		acceptor.getFilterChain().addLast("heartbeat", heartBeat);
		acceptor.getFilterChain().addLast("threadPool", new ExecutorFilter(Executors.newCachedThreadPool()));  
		acceptor.setHandler(new ServerHandler());
		try {
			acceptor.bind(new InetSocketAddress(PORT));//bind捆绑
			acceptor.bind();
			log.info("服务端启动成功,端口号为:{}" ,PORT);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 关闭服务
	 */
	public void stopServer() {//关闭服务
		if (!acceptor.isCloseOnDeactivation()) {
			acceptor.isCloseOnDeactivation();
		} else {
			acceptor.isCloseOnDeactivation();
		}
	}
}
