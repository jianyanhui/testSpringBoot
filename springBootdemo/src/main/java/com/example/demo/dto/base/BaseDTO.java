package com.example.demo.dto.base;

import java.io.Serializable;



public class BaseDTO implements Serializable,Cloneable{

	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 1L;
	/**对象复制*/
	public Object clone(){
		try{
			return super.clone();
		}catch(CloneNotSupportedException e){
			return null;
		}
	}
	/**重写toString*/
	public String toString(){
		try{
//			return BeanUtils.describe(this).toString();
			return null;
		}catch(Exception e){
			return null;
		}
	}
}

	
