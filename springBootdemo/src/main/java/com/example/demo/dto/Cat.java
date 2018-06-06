package com.example.demo.dto;

import com.example.demo.dto.base.BaseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data //这些注解需要安装lombok插件才能支持，可以在pom.xml引入lombok.jar包
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Cat extends BaseDTO{

	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 1L;

}
