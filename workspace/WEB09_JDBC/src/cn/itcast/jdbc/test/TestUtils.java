package cn.itcast.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import cn.itcast.jdbc.JDBCUtils_V1;
import cn.itcast.jdbc.JDBCUtils_V2;
import cn.itcast.jdbc.JDBCUtils_V3;

public class TestUtils {
	
	@Test
	public void testUpdateById(){
		Connection conn = JDBCUtils_V3.getConnection();
		PreparedStatement pst=null;
		String sql = "update tbl_user set upassword=? where uid=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, "999");
			pst.setInt(2, 1);
			int row = pst.executeUpdate();
			if(row>0){
				System.out.println("修改成功");
			}else{
				System.out.println("修改失败");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			JDBCUtils_V3.release(conn, pst);
		}
	}
	@Test
	public void testDeleteById(){
		Connection conn = JDBCUtils_V3.getConnection();
		PreparedStatement pst=null;
		String sql = "delete from tbl_user where uid=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, 2);
			int row = pst.executeUpdate();
			if(row>0){
				System.out.println("删除成功");
			}else{
				System.out.println("删除失败");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			JDBCUtils_V3.release(conn, pst);
		}
	}
	@Test
	public void testInsert(){
		Connection conn = JDBCUtils_V2.getConnection();
		PreparedStatement pst=null;
		String sql = "insert into tbl_user values(null,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, "lisi");
			pst.setString(2, "hehe");
			int row = pst.executeUpdate();
			if(row>0){
				System.out.println("添加成功");
			}else{
				System.out.println("添加失败");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			JDBCUtils_V2.release(conn, pst);
		}
	}
	@Test
	public void testFindUserById(){
		Connection conn = JDBCUtils_V1.getConnection();
		String sql = "select * from tbl_user where uid=?";
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, 1);
			rs = pst.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString(2)+"..."+rs.getString("upassword"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtils_V1.release(conn, pst, rs);
		}
		
	}
}
