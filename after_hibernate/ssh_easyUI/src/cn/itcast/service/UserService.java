package cn.itcast.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.User;
import cn.itcast.utils.PageBean;

public interface UserService {
	User getUserByCodePassword(User u);
	void saveUser(User u);
	PageBean<User> getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	User getById(Long user_id);
	void deleteById(Long user_id);
}
