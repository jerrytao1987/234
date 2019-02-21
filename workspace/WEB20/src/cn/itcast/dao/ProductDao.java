package cn.itcast.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.domain.Product;
import cn.itcast.utils.DataSourceUtils;

public class ProductDao {

	public List<Product> findAllProduct() throws SQLException {
		return new QueryRunner(DataSourceUtils.getDataSource()).query("select * from product ", new BeanListHandler<Product>(Product.class));
	}

	public int getTotalCount() throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from product";
		Long query = (Long)qr.query(sql, new ScalarHandler());
		return query.intValue();
	}
	public int getTotalCount(String pname) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from product where pname like ?";
		Long query = (Long)qr.query(sql, new ScalarHandler(),"%"+pname+"%");
		return query.intValue();
	}

	public List<Product> findProductListForPageBean(int index, int currentCount) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product limit ?,?";
		List<Product> productList = qr.query(sql, new BeanListHandler<Product>(Product.class), index,currentCount);
		return productList;
	}

	public List<Product> findProductByWord(String word) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where pname like ? limit 0,8";
		List<Product> productList = qr.query(sql, new BeanListHandler<Product>(Product.class), "%"+word+"%");
		return productList;
	}

	public List<Product> findProductListForPageBean(int index, int currentCount, String pname) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where pname like ? limit ?,?";
		List<Product> productList = qr.query(sql, new BeanListHandler<Product>(Product.class), "%"+pname+"%", index,currentCount);
		return productList;
	}

}
