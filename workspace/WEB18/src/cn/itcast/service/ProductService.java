package cn.itcast.service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.dao.ProductDao;
import cn.itcast.domain.Product;

public class ProductService {

	public List<Product> findAllProduct() {
		ProductDao dao = new ProductDao();
		List<Product> productList=null;
		try {
			productList = dao.findAllProduct();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}

}
