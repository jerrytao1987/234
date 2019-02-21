package com.itheima.mybatis.junit;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.mybatis.mapper.UserMapper;
import com.itheima.mybatis.pojo.User;

public class JunitTest {
	@Test
	public void testMapper() throws Exception {
		ClassPathXmlApplicationContext ac= new ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper userMapper = ac.getBean(UserMapper.class);
		//UserMapper userMapper = (UserMapper) ac.getBean("userMapper");
		User user = userMapper.findUserById(10);
		System.out.println(user);
	}
}
