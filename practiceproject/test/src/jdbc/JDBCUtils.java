package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtils {
	private static Connection con;
	private JDBCUtils(){
		throw new AssertionError();
	}
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bos32", "root", "123456");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		return con;
	}
	public static void CloseResource(Connection con){
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				con=null;
				e.printStackTrace();
			}
		}
	}
	public static void CloseResource(Connection con,PreparedStatement pst){
		if(pst!=null){
			try {
				pst.close();
			} catch (SQLException e) {
				pst=null;
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				con=null;
				e.printStackTrace();
			}
		}
	}
	public static void CloseResource(Connection con,PreparedStatement pst,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				rs=null;
				e.printStackTrace();
			}
		}
		if(pst!=null){
			try {
				pst.close();
			} catch (SQLException e) {
				pst=null;
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				con=null;
				e.printStackTrace();
			}
		}
	}
}
