package cn.itcast.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class JDBCDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/mybase";
		String user = "root";
		String password = "123456";
		Connection con = DriverManager.getConnection(url, user, password);
		
		String sql = "update sort set sname=?,sprice=? where sid = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setObject(1,"汽车美容");
		pst.setObject(2,49998);
		pst.setObject(3,8);
		int row = pst.executeUpdate();
		System.out.println(row);
		
		pst.close();
		con.close();
	}

}
