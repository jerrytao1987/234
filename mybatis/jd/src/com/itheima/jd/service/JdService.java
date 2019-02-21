package com.itheima.jd.service;

import java.util.List;

import com.itheima.jd.pojo.ProductModel;

public interface JdService {
	public List<ProductModel> selectProductModelListByQuery(String queryString,String catalog_name,String price,String sort) throws Exception;
}
