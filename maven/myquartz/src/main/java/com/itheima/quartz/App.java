package com.itheima.quartz;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	}
}
