package com.hnzy.socket.util;

/**
 * 常量类
 */
public class Constants {
	
    /** 30秒后超时̬ */  
    public static final int IDEL_TIME_OUT =145;  
    /**15秒发送一次心跳包 */  
    public static final int HEARTBEAT =135;
    
    /** 5��δ���������� */  
    public static final int HEARTBEAT_TIME_OUT =140;
    /**心跳包内容*/
    /** 服务器*/  
    public static final String HEARTBEAT_REQUEST = "0x11"; 
    /** 客户端*/ 
    public static final String HEARTBEAT_RESPONSE = "0x12";  
	
}
