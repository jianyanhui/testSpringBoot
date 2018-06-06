package com.example.demo.handler;

public abstract class ParentHandle {
	protected ParentHandle nextHandler;
	protected abstract boolean needHandler();//给每个子类handler加上是否执行的开关
	public void handle(){
		System.out.println("执行父类方法ParentHandle");
		ParentHandle ratehandler=this.nextHandler;
		while(ratehandler!=null){
			if(ratehandler.needHandler()){
				ratehandler.handle();
			}
			ratehandler=ratehandler.nextHandler;
		}
	}
	public ParentHandle setNextHandler(ParentHandle nextHandler){
		System.out.println("设置handler");
		this.nextHandler=nextHandler;
		return this.nextHandler;
	}
}
