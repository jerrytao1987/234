package cn.itcast.jdbc.utils;

import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * 使用c3p0连接池工具
 * @author dengting
 *
 */
public class C3P0Utils {
	//使用命名配置<named-config name="mysql">,不带参数使用默认配置<default-config>
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql");
	private C3P0Utils(){}
	/**
	 * 获得连接池
	 * @return
	 */
	public static DataSource getDataSource(){
		return dataSource;
	}
	/**
	 * 获得连接
	 * @return
	 */
	public static Connection getConnection(){
		try {
			return dataSource.getConnection();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
