package com.example.demo.handler;

public class CacuHandlerTwo extends ParentHandle{
	@Override
	protected  boolean needHandler(){
		return false;
	}
	@Override
	public void handle(){
		System.out.println("执行子类方法CacuHandlerTwo");
	}
}
