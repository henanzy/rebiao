package com.hnzy.hot.util;

import java.util.Properties;

public class PropertyUtil {

	private static Properties props;

	private PropertyUtil() {
	}
	public static String InformationSame="��������ԭ������ͬ"; 
	public static String InformationNoSame="��������ȷ�����벻һ��"; 
	public static String Informationerror="�˻����������"; 
	public static String Informationempty="�˻�������Ϊ��"; 
	public static String Accountdisabled="�˻���ͣ�ã�����ϵ����Ա"; 
	public static String InformationName="�û����Ѵ���"; 

//
	public static Properties getSysProperties() {
		return props;
	}

	//��ȡ����
	public static String getProperty(String key) {
		return props.getProperty(key);
	}

	
	public static String getProperty(String key, String defaultVal) {
		return props.getProperty(key, defaultVal);
	}

}
