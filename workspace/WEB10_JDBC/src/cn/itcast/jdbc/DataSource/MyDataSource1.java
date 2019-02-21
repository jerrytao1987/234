package cn.itcast.jdbc.DataSource;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;

import cn.itcast.jdbc.utils.JDBCUtils_V3;

public class MyDataSource1 implements DataSource {
	private static LinkedList<Connection> pool = new LinkedList<Connection>();
	static{
		for (int i = 0; i < 5; i++) {
			Connection conn = JDBCUtils_V3.getConnection();
			MyConnection myconn = new MyConnection(conn, pool);
			pool.add(myconn);
		}
	}
	/**
	 * 重写获取连接的方法
	 */
	@Override
	public Connection getConnection() throws SQLException {
		Connection conn=null;
		if(pool.size()==0){
			for (int i = 0; i < 5; i++) {
				conn = JDBCUtils_V3.getConnection();
				pool.add(conn);
			}
		}
		conn=pool.remove(0);
		return conn;
	}
	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return false;
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		return null;
	}

}
