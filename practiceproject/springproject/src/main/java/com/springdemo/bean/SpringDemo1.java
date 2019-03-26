package com.springdemo.bean;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class SpringDemo1 {
	@Resource(name="user")
	private User user;
	@Test
	public void func1() throws Exception {
		System.out.println(user.getName());
	}
}
