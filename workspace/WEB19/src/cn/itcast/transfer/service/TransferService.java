package cn.itcast.transfer.service;

import java.sql.Connection;
import java.sql.SQLException;

import cn.itcast.transfer.dao.TransferDao;
import cn.itcast.utils.C3P0Utils;
import cn.itcast.utils.MyDataSourceUtils;

public class TransferService {

	public boolean transfer(String out, String in, double money) {
		TransferDao dao = new TransferDao();
		boolean isTranferSuccess = true;
//		Connection conn=null;
		try {
//			conn = C3P0Utils.getConnection();
//			conn.setAutoCommit(false);
			MyDataSourceUtils.startTransaction();
//			dao.out(conn,out,money);
			dao.out(out, money);
//			int i=1/0;
//			dao.in(conn,in,money);
			dao.in(in, money);
		} catch (Exception e) {
			isTranferSuccess=false;
			try {
//				conn.rollback();//默认没有提交功能,没有结束,归还连接后，连接没有关闭，可能其他使用该连接存在之前的，可能出问题
				MyDataSourceUtils.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
//				conn.commit();
				MyDataSourceUtils.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return isTranferSuccess;
	}

}
