package cn.itcast.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCDemo2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/mybase";
		String user = "root";
		String password = "123456";
		Connection con = DriverManager.getConnection(url, user, password);

		Statement stat = con.createStatement();
		
		Scanner sc = new Scanner(System.in);
		String username = sc.nextLine();
		String pass = sc.nextLine();
		sc.close();
		String sql = "select * from users where username='"+username+"' and password='"+pass+"'";
		ResultSet rs = stat.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getInt("id") + "  " + rs.getString("username") + "  " + rs.getString("password"));
		}
		rs.close();
		stat.close();
		con.close();
	}

}
