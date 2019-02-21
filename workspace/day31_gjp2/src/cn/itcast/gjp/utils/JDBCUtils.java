package cn.itcast.gjp.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class JDBCUtils {
	private static BasicDataSource ds = new BasicDataSource();
	static{
		Properties db = new Properties();
		InputStream in = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
		try {
			db.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ds.setDriverClassName(db.getProperty("jdbc.driverClassName"));
		ds.setUrl(db.getProperty("jdbc.url"));
		ds.setUsername(db.getProperty("jdbc.username"));
		ds.setPassword(db.getProperty("jdbc.password"));
		ds.setInitialSize(Integer.parseInt(db.getProperty("jdbc.initialSize")));
		ds.setMaxActive(Integer.parseInt(db.getProperty("jdbc.maxActive")));
		ds.setMaxIdle(Integer.parseInt(db.getProperty("jdbc.maxIdle")));
		ds.setMinIdle(Integer.parseInt(db.getProperty("jdbc.minIdle")));
	}
	private JDBCUtils(){
		
	}
	public static DataSource getDataSource(){
		return ds;
	}
	
}
