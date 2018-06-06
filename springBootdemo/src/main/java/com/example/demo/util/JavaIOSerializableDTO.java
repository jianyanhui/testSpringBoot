package com.example.demo.util;

import java.io.Serializable;

/**JDK1.8 java.io.Serializable接口详解
 * 教程：https://www.cnblogs.com/wangg-mail/p/4354709.html
 * https://blog.csdn.net/chenjie19891104/article/details/4398647
 * 
 * 1、java.io.Serializable，表示序列化，是一个空接口，也就是说这个接口没有声明任何的方法，所以实现这个接口的类也就不需要实现任何的方法。    
 2、序列化   用在将对象编码成字节流（序列化）及从字节流编码重构对象（反序列化）。   
  序列化   为远程通信提供了标准的wire-level协议。   
 3、 要使类的实例实现序列化，只要在它的声明中加入implements   java.io.Serializable   
但是却由一些隐患   
  1 》  实现了序列化后，一旦发布，讲削弱改变类实现的灵活性。   
  2 》 增加了bug和安全漏洞的的可能性   
  3 》  当你的新版本发布时增加了相关的测试上的问题。   
这个接口使得所有的实现它的类具有一个特殊的（mixin）类型，从而使JVM知道这个类可以安全地串行化。
4、如果你需要把一个Bean实例通过网络传输或者写到磁盘文件的话，那么实现Serializable接口是最简单的,你可以直接通过ObjectInputStream,ObjectOutputStream进行读入或者写出
5、为了EJB容器可以记录用户生存期期间用户的信息，在EJB中实现Stateful Session Bean时，必须继承Serializable。这样，EJB容器才能在它们不再使用时序列化存储它们的状态信息。
 * */
public class JavaIOSerializableDTO implements Serializable{

	/**
	 * 序列化版本号，这个功能有啥用？
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	public int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JavaIOSerializableDTO [name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append("]");
		return builder.toString();
	}
	
	
}
