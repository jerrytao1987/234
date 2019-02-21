package cn.itcast.dao;

import cn.itcast.domain.User;

public interface UserDao {

	User getByUserCode(String user_code);

}
