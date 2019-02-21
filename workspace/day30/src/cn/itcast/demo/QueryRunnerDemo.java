package cn.itcast.demo;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import cn.itcast.jdbcutil.JDBCUtils;

public class QueryRunnerDemo {
	private static QueryRunner qr = new QueryRunner();
	private static Connection con = JDBCUtils.getConnection();
	public static void main(String[] args) throws SQLException {
//		insert();
//		update();
		delete();
	}
	public static void delete() throws SQLException{
		String sql = "delete from sort where sid=?";
		int row = qr.update(con,sql, 10);
		System.out.println(row);
		DbUtils.closeQuietly(con);
	}
	public static void update() throws SQLException{
		String sql = "update sort set sname=?, sprice=?, sdesc=? where sid = ?";
		Object[] params = {"花卉",100.88,"情人节玫瑰花",6};
		int row = qr.update(con,sql, params);
		System.out.println(row);
		DbUtils.closeQuietly(con);
	}
	public static void insert() throws SQLException{
		//QueryRunner qr = new QueryRunner();
		String sql = "insert into sort(sname,sprice,sdesc) values(?,?,?)";
		Object[] params = {"体育用品",289.32,"购买体育用品"};
		int row = qr.update(con, sql,params);
		System.out.println(row);
		DbUtils.closeQuietly(con);
	}
}
