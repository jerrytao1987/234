package cn.itcast.service;

import java.sql.SQLException;

import cn.itcast.dao.UserDao;

public class UserService {

	public boolean checkUsername(String username) throws SQLException {
		UserDao dao = new UserDao();
		Long isExist = dao.checkUsername(username);
		return isExist>0?true:false;
	}

}
