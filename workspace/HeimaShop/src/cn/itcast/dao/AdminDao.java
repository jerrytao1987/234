package cn.itcast.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import cn.itcast.domain.Category;
import cn.itcast.domain.Order;
import cn.itcast.domain.Product;
import cn.itcast.utils.DataSourceUtils;

public class AdminDao {

	public List<Category> findAllCategory() throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from category";
		List<Category> categoryList = qr.query(sql, new BeanListHandler<Category>(Category.class));
		return categoryList;
	}

	public void saveProduct(Product product) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into product value(?,?,?,?,?,?,?,?,?,?)";
		qr.update(sql, product.getPid(),product.getPname(),product.getMarket_price(),product.getShop_price(),product.getPimage(),product.getPdate(),product.getIs_hot(),product.getPdesc(),product.getPflag(),product.getCategory().getCid());
	}

	public List<Order> findAllOrders() throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from orders";
		return qr.query(sql, new BeanListHandler<Order>(Order.class));
	}

	public List<Map<String, Object>> findOrderInfoByOid(String oid) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select p.pimage,p.pname,p.shop_price,i.count,i.subtotal from orderitem i,product p where i.pid=p.pid and i.oid=?";
		List<Map<String, Object>> mapList = qr.query(sql, new MapListHandler(), oid);
		return mapList;
	}

}
