package com.hnzy.rb.controller;

public class te
{
 public static void main(String[] args)
{
	 
//	 int a = 15;
//	 int b = a &10;
//	 System.out.println("b------------"+b);
//	 int bb=Integer.decode("0x7b");
//	 System.out.println(bb);
	 
//	int i= Integer.parseInt("0F", 16);
//	System.out.println("i-----"+i);
	
	int aa=Integer.parseInt("F0"  , 16);
	int bb=Integer.parseInt("13", 16);
	int aa1=Integer.parseInt("B0"  , 16);
	int bb1=Integer.parseInt("E0", 16);
	int ab=(aa&bb)/16*8+(aa1&bb1)/32;
	System.out.println("-------------------"+ab);
	
//	 Integer yTimes=Integer.valueOf("53c015");
//	 int b=Integer.valueOf("53c015", 16);
//	 System.out.println("-------b-"+b);
//	 int parseInt = Integer.parseInt("cc", 16);
//	 System.out.println(parseInt);
//	 BigInteger ss= new BigInteger("53c015", 16);
//	  int aa=Integer.decode("0x0F");
//		int b=Integer.valueOf("0F", 16);  
//		System.out.println("b--"+b);
//		 int bb=b&0xff;
//		System.out.println("-------bb-"+bb);
//	 String a ="53c015";
//	//Integer.parseInt(s, radix) radix设置为10，表示10进制，16表示16进制啦
//	int i = Integer.parseInt(a, 16);
//	
//	System.out.println(i);
//	String aInteger=Integer.toHexString(i);
//	System.out.println(a&0x1F);
//	
//	
//	int aa = 0x1A;
//	 int ba = 0xF0;
//	 
//	 Integer ac=(aa&ba)/2+(0xB0&0xE0)/32;
//	 System.out.println(ac);
//	 

//	  String s = "1A";
//      String hex = toHex(s);
//      Integer decode = Integer.valueOf(fromHex(hex));
//      System.out.println("原字符串:" + s);
//      System.out.println("十六进制字符串:" + hex);
//      System.out.println("还原:" + decode);
	 
//	 Scanner sc = new Scanner(System.in);
//     int x = sc.nextInt();
//     Demo d = new Demo();
//     // 十六进制转十进制
//     byte[] result = d.getIntBit(x);
//     for(int i = 0; i < 32; i++)
//         System.out.print(result[i]);
//     System.out.println();
//     String s = d.toHex(result);
//     System.out.println(s);
//     System.out.println(d.toDec(s));
//	 
//
//}
// 
// /**
//  * 将byte转换为一个长度为32的byte数组，数组每个值代表bit
//  */ 
//  public byte[] getIntBit(int b) { 
//      byte[] array = new byte[32]; 
//      for (int i = 31; i >= 0; i--) { 
//          array[i] = (byte)(b & 1); 
//          b = (byte) (b >> 1); 
//      } 
//      return array; 
//  } 
//  /**
//   * 转16进制
//   */
//  public String toHex(byte[] b) {
//      String s = "";
//      //每四位处理一次
//      for(int i = 0; i < 32; i += 4) {
//          int temp = (b[i] * 8  + b[i+1] * 4 + b[i+2] * 2 + b[i+3]);
//           
//          if(temp > 9) {
//         temp += 55;
//         s += (char)temp;
//          }else {
//              s += temp;
//          }
//      }
//      return s;
//  }
//  /**
//   * 转十进制
//   */
//  public int toDec(String s) {
//      int result = 0;
//      for(int i = 0; i < 8; i++) {
//          int temp = s.charAt(i);
//          //9的ascii为57
//          if(temp > 57) {
//              temp -= 55; //'A'为65对应10，故减去55
//          }else {
//              temp -= 48;
//          }
//          result += temp * getProduct(7 - i);
//      }
//      return result;
//  }
//  /**
//   * 计算16的n次方　
//   */
//  public int getProduct(int n) {
//      int result = 1;
//      for(int i = 0; i < n; i++) {
//          result *= 16;
//      }
//      return result;
//  }
//}
// 
// 
// 
// 
// private static final char[] DIGITS_HEX = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
//         'E', 'F' };
//
// protected static char[] encodeHex(byte[] data) {
//     int l = data.length;
//     char[] out = new char[l << 1];
//     for (int i = 0, j = 0; i < l; i++) {
//         out[j++] = DIGITS_HEX[(0xF0 & data[i]) >>> 4];
//         out[j++] = DIGITS_HEX[0x0F & data[i]];
//     }
//     return out;
// }
//
// protected static byte[] decodeHex(char[] data) {
//     int len = data.length;
//     if ((len & 0x01) != 0) {
//         throw new RuntimeException("字符个数应该为偶数");
//     }
//     byte[] out = new byte[len >> 1];
//     for (int i = 0, j = 0; j < len; i++) {
//         int f = toDigit(data[j], j) << 4;
//         j++;
//         f |= toDigit(data[j], j);
//         j++;
//         out[i] = (byte) (f & 0xFF);
//     }
//     return out;
// }
//
// protected static int toDigit(char ch, int index) {
//     int digit = Character.digit(ch, 16);
//     if (digit == -1) {
//         throw new RuntimeException("Illegal hexadecimal character " + ch + " at index " + index);
//     }
//     return digit;
// }
//
// public static String toHex(String str) {
//     return new String(encodeHex(str.getBytes()));
// }
//
// public static String fromHex(String hex) {
//     return new String(decodeHex(hex.toCharArray()));
// }
}
}
