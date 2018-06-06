package com.example.demo.order.test7.old;
/*传统if else实现用条件语句来决定在每一个状态内做什么事情；
教程：https://blog.csdn.net/shuangde800/article/details/10132825
这样做的缺点:
会产生大量的if...else语句, 代码将很不容易改变, 难以拓展.
没有遵守"开放-关闭"原则
不符合面向对象
状态转换隐藏在条件语句中,所以并不明显
没有把会改变的部分包装起来
未来加入的代码可能导致bug
是时候学习新的设计模式了*/
public class MyinsertQurter {
	// 我们根据糖果机的状态,定义4种状态,用整形常量来表示  
	final static int SOLD_OUT= 0; // 糖果卖完了  
	final static int NO_QUARTER = 1; // 没有投钱  
	final static int HAS_QUARTER = 2;  // 已投钱了  
	final static int SOLD = 3; // 正在出售糖果 
	public static void main(String[] args) {
		MyinsertQurter.insertQurter(HAS_QUARTER);
	}
	public static void insertQurter(int state) {  
	      
		// 根据不同的状态,会有不同的动作反应  
	    if (state == HAS_QUARTER) {  
	        // do something  
	    	System.out.println("已投钱了");
	    } else  if (state == SOLD_OUT) {  
	        // do something     
	    	System.out.println("糖果卖完了 ");
	    } else if (state == SOLD) {  
	        // do something      
	    	System.out.println("正在出售糖果 ");
	    } else if (state == NO_QUARTER) {  
	        // do something     
	    	System.out.println("没有投钱 ");
	    }  
	}  
}
