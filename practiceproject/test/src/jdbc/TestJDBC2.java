package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestJDBC2 {
	public static void main(String[] args) throws Exception {
		//1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2.获得连接
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bos32", "root", "123456");
		//3.获得预处理对象
		String sql="select * from t_user where username=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, "jerry");
		//4.执行查询
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString(1)+" "+rs.getString("username"));
		}
		//5.释放资源
		rs.close();
		pst.close();
		con.close();
	}
}
