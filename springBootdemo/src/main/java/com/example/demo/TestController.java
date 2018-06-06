package com.example.demo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.flow.ApplyFlowContext;
import com.example.demo.flow.annotation.FlowCtx;

@RestController
@EnableAutoConfiguration 
@RequestMapping("/hh")
public class TestController {
	@RequestMapping("/firstmy")
	@ResponseBody
	public String get(@FlowCtx ApplyFlowContext ctx){
		return "hello World !";
	}
	
	@RequestMapping("/firstmy2")
	@ResponseBody
	public String get2(){
		return "hello World !";
	}
}
