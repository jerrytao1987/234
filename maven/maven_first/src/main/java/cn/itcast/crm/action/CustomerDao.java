package cn.itcast.crm.action;

import java.sql.Connection;

public class CustomerDao {
	public void getConnection(){
		Connection con = JDBCUtils.getConnection();
	}
}
