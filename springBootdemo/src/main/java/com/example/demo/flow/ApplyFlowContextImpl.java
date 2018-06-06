package com.example.demo.flow;

public class ApplyFlowContextImpl implements ApplyFlowContext{
	private String flowId;
	public ApplyFlowContextImpl(String flowId){
		this.flowId=flowId;//构造方法赋值
	}
	@Override
	public RootVO getRootVO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFlowId() {
		return flowId;
	}

}
