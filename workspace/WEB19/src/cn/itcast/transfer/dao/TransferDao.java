package cn.itcast.transfer.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import cn.itcast.utils.C3P0Utils;
import cn.itcast.utils.MyDataSourceUtils;

public class TransferDao {

	public void out(String out, double money) throws SQLException {
		QueryRunner qr = new QueryRunner();
//		Connection conn = C3P0Utils.getConnection();
		Connection conn = MyDataSourceUtils.getCurrentConnection();
		String sql = "update account set money=money-? where name=?";
		qr.update(conn, sql,money,out);
	}

	public void in(String in, double money) throws SQLException {
		QueryRunner qr = new QueryRunner();
//		Connection conn = C3P0Utils.getConnection();
		Connection conn = MyDataSourceUtils.getCurrentConnection();
		String sql = "update account set money=money+? where name=?";
		qr.update(conn, sql,money,in);
	}

}
