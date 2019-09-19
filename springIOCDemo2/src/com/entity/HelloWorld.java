package com.entity;

import org.junit.runner.RunWith;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// @RunWith注解表示运行在Spring容器中，包括controller，service，dao等
@RunWith(SpringJUnit4ClassRunner.class)
// 这里表示加载配置文件
@ContextConfiguration({"classpath:application.xml"})

@Component("helloWorld") //自定义bean名称
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
/*
 *用户：sky-吴
 *日期：2019/7/22
 */