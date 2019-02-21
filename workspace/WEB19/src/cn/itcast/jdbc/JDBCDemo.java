package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:///web19?useSSL=false", "root", "123456");
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
//			stmt.executeUpdate("insert into account values(null,'zhangsan',3000)");
//			stmt.executeUpdate("insert into account values(null,'lisi',3000)");
			int row = stmt.executeUpdate("update account set money=5000 where name='tommmm'");
			if(row>0){
				conn.commit();
			}
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally{
			if(stmt!=null){
				try {
					stmt.close();
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
}
