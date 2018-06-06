package com.example.demo.config;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.example.demo.flow.ApplyFlowContextImpl;
import com.example.demo.flow.annotation.FlowCtx;

public class FlowContextArgumentResolver implements HandlerMethodArgumentResolver{
	/*resolveArgument：真正用于处理参数分解的方法，返回的Object就是controller方法上的形参对象*/
	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory) throws Exception {
		//创建初始化的流程上下文
		System.out.println("创建初始化的流程上下文");
		ApplyFlowContextImpl ctx=null;
		String flowId=(String)webRequest.getParameter("flowId");//前端传的flowId
		System.out.println("创建初始化的流程上下文flowId："+flowId);
		ctx=new ApplyFlowContextImpl(flowId);
		
		return ctx;//返回流程上下文对象
	}
	/*supportsParameter：用于判定是否需要处理该参数分解，返回true为需要，并会去调用下面的方法resolveArgument。*/
	@Override
	public boolean supportsParameter(MethodParameter param) {
//		if(param.hasParameterAnnotation(FlowCtx.class)){//判断入参是否有这个注解
//			return true;
//		}else{
//			return false;
//		}	
		return true;
	}

}
