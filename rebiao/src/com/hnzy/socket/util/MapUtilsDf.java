package com.hnzy.socket.util;

import java.util.HashMap;
import java.util.Map;

public class MapUtilsDf {
	
	private static MapUtilsDf MapUtils = null;

	private Map<Object, String> map = new HashMap<Object, String>();

	private MapUtilsDf() {
	}

	public static MapUtilsDf getMapUtils() { 
		if (MapUtils == null) {
	       MapUtils = new MapUtilsDf();   
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
