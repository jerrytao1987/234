package com.itheima.mybatis.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
	
	public void insertUser(String arg0,String arg1){
		this.getSqlSession().insert(arg0, arg1);
	}
}
