package cn.itcast.a_annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.bean.User;

public class Demo {
	
	@Test
	public void fun1(){
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		User u = (User) ac.getBean("user");
		System.out.println(u);
		ac.close();
	}
	@Test
	public void fun2(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		User u1 = (User) ac.getBean("user");
		User u2 = (User) ac.getBean("user");
		System.out.println(u1==u2);
	}
}
