package com.entity;

/*
 *用户：sky-吴
 *日期：2019/7/22
 */
public class HelloWorld {

	public String helloWorld;

	public String getHelloWorld() {
		return helloWorld;
	}

	public void setHelloWorld(String helloWorld) {
		this.helloWorld = helloWorld;
	}

	public HelloWorld() {
		this.helloWorld="hello world";
	}

	public HelloWorld(String helloWorld) {
		this.helloWorld = helloWorld;
	}

	@Override
	public String toString() {
		return "HelloWorld{" +
				"helloWorld='" + helloWorld + '\'' +
				'}';
	}
}
