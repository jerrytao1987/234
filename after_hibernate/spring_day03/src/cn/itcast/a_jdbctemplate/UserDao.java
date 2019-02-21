package cn.itcast.a_jdbctemplate;

import java.util.List;

import cn.itcast.bean.User;

public interface UserDao {
	
	void save(User u);
	void delete(Integer id);
	void update(User u);
	User getById(Integer id);
	int getTotalCount();
	List<User> getAll();
}
