package com.hnzy.socket;

import java.util.ArrayList;
import java.util.List;

public class RbidSDataUtil
{
	 public static List<String> getStrList(String inputString, int length) {
	      int size = inputString.length() / length;
	      if (inputString.length() % length != 0) {
	          size += 1;
	      }
	      return getStrList(inputString, length, size);
	  }
	  public static List<String> getStrList(String inputString, int length,
	          int size) {
	      List<String> list = new ArrayList<String>();
	      for (int index = 0; index < size; index++) {
	          String childStr = substring(inputString, index * length,
	                  (index + 1) * length);
	          list.add(childStr);
	      }
	      return list;
	  }
	  public static String substring(String str, int f, int t) {
	      if (f > str.length())
	          return null;
	      if (t > str.length()) {
	          return str.substring(f, str.length());
	      } else {
	          return str.substring(f, t);
	      }
	  }	

}
