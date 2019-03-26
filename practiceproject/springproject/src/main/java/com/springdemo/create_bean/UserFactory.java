package com.springdemo.create_bean;

import com.springdemo.bean.User;

public class UserFactory {
	public static User createUser(){
		System.out.println("静态工厂创建");
		return new User();
	}
	public User createUser2(){
		System.out.println("实例工厂创建");
		return new User();
	}
}
