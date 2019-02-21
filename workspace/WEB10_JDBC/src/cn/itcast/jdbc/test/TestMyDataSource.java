package cn.itcast.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import cn.itcast.jdbc.DataSource.MyDataSource1;
import cn.itcast.jdbc.utils.JDBCUtils_V3;

public class TestMyDataSource {
	@Test
	public void testInsert(){
		Connection conn = null;
		PreparedStatement pst = null;
		MyDataSource1 dataSource = new MyDataSource1();
		try {
			conn = dataSource.getConnection();
			String sql="insert into tbl_user values(null,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, "吕布");
			pst.setString(2, "貂蝉");
			int row = pst.executeUpdate();
			if (row>0) {
				System.out.println("添加成功！");
			} else {
				System.out.println("添加失败！");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			JDBCUtils_V3.release(conn, pst);
		}
	}
}
