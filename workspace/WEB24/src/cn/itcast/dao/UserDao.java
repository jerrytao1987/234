package cn.itcast.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.domain.User;
import cn.itcast.utils.DataSourceUtils;

public class UserDao {

	public User login(String username, String password) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username=? and password=?";
		User user = qr.query(sql, new BeanHandler<User>(User.class), username,password);
		return user;
	}

}
