package cn.itcast.service;

import java.sql.SQLException;

import cn.itcast.dao.ProductInfoDao;
import cn.itcast.domain.Product;

public class ProductInfoService {

	public Product findProductByPid(String pid) {
		ProductInfoDao dao = new ProductInfoDao();
		Product product=null;
		try {
			product = dao.findProductByPid(pid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

}
