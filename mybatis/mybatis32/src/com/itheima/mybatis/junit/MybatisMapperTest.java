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

public class MybatisMapperTest {

	@Test
	public void testMapper() throws Exception {
		// 加载核心配置文件
		String resource = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(16);
		System.out.println(user);
	}
	
	@Test
	public void testMapperQueryVo() throws Exception {
		// 加载核心配置文件
		String resource = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		QueryVo qv = new QueryVo();
		User user = new User();
		user.setUsername("五");
		qv.setUser(user);
		
		List<User> us = userMapper.findUserByQueryVo(qv);
		for (User u : us) {
			System.out.println(u);
		}
	}
	@Test
	public void testMapperQueryVoCountUser() throws Exception {
		// 加载核心配置文件
		String resource = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		Integer count = userMapper.countUser();
		System.out.println(count);
	}
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
				List<Orders> list = orderMapper.findAll();
				for (Orders orders : list) {
					System.out.println(orders);
				}
	}
	@Test
	public void testfindUserBySexAndUsername() throws Exception {
		// 加载核心配置文件
				String resource = "SqlMapConfig.xml";
				InputStream in = Resources.getResourceAsStream(resource);
				// 创建SqlSessionFactory
				SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
				// 创建SqlSession
				SqlSession sqlSession = sqlSessionFactory.openSession();
				
				UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
				User user = new User();
				//user.setSex("1");
				//user.setUsername("张小明");
				List<User> list = userMapper.selectUserBySexAndUsername(user );
				for (User u : list) {
					System.out.println(u);
				}
	}
	@Test
	public void testfindUserIds() throws Exception {
		// 加载核心配置文件
		String resource = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		// 创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		/*QueryVo qv = new QueryVo();
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(16);
		ids.add(22);
		ids.add(24);
		qv.setIdsList(ids);
		List<User> list = userMapper.selectUserByIds(qv);*/
		/*Integer[] ids = new Integer[]{16,22,24};
		List<User> list = userMapper.selectUserByIds(ids);*/
		List<Integer> ids = new ArrayList<>();
		ids.add(16);
		ids.add(24);
		ids.add(22);
		List<User> list = userMapper.selectUserByIds(ids);
		for (User u : list) {
			System.out.println(u);
		}
	}
}
