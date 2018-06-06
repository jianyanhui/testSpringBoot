package com.example.demo.order.test1;

public class TongaException extends Exception {
 private String code;
 public TongaException(Throwable cause){
	 super(cause);
 }
 public TongaException(String msg){
	 super(msg);
 }
 public TongaException(String msg,Throwable cause){
	 super(msg,cause);
 }
 public TongaException(String msg,String code,Throwable cause){
	 super(msg,cause);
	 this.code=code;
 }
 
 public TongaException(String msg,String code){
	 super(code+msg);
	 this.code=code;
 }
	
}
