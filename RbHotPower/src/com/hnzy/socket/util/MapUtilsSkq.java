package com.hnzy.socket.util;

import java.util.HashMap;
import java.util.Map;

public class MapUtilsSkq {
	
	private static MapUtilsSkq MapUtils = null;

	private Map<Object, String> map = new HashMap<Object, String>();

	private MapUtilsSkq() {
	}

	public static MapUtilsSkq getMapUtils() { 
		if (MapUtils == null) {
	            	   MapUtils = new MapUtilsSkq();   
		}
		return MapUtils;
	}
	public void add(String key, String value) {
		map.put(key, value);
	}
	public String get(String key) {
		return map.get(key);
	}
}
