package com.example.demo.util.suanfa.digui;
/**递归研究
 * 教程：https://blog.csdn.net/tomcat_2014/article/details/51113740*/
public class Digui {
	 public static void main(String args[])  
	    {  
	        int sum=count(1000);  
	        System.out.println(sum);  
	        
	        int sum2=count2(30);  
	        System.out.println(sum2); 
	        
	        System.out.print(digui(5));  
	    }  
	 
	 
	 
	/**求1+2+3+4+5+6+7……+1000的和*/
	public static int  count(int n){  
	        if(n>0){  
	            return n+count(n-1);  
	        }else{  
	            return 0;  
	        }  
	  
	    }  
	/** 1,1,2,3,5,8,13,21,34...，求用递归算第30个数*/
	static int count2(int n){  
	    if(n==1||n==2) {  
	        return 1;  
	    }  
	     return count(n-1)+count(n-2);  
	}   
	/**最常见的就是阶乘，比如求5的阶乘，数学公式就是：5*4*3*2*1*/
	 public static int digui(int n){  
	        if(n==1||n==0){  
	            return n;  
	        }else{  
	            System.out.println("执行第" + n + "次");  
	            return n*digui(n-1);  
	        }  
	    } 
}
