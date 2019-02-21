package cn.itcast.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class JDBCDemo1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/mybase";
		String user = "root";
		String password = "123456";
		Connection con = DriverManager.getConnection(url, user, password);
		
		Statement stat = con.createStatement();
		
		String sql = "select * from sort";
		ResultSet rs = stat.executeQuery(sql);
		while(rs.next()){
			System.out.println(rs.getInt("sid")+"  "+rs.getString("sname")+"  "+rs.getDouble("sprice")+"  "+rs.getString("sdesc"));
		}
		rs.close();
		stat.close();
		con.close();
	}

}
