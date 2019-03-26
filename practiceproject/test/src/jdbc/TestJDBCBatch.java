package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBCBatch {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		/*Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bos32", "root", "123456");
		Statement cst = con.createStatement();
		String sql = "insert into t_user(id,username,password) values('2','abc','abc')";
		String sql1 =  "insert into t_user(id,username,password) values('3','bcd','bcd')";
		cst.addBatch(sql);
		cst.addBatch(sql1);
		int[] batch = cst.executeBatch();
		cst.close();
		con.close();*/
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bos32", "root", "123456");
		String sql = "insert into t_user(id,username,password) values(?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, "4");
		pst.setString(2, "aaa");
		pst.setString(3, "aaa");
		pst.addBatch();
		pst.setString(1, "5");
		pst.setString(2, "bbb");
		pst.setString(3, "bbb");
		pst.addBatch();
		int[] batch = pst.executeBatch();
		pst.close();
		con.close();
	}
}
