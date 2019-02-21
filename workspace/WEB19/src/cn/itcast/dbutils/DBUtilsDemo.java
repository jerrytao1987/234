package cn.itcast.dbutils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import cn.itcast.utils.C3P0Utils;

public class DBUtilsDemo {
	public static void main(String[] args) {
		Connection conn=null;
		QueryRunner qr = new QueryRunner();
		conn = C3P0Utils.getConnection();
		try {
			conn.setAutoCommit(false);
//			qr.update("update account set money=15000 where name='tom'");
			int row = qr.update(conn, "update account set money=15000 where name='tom'");
			if(row>0){
				conn.commit();
			}else{
				conn.rollback();
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}
}
