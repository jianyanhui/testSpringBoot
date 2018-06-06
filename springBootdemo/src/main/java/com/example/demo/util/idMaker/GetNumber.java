package com.example.demo.util.idMaker;

import java.util.UUID;

/**生成编号的几种方法
 * 如何避免高并发量下编号重复问题？
 * */
public class GetNumber {

	public static void main(String[] args) {
		//用java.util.uuid生成编号，可以将其理解成当前时空下唯一的一串字符串。通常用在激活码或者是ID上,java生成32位的UUID通用唯一识别码
		System.out.println(UUID.randomUUID());
		System.out.println(UUID.randomUUID().toString());
		System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
		
		//利用时间戳生成编号
		System.out.println(createID());
		System.out.println(System.currentTimeMillis());
	}
	
	/**通过uuid工具类生成随机编号
	 * 教程：https://blog.csdn.net/xinghuo0007/article/details/72868799
	 * */
	public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
   }
	
	
	
	private static byte[] lock = new byte[0];  	  
    // 位数，默认是8位  
    private final static long w = 100000000;  
  
  /**利用时间戳生成编号*/
    public static String createID() {  
        long r = 0;  
        synchronized (lock) {  
            r = (long) ((Math.random() + 1) * w);  //默认8位
        }  
        //由于高并发会导致时间戳生成的编号重复，故需要组合随机数让编号不重复，从而变成唯一编号
        return System.currentTimeMillis() + String.valueOf(r).substring(1);  
    } 
}
