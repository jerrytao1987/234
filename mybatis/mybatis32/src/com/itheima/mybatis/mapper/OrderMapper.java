package com.itheima.mybatis.mapper;

import java.util.List;

import com.itheima.mybatis.pojo.Orders;

public interface OrderMapper {
	public List<Orders> findAll();
	
	public List<Orders> selectOrdersList();
}
