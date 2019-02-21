package cn.itcast.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.domain.Product;
import cn.itcast.utils.C3P0Utils;

public class ProductDao {

	public List<Product> findAllProduct() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product";
		List<Product> productList = qr.query(sql, new BeanListHandler<Product>(Product.class));
		return productList;
	}

}
