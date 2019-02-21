package cn.itcast.jdbc.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import cn.itcast.domain.User;
import cn.itcast.jdbc.utils.C3P0Utils;
/**
 * 测试DBUtils工具
 * @author dengting
 *
 */
public class TestDBUtils1 {
	
	/**
	 * 查询所有用户方法
	 */
	@Test
	public void testQueryUser1(){
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from tbl_user";
		try {
			List<Object> list = qr.query(sql, new ColumnListHandler("uname"));
			for (Object obj : list) {
				System.out.println(obj);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 查询所有用户方法
	 */
	@Test
	public void testQueryUser(){
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from tbl_user";
		try {
			List<Map<String, Object>> list = qr.query(sql, new MapListHandler());
			for (Map<String, Object> map : list) {
				System.out.println(map);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 查询所有用户的总个数方法
	 */
	@Test
	public void testCountUser(){
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select count(*) from tbl_user";
		try {
			long count = (long) qr.query(sql, new ScalarHandler());
			System.out.println(count);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 根据id查询用户方法
	 */
	@Test
	public void testSelectUserById(){
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from tbl_user where uid=?";
		Object[] param = {8};
		try {
			User user = qr.query(sql, new BeanHandler<User>(User.class),param);
			System.out.println(user.getUname()+":"+user.getUpassword());;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 查询所有用户方法
	 */
	@Test
	public void testSelectUser(){
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from tbl_user";
		try {
			List<User> users = qr.query(sql, new BeanListHandler<User>(User.class));
			for (User user : users) {
				System.out.println(user.getUname()+":"+user.getUpassword());;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
