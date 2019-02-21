package cn.itcast.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.domain.Category;
import cn.itcast.domain.Product;
import cn.itcast.utils.DataSourceUtils;
import cn.itcast.vo.Condition;

public class AdminProductDao {

	public List<Product> findAllProduct() throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product";
		List<Product> productList = qr.query(sql, new BeanListHandler<Product>(Product.class));
		return productList;
	}

	public List<Category> findAllCategory() throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from category";
		List<Category> categoryList = qr.query(sql, new BeanListHandler<Category>(Category.class));
		return categoryList;
	}

	public void addProduct(Product product) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into product values(?,?,?,?,?,?,?,?,?,?)";
		qr.update(sql, product.getPid(),product.getPname(),product.getMarket_price(),product.getShop_price(),product.getPimage(),product.getPdate(),product.getIs_hot(),product.getPdesc(),product.getPflag(),product.getCid());
		
	}

	public void delProductByPid(String pid) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from product where pid=?";
		qr.update(sql, pid);
	}

	public void delAllbyId(String delId) throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "update product set pflag=1 where pid=?";
		Connection conn = DataSourceUtils.getCurrentConnection();
		int row = qr.update(conn, sql, delId);
	}
	public void delAllbyId(String[][] delId) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update product set pflag=1 where pid=?";
		qr.batch( sql, delId);
	}

	public Product findProductByPid(String pid) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where pid=?";
		Product product = qr.query(sql, new BeanHandler<Product>(Product.class), pid);
		return product;
	}

	public void updateProduct(Product product) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update product set pname=?,market_price=?,shop_price=?,pimage=?,pdate=?,is_hot=?,pdesc=?,pflag=?,cid=? where pid=?";
		qr.update(sql, product.getPname(),product.getMarket_price(),product.getShop_price(),product.getPimage(),product.getPdate(),product.getIs_hot(),product.getPdesc(),product.getPflag(),product.getCid(),product.getPid());
		
	}

	public List<Product> findProductListByCondition(Condition condition) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where 1=1";
		List<String> list = new ArrayList<String>();
		if(condition.getPname()!=null&&!condition.getPname().trim().equals("")){
			sql +=" and pname like ?";
			list.add("%"+condition.getPname().trim()+"%");
		}
		if(condition.getIs_hot()!=null&&!condition.getIs_hot().trim().equals("")){
			sql +=" and is_hot=?";
			list.add(condition.getIs_hot());
		}
		if(condition.getCid()!=null&&!condition.getCid().trim().equals("")){
			sql +=" and cid=?";
			list.add(condition.getCid());
		}
		List<Product> productList = qr.query(sql, new BeanListHandler<Product>(Product.class), list.toArray());
		return productList;
	}

}
