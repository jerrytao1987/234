package com.itheima.mybatis.junit;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.itheima.mybatis.pojo.User;

public class MaybatisFirstTest {
	@Test
	public void testMybatis() throws Exception{
		//加载核心配置文件
		String resource="SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		User user = sqlSession.selectOne("test.findUserById", 10);
		System.out.println(user);
	}
	@Test
	public void testMybatis2() throws Exception{
		//加载核心配置文件
		String resource="SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		List<User> list = sqlSession.selectList("test.findUserByUsername", "张");
		for (User user : list) {
			System.out.println(user);
		}
	}
	@Test
	public void testMybatis3() throws Exception{
		//加载核心配置文件
		String resource="SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		User user = new User();
		user.setUsername("何炅");
		user.setBirthday(new Date());
		user.setAddress("adsfadf");
		user.setSex("男");
		sqlSession.insert("test.insertUser", user);
		sqlSession.commit();
		
		//添加成功后保存订单
		System.out.println(user.getId());
	}
	@Test
	public void testMybatis4() throws Exception{
		//加载核心配置文件
		String resource="SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		User user = new User();
		user.setId(29);
		user.setUsername("何炅222");
		user.setBirthday(new Date());
		user.setAddress("2222adsfadf");
		user.setSex("女");
		sqlSession.update("test.updateUserById", user);
		sqlSession.commit();
	}
	@Test
	public void testMybatis5() throws Exception{
		//加载核心配置文件
		String resource="SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		sqlSession.delete("test.deleteUserById", 29);
		sqlSession.commit();
	}
}
