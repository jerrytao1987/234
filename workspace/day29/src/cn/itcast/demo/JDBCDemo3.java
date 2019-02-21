package cn.itcast.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCDemo3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/mybase";
		String user = "root";
		String password = "123456";
		Connection con = DriverManager.getConnection(url, user, password);

		
		
		Scanner sc = new Scanner(System.in);
		String username = sc.nextLine();
		String pass = sc.nextLine();
		//sc.close();
		String sql = "select * from users where username=? and password= ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setObject(1, username);
		pst.setObject(2, pass);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt("id") + "  " + rs.getString("username") + "  " + rs.getString("password"));
		}
		rs.close();
		pst.close();
		con.close();
	}

}
