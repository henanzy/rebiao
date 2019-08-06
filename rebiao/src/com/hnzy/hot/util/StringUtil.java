package com.hnzy.hot.util;

import java.util.UUID;

// 通用字符串判断
public class StringUtil {

	//获取UUID
	public static String gainUUID(){
		String strUUID=UUID.randomUUID().toString();
		return strUUID;	
	}
	
	//判断是否不是空
	public static boolean isEmpty(String str){
		return ((str == null) || ("".equals(str.trim())));
	}
	
	//判断是否不是空
	public static boolean isNoEmpty(String str){
		return !((str==null)||("".equals(str.trim())));
	}
	/**
	 * 判断是否不是空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return !((str == null) || ("".equals(str.trim())));
	}

}
