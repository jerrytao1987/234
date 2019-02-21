package com.itheima.mybatis.junit;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.itheima.mybatis.mapper.OrderMapper;
import com.itheima.mybatis.mapper.UserMapper;
import com.itheima.mybatis.pojo.Orders;
import com.itheima.mybatis.pojo.QueryVo;
import com.itheima.mybatis.pojo.User;

public class MybatisMapperTest2 {

	@Test
	public void testOrderList() throws Exception {
		// 加载核心配置文件
		String resource = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<Orders> list = orderMapper.selectOrdersList();
		for (Orders orders : list) {
			System.out.println(orders);
		}
	}
	@Test
	public void testUserList() throws Exception {
		// 加载核心配置文件
		String resource = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserMapper UserMapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = UserMapper.selectUserList();
		for (User user : list) {
			System.out.println(user);
		}
	}
	
}
