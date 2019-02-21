package cn.itcast.c_proxy;

import org.junit.Test;

import cn.itcast.service.UserService;
import cn.itcast.service.UserServiceImpl;

public class Demo {
	
	@Test
	public void fun1(){
		UserService us = new UserServiceImpl();
		UserServiceProxyFactory factory = new UserServiceProxyFactory(us);
		UserService usProxy = factory.getUserServiceProxy();
		usProxy.save();
		System.out.println(usProxy instanceof UserServiceImpl);
	}
	@Test
	public void fun2(){
		UserServiceProxyFactory2 factory = new UserServiceProxyFactory2();
		UserService usProxy = factory.getUserServiceProxy();
		usProxy.save();
		System.out.println(usProxy instanceof UserServiceImpl);
	}
}
