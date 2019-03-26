package jdbc;

import java.io.BufferedOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJDBC {
	public static void main(String[] args) throws Exception {
		//1.注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2.获得连接
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bos32", "root", "123456");
		//3.创建执行平台
		Statement stat = con.createStatement();
		//4.编写sql语句
		String sql = "select * from t_user";
		//5.执行查询
		ResultSet result = stat.executeQuery(sql);
		//6.处理结果集
		while(result.next()){
			System.out.println(result.getObject(1));
		}
		//7.释放资源
		result.close();
		stat.close();
		con.close();
	}
}
