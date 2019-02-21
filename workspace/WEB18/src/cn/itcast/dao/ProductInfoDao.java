package cn.itcast.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.domain.Product;
import cn.itcast.utils.C3P0Utils;

public class ProductInfoDao {

	public Product findProductByPid(String pid) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from product where pid=?";
		Product product = qr.query(sql, new BeanHandler<Product>(Product.class), pid);
		return product;
	}

}
