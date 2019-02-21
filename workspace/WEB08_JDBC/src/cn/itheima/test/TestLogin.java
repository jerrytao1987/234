package cn.itheima.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class TestLogin {
	
	@Test
	public void testLogin(){
		try {
//			login("老王","666");
//			login("aa","1' or '1==1");//sql注入攻击
			login1("aa","1' or '1==1");//防止sql注入攻击
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void login(String username,String password) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web08?useSSL=false","root","123456");
		Statement stat = conn.createStatement();
		String sql = "select * from tbl_user where uname='"+username+"' and upassword='"+password+"'";
		ResultSet rs = stat.executeQuery(sql);
		if(rs.next()){
			System.out.println("恭喜您！"+username+"登录成功！");
			
		}else{
			System.out.println("账号或者密码错误！");
		}
		if(rs!=null){
			rs.close();
		}
		if(stat!=null){
			stat.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
	public void login1(String username,String password) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/web08?useSSL=false", "root", "123456");
		String sql="select * from tbl_user where uname=? and upassword=?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, username);
		pst.setString(2, password);
		ResultSet rs = pst.executeQuery();
		if(rs.next()){
			System.out.println("恭喜您！"+username+"登录成功！");
			
		}else{
			System.out.println("账号或者密码错误！");
		}
		if(rs!=null){
			rs.close();
		}
		if(pst!=null){
			pst.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
}
