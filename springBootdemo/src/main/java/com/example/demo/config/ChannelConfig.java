package com.example.demo.config;


import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/*webMVC Config配置
 * web上下文启动配置
 * spring boot 拦截器之WebMvcConfigurerAdapter*/
@Configuration
public class ChannelConfig {
	@Bean
	public WebMvcConfigurer ChannelWebMvcConfig(){
		return new WebMvcConfigurerAdapter(){
			/*参数解析*/
		    @Override
		    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		    	System.out.println("可配置初始化一些其他bean");
		    	argumentResolvers.add(new FlowContextArgumentResolver());
		    }
		};
	}
}
