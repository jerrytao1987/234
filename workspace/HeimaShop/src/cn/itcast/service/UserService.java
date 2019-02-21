package cn.itcast.service;

import java.sql.SQLException;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;

public class UserService {

	public boolean regist(User user) {
		
		UserDao dao = new UserDao();
		int row=0;
		try {
			row = dao.regist(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row>0?true:false;
	}

	public void active(String activeCode) {
		UserDao dao = new UserDao();
		try {
			dao.active(activeCode);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean checkUsername(String username) {
		UserDao dao = new UserDao();
		Long isExist=0L;
		try {
			isExist = dao.checkUsername(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isExist>0?true:false;
	}

	public User findUser(String username, String password) {
		UserDao dao = new UserDao();
		User user = null;
		try {
			user = dao.findUser(username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
