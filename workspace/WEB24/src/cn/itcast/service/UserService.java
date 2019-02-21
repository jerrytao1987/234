package cn.itcast.service;

import java.sql.SQLException;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;

public class UserService {

	public User login(String username, String password) throws SQLException {
		UserDao dao = new UserDao();
		User user = dao.login(username,password);
		return user;
	}

}
