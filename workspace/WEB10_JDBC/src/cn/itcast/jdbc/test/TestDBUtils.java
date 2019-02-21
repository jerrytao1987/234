package cn.itcast.jdbc.test;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import cn.itcast.jdbc.utils.C3P0Utils;
/**
 * 测试DBUtils工具
 * @author dengting
 *
 */
public class TestDBUtils {
	
	/**
	 * 删除用户方法
	 */
	@Test
	public void testDeleteUserById(){
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "delete from tbl_user where uid=?";
		Object[] param = {10};
		try {
			int row = qr.update(sql, param);
			if (row>0) {
				System.out.println("删除成功！");
			} else {
				System.out.println("删除失败");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 修改用户方法
	 */
	@Test
	public void testUpdateUserById(){
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "update tbl_user set upassword=? where uid=?";
		Object[] param = {"xxx",9};
		try {
			int row = qr.update(sql, param);
			if (row>0) {
				System.out.println("修改成功！");
			} else {
				System.out.println("修改失败");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 添加用户方法
	 */
	@Test
	public void testInsertUser(){
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "insert into tbl_user values(null,?,?)";
		Object[] param = {"余淮","耿耿"};
		try {
			int row = qr.update(sql, param);
			if (row>0) {
				System.out.println("添加成功！");
			} else {
				System.out.println("添加失败");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
