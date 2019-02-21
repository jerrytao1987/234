package cn.itcast.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//DriverManager.registerDriver(new Driver()); 
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/mybase";
		String user = "root";
		String password = "123456";
		Connection con = DriverManager.getConnection(url, user, password);
		
		Statement stat = con.createStatement();
		
		int row = stat.executeUpdate("INSERT INTO sort(sname,sprice,sdesc) VALUES('汽车用品',5000,'打发第三方')");
		System.out.println(row);
		stat.close();
		con.close();
	}

}
