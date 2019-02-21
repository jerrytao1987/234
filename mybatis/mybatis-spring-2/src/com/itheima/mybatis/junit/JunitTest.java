package com.itheima.mybatis.junit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.mybatis.mapper.UserMapper;
import com.itheima.mybatis.pojo.User;
import com.itheima.mybatis.pojo.UserExample;


public class JunitTest {
	@Test
	public void testMapper() throws Exception {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		UserMapper userMapper = ac.getBean(UserMapper.class);
		UserExample example = new UserExample();
		String username="明";
		example.createCriteria().andSexEqualTo("1").andUsernameLike("%"+username+"%");
		example.setOrderByClause("id desc");
		int countByExample = userMapper.countByExample(example );
		System.out.println(countByExample);
		
		User user = userMapper.selectByPrimaryKey(10);
		System.out.println(user.getUsername());
		
		List<User> list = userMapper.selectByExample(example);
		for (User user2 : list) {
			System.out.println(user2.getUsername());
		}
		
		
	}
}
