package cn.itcast.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.domain.Category;
import cn.itcast.domain.Order;
import cn.itcast.domain.OrderItem;
import cn.itcast.domain.Product;
import cn.itcast.utils.DataSourceUtils;

public class ProductDao {

	public List<Product> findHotProductList() throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where is_hot=? limit ?,?";
		List<Product> hotProductList = qr.query(sql, new BeanListHandler<Product>(Product.class),1,0,9);
		return hotProductList;
	}

	public List<Product> findNewProductList() throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product order by pdate limit ?,?";
		List<Product> newProductList = qr.query(sql, new BeanListHandler<Product>(Product.class),0,9);
		return newProductList;
	}

	public List<Category> findAllCategory() throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from category";
		List<Category> categoryList = qr.query(sql, new BeanListHandler<Category>(Category.class));
		return categoryList;
	}

	public int getCount(String cid) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from product where cid=?";
		Long query = (Long) qr.query(sql, new ScalarHandler(),cid);
		return query.intValue();
	}

	public List<Product> findProductByPage(String cid, int index, int currentCount) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where cid=? limit ?,?";
		List<Product> list = qr.query(sql, new BeanListHandler<Product>(Product.class), cid,index,currentCount);
		return list;
	}

	public Product findProductByPid(String pid) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where pid=?";
		Product product = qr.query(sql, new BeanHandler<Product>(Product.class),pid);
		return product;
	}

	public void addOrders(Order order) throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "insert into orders values(?,?,?,?,?,?,?,?)";
		Connection conn = DataSourceUtils.getConnection();
		qr.update(conn, sql, order.getOid(),order.getOrdertime(),order.getTotal(),order.getState(),order.getAddress(),order.getName(),order.getTelephone(),order.getUser().getUid());
		
	}

	public void addOrderItem(Order order) throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "insert into orderItem values(?,?,?,?,?)";
		Connection conn = DataSourceUtils.getConnection();
		List<OrderItem> orderItems = order.getOrderItems();
		for (OrderItem orderItem : orderItems) {
			qr.update(conn, sql, orderItem.getItemid(),orderItem.getCount(),orderItem.getSubtotal(),orderItem.getProduct().getPid(),order.getOid());
		}
		
	}

	public void updateOrderAddr(Order order) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update orders set address=?,name=?,telephone=? where oid=?";
		qr.update(sql, order.getAddress(),order.getName(),order.getTelephone(),order.getOid());
	}

	public void updateOrderState(String r6_Order) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update orders set state=? where oid=?";
		qr.update(sql,1,r6_Order);
	}

	public List<Order> findAllOrders(String uid) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from orders where uid=?";
		List<Order> orderList = qr.query(sql, new BeanListHandler<Order>(Order.class), uid);
		return orderList;
	}

	public List<Map<String, Object>> findAllOrderItemByOid(String oid) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select i.count,i.subtotal,p.pname,p.shop_price,p.pimage from orderItem i,product p where i.pid=p.pid and i.oid=?";
		List<Map<String, Object>> mapList = qr.query(sql, new MapListHandler(), oid);
		return mapList;
	}

}
