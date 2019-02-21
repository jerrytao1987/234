package cn.itcast.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;


import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cn.itcast.jdbc.utils.C3P0Utils;
import cn.itcast.jdbc.utils.JDBCUtils_V3;

public class TestC3P0 {
	
	@Test
	public void testInsert1(){
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = C3P0Utils.getConnection();
			String sql="insert into tbl_user values(null,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, "吕布3");
			pst.setString(2, "貂蝉3");
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
	
	@Test
	public void testInsert(){
		Connection conn = null;
		PreparedStatement pst = null;
		ComboPooledDataSource dataSource = new ComboPooledDataSource();//加载默认配置
//		ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql");//加载有名称的
		try {
			conn = dataSource.getConnection();
			String sql="insert into tbl_user values(null,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, "吕布1");
			pst.setString(2, "貂蝉1");
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
