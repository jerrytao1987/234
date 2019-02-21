package com.itheima.jd.dao;

import java.util.List;

import com.itheima.jd.pojo.ProductModel;

public interface JdDao {
	public List<ProductModel> selectProductModelListByQuery(String queryString,String catalog_name,String price,String sort) throws Exception;
}
