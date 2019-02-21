package cn.itcast.demo1;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;


public class DataSourceDemo {

	public static void main(String[] args) {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/mybase");
		bds.setUsername("root");
		bds.setPassword("123456");
		try {
			Connection conn = bds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据库连接失败");
		}
	}

}
