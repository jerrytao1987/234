package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JDBCUtils_V2 {
	private static Connection conn=null;
	private static String driver=null;
	private static String url=null;
	private static String username=null;
	private static String password=null;
	static{
		
//		ResourceBundle bundle = ResourceBundle.getBundle("db");
		ResourceBundle bundle = ResourceBundle.getBundle("config//db");
		driver = bundle.getString("driver");
		url = bundle.getString("url");
		username = bundle.getString("username");
		password =bundle.getString("password");
	}
	public static Connection getConnection(){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void release(Connection conn,PreparedStatement pst,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pst!=null){
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void release(Connection conn,PreparedStatement pst){
		if(pst!=null){
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
