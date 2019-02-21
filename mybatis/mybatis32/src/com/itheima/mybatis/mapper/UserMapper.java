package com.itheima.mybatis.mapper;

import java.util.List;

import com.itheima.mybatis.pojo.QueryVo;
import com.itheima.mybatis.pojo.User;

public interface UserMapper {
	//遵循四个原则
	//接口 方法名 == Mapper.xml 中id名
	//返回值类型与Mapper.xml文件中返回值类型要一致
	//方法的入参类型与Mapper.xml中入参的类型要一致
	//Mapper.xml中的命名空间绑定此接口
	public User findUserById(Integer id);
	public List<User> findUserByQueryVo(QueryVo qv);
	
	public Integer countUser();
	
	public List<User> selectUserBySexAndUsername(User user);
	
//	public List<User> selectUserByIds(Integer[] ids);
	public List<User> selectUserByIds(List<Integer> ids);
//	public List<User> selectUserByIds(QueryVo qv);
	
	public List<User> selectUserList();
}
