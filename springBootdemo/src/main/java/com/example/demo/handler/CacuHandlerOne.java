package com.example.demo.handler;

public class CacuHandlerOne extends ParentHandle{
	@Override
	protected  boolean needHandler(){
		return true;
	}
	@Override
	public void handle(){
		System.out.println("执行子类方法CacuHandlerOne");
	}
}
