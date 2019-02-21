package cn.itcast.demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.domain.Sort;
import cn.itcast.jdbcutil.JDBCUtils;

public class QueryRunnerDemo1 {
	private static QueryRunner qr = new QueryRunner();
	private static Connection con = JDBCUtils.getConnection();
	public static void main(String[] args) throws SQLException {
//		arrayHandler();
	//	arrayListHandler();
//		beanHandler();
//		beanListHandler();
//		columnListHandler();
//		scalarHandler();
//		mapHandler();
		mapListHandler();
		DbUtils.closeQuietly(con);
	}
	public static void mapListHandler() throws SQLException{
		String sql ="select * from sort";
		List<Map<String, Object>> result = qr.query(con, sql, new MapListHandler());
		for (Map<String, Object> map : result) {
			for (String key : map.keySet()) {
				System.out.print(key + "  "+map.get(key)+"  ");
			}
			System.out.println();
		}
	}
	public static void mapHandler() throws SQLException{
		String sql ="select * from sort";
		Map<String, Object> result = qr.query(con, sql, new MapHandler());
		for (String string : result.keySet()) {
			System.out.println(string+"  "+result.get(string));
		}
	}
	public static void scalarHandler() throws SQLException{
		String sql = "select count(*) from sort";
		Long result = qr.query(con, sql, new ScalarHandler<Long>());
		System.out.println(result);
	}
	public static void columnListHandler() throws SQLException{
		String sql = "select * from sort";
		List<Object> result = qr.query(con, sql, new ColumnListHandler<Object>("sname"));
		for (Object object : result) {
			System.out.println(object);
		}
	}
	public static void beanListHandler() throws SQLException{
		String sql = "select * from sort";
		List<Sort> result = qr.query(con, sql, new BeanListHandler<Sort>(Sort.class));
		for (Sort sort : result) {
			System.out.println(sort);
		}
		
	}
	public static void beanHandler() throws SQLException{
		String sql = "select * from sort";
		Sort s = qr.query(con, sql, new BeanHandler<Sort>(Sort.class));
		System.out.println(s);
		DbUtils.closeQuietly(con);
	}
	public static void arrayListHandler() throws SQLException{
		String sql = "select * from sort";
		List<Object[]> result = qr.query(con, sql, new ArrayListHandler());
		for (Object[] objects : result) {
			for (Object object : objects) {
				System.out.print(object+"\t");
			}
			System.out.println();
		}
		DbUtils.closeQuietly(con);
	}
	public static void arrayHandler() throws SQLException{
		String sql = "select * from sort";
		Object[] result = qr.query(con, sql, new ArrayHandler());
		for (Object obj : result) {
			System.out.print(obj+"\t");
		}
		DbUtils.close(con);
	}
}
