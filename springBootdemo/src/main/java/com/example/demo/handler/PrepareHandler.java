package com.example.demo.handler;

public class PrepareHandler extends ParentHandle{
	@Override
	protected boolean needHandler(){
		return true;
	}
	@Override
	public void handle(){
		System.out.println("预处理方法PrepareHandler");
		super.handle();
	}
}
