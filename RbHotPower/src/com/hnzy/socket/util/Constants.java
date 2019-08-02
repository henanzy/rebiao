package com.hnzy.socket.util;

/**
 */
public class Constants {
	
    /** 30秒后超时̬ */  
    public static final int IDEL_TIME_OUT = 35;  
    /**15秒发送一次心跳包 */  
    public static final int HEARTBEAT =15;
    
    /** 5��δ���������� */  
    public static final int HEARTBEAT_TIME_OUT =30;
    /**心跳包内容*/
    /** 服务器*/  
    public static final String HEARTBEAT_REQUEST = "0x11"; 
    /** 客户端*/ 
    public static final String HEARTBEAT_RESPONSE = "0x12";  
	
}
