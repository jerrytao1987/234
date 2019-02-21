package com.itheima.mybatis.junit;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.itheima.mybatis.dao.UserDaoImpl;
import com.itheima.mybatis.pojo.User;

public class MybatisDaoTest {
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void before() throws Exception{
		String resource="SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
	}

	@Test
	public void testDao(){
		UserDaoImpl userDao = new UserDaoImpl(sqlSessionFactory);
		User user = userDao.selectUserById(16);
		System.out.println(user);
	}
}
