package com.springdemo.bean;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo {
	@Test
	public void func1() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//User user = ac.getBean(User.class);
		User user = (User) ac.getBean("user");
		System.out.println(user.getName()+user.getAge());
	}
	@Test
	public void func2() throws Exception {
		BeanFactory bf = new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = bf.getBean(User.class);
		System.out.println(user.getName());
	}
	@Test
	public void func3() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		User user2 = (User) ac.getBean("user2");
		System.out.println(user2);
		User user3 = (User) ac.getBean("user3");
		System.out.println(user3);
	}
	@Test
	public void func4() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = (User) ac.getBean("user4");
		System.out.println(user.getName());
		
	}
	@Test
	public void func5() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = (User) ac.getBean("user5");
		System.out.println(user.getName()+user.getAge());
	}
	@Test
	public void func6() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = (User) ac.getBean("user6");
		String[] arr = user.getArr();
		for (String string : arr) {
			System.out.print(string+"\t");
		}
		System.out.println();
		List list = user.getList();
		for (Object object : list) {
			System.out.print(object+"\t");
		}
		System.out.println();
		Map map = user.getMap();
		Set entrySet = map.entrySet();
		for (Object object : entrySet) {
			System.out.print(object+"\t");
		}
		System.out.println();
		Properties props = user.getProp();
		/*Set<Object> keySet = props.keySet();
		Iterator<Object> it = keySet.iterator();
		while(it.hasNext()){
			String key = (String) it.next();
			System.out.print(key+":"+props.getProperty(key)+"\t");
		}*/
		Set<String> set = props.stringPropertyNames();
		for (String string : set) {
			System.out.print(string+":"+props.getProperty(string)+"\t");
		}
	}
}
