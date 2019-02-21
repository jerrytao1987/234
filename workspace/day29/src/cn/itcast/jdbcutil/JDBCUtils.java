package cn.itcast.jdbcutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;


public class JDBCUtils {
	private static Connection con;
	private JDBCUtils(){};
	static{
		
		try {
			InputStream in = JDBCUtils.class.getClassLoader().getResourceAsStream("config//database.properties");
			Properties pro = new Properties();
			pro.load(in);
			
			Class.forName(pro.getProperty("driverClass"));
			
			/*String url = "jdbc:mysql://localhost:3306/mybase";
			String user = "root";
			String password = "123456";*/
			con = DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("user"), pro.getProperty("password"));
		} catch (Exception e) {
			throw new RuntimeException(e+"数据库连接失败！");
		}
	}
	public static Connection getConnection(){
		return con;
	}
	public static void close(Connection con,Statement stat,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		if(stat!=null){
			try {
				stat.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public static void close(Connection con,Statement stat){
		if(stat!=null){
			try {
				stat.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
}
