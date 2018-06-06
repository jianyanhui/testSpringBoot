package com.example.demo.handler;

import lombok.Getter;

public class HandlerFactory {
	
	private static ParentHandle chain=new PrepareHandler();
	static{
		System.out.println("进入静态块");
		//可以设置调用顺序，每一个类都依次执行handle()方法，方便用于一连串的流程控制和一连串的方法执行，比如保费计算和报价有一连串流程
		chain.setNextHandler(new CacuHandlerOne()).setNextHandler(new CacuHandlerTwo());
	}
	
	public static void main(String[] args) {
		ParentHandle handler=HandlerFactory.getChain();
		handler.handle();
	}

	public static ParentHandle getChain() {
		return chain;
	}

	public static void setChain(ParentHandle chain) {
		HandlerFactory.chain = chain;
	}
	
}
