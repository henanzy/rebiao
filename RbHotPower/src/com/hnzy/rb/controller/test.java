package com.hnzy.rb.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.hnzy.socket.RbidSDataUtil;

public class test
{
  public static void main(String[] args)
{  
 String RbIds="FFFFFF35715443FFFFFF35715444FFFFFF35715445FFFFFF35715446FFFFFF35715447FFFFFF35715448FFFFFF35715449";
//	  		+ "FFFFFF35715443FFFFFF35715444FFFFFF35715445FFFFFF35715446FFFFFF35715447FFFFFF35715448FFFFFF35715449FFFFFF3571544aFFFFFF3571544bFFFFFF3571544c"
//	  		+ "FFFFFF35715443FFFFFF35715444FFFFFF35715445FFFFFF35715446FFFFFF35715447FFFFFF35715448FFFFFF35715449FFFFFF3571544aFFFFFF3571544bFFFFFF3571544c"
//	  		+ "FFFFFF35715443FFFFFF35715444FFFFFF35715445FFFFFF35715446FFFFFF35715447FFFFFF35715448FFFFFF35715449FFFFFF3571544aFFFFFF3571544bFFFFFF3571544c"
//	  		+ "FFFFFF35715443FFFFFF35715444FFFFFF35715445FFFFFF35715446FFFFFF35715447FFFFFF35715448FFFFFF35715449FFFFFF3571544aFFFFFF3571544bFFFFFF3571544c"
//	  		+ "FFFFFF35715443FFFFFF35715444FFFFFF35715445FFFFFF35715446FFFFFF35715447FFFFFF35715448FFFFFF35715449FFFFFF3571544aFFFFFF3571544bFFFFFF3571544c"
//	  		+ "FFFFFF35715443FFFFFF35715444FFFFFF35715445FFFFFF35715446FFFFFF35715447FFFFFF35715448FFFFFF35715449FFFFFF3571544aFFFFFF3571544bFFFFFF3571544c"
//	  		+ "FFFFFF35715443FFFFFF35715444FFFFFF35715445FFFFFF35715446FFFFFF35715447FFFFFF35715448FFFFFF35715449FFFFFF3571544aFFFFFF3571544bFFFFFF3571544c"
//	  		+ "FFFFFF35715443FFFFFF35715444FFFFFF35715445FFFFFF35715446FFFFFF35715447FFFFFF35715448FFFFFF35715449FFFFFF3571544aFFFFFF3571544bFFFFFF3571544c"
//	  		+ "FFFFFF35715443FFFFFF35715444FFFFFF35715445FFFFFF35715446FFFFFF35715447FFFFFF35715448FFFFFF35715449FFFFFF3571544aFFFFFF3571544bFFFFFF3571544c"
//	  		+ "FFFFFF35715443FFFFFF35715444FFFFFF35715445FFFFFF35715446FFFFFF35715447FFFFFF35715448FFFFFF35715449FFFFFF3571544aFFFFFF3571544bFFFFFF3571544c"
//	  		+ "FFFFFF35715443FFFFFF35715444FFFFFF35715445FFFFFF35715446FFFFFF35715447FFFFFF35715448FFFFFF35715449FFFFFF3571544aFFFFFF3571544bFFFFFF3571544c"
//	  		+ "FFFFFF35715443FFFFFF35715444FFFFFF35715445FFFFFF35715446FFFFFF35715447FFFFFF35715448FFFFFF35715449FFFFFF3571544aFFFFFF3571544bFFFFFF3571544c"
//	  		+ "FFFFFF35715443FFFFFF35715444FFFFFF35715445FFFFFF35715446FFFFFF35715447FFFFFF35715448FFFFFF35715449FFFFFF3571544aFFFFFF3571544bFFFFFF3571544c";
	  
	  
	  
//   String rb;
//	List<String> list =RbidSDataUtil.getStrList(RbIds,14);
//	String  hz1=RbIds.substring(0, 211);
//	System.out.println(hz1);
	List list=new ArrayList();
	for(int i=0;i<RbIds.length();i=i+420){
		if(RbIds.length()>i+420){
			String r=RbIds.substring(i, i+420);
			list.add(r);
		}else{
			String r=RbIds.substring(i, RbIds.length());
			list.add(r);
		}
		
	}
	
	for(int i=0;i<list.size();i++){
//		System.out.println(list.get(i));
	}
	
	
	String s="FFFFFF";
	System.out.println(s.length());
}
 
  
  
  
  public void test09() {  
    
  } 
  public static double sub(Double value1, Double value2) {
      BigDecimal b1 = new BigDecimal(Double.toString(value1));
     BigDecimal b2 = new BigDecimal(Double.toString(value2));
     return b1.subtract(b2).doubleValue();
 }
  
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
