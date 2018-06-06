package com.example.demo.exception.tryCatch;

public class Test1 {
	/*try catch和throws Exception的区别
	 * 不同点：try catch不会终止程序运行，throws Exception会终止程序运行
	 * 相同点：两种方式都可以打印异常信息
	 * 
	 * */
	public static void main(String[] args) throws Exception {
		Test1 t=new Test1();
		t.getValue();
		System.out.println("-------------------------------------------------------");
		t.getValue2();
	}
	
	public String getValue(){
		try {//执行的代码，其中可能有异常。一旦发现异常，则立即跳到catch执行。否则不会执行catch里面的内容
			String a=null;
			System.out.println("执行try");
			System.out.println(a.equals("12"));
			//...
		} catch (Exception e) {//参数可以为多个异常用|符号连接//除非try里面执行代码发生了异常，否则这里的代码不会执行
			System.out.println("catch异常");
			//...
		}finally{//不管什么情况都会执行，包括try catch 里面用了return ,可以理解为只要执行了try或者catch，就一定会执行 finally 
			System.out.println("执行finally");
		}
		return "";
		
	}
	
	
	public String getValue2() throws Exception{
		String a=null;
		System.out.println(a.equals("12"));
		return null;
		
	}
}
