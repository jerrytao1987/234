package com.itheima.service;

public class AppTest {
	public static void main(String[] args) {
		HelloServiceImplService ss = new HelloServiceImplService();
		HelloService proxy = ss.getHelloServiceImplPort();
		String ret = proxy.sayHello("test");
		System.out.println(ret);
	}
}
