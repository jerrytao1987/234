package cn.itcast.b_create;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.bean.User;

public class Demo {
	@Test
	//创建方式1：空参构造
	public void fun1(){
		//1.创建容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("cn/itcast/b_create/applicationContext.xml");
		//2.向容器“要”user对象
		User u = (User) ac.getBean("user");
		//3.打印user对象
		System.out.println(u);
	}
	@Test
	//创建方式2：静态工厂
	public void fun2(){
		//1.创建容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("cn/itcast/b_create/applicationContext.xml");
		//2.向容器“要”user对象
		User u = (User) ac.getBean("user2");
		//3.打印user对象
		System.out.println(u);
	}
	@Test
	//创建方式3：实例工厂
	public void fun3(){
		//1.创建容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("cn/itcast/b_create/applicationContext.xml");
		//2.向容器“要”user对象
		User u = (User) ac.getBean("user3");
		//3.打印user对象
		System.out.println(u);
	}
	@Test
	//scope:singleton单例对象
	//scope:prototype多例对象
	public void fun4(){
		//1.创建容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("cn/itcast/b_create/applicationContext.xml");
		//2.向容器“要”user对象
		User u1 = (User) ac.getBean("user");
		User u2 = (User) ac.getBean("user");
		User u3 = (User) ac.getBean("user");
		User u4 = (User) ac.getBean("user");
		//3.打印user对象
		System.out.println(u1==u4);
		System.out.println(u1);
	}
	
	@Test
	//测试生命周期方法
	public void fun5(){
		//1.创建容器对象
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("cn/itcast/b_create/applicationContext.xml");
		//2.向容器“要”user对象
		User u = (User) ac.getBean("user");
		//3.打印user对象
		System.out.println(u);
		ac.close();
	}
}
