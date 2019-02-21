package cn.itcast.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import cn.itcast.jdbc.utils.DBCPUtils;
import cn.itcast.jdbc.utils.JDBCUtils_V3;

public class TestDBCP {
	@Test
	public void testUpdateUserById(){
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBCPUtils.getConnection();
			String sql = "update tbl_user set upassword=? where uid=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, "柳岩");
			pst.setInt(2, 9);
			int rows = pst.executeUpdate();
			if (rows>0) {
				System.out.println("更新成功");
			}else{
				System.out.println("更新失败");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			JDBCUtils_V3.release(conn, pst);
		}
	}
}
