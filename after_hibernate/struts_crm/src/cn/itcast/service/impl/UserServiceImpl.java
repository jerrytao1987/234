package cn.itcast.service.impl;

import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.utils.HibernateUtils;

public class UserServiceImpl implements UserService {

	private UserDao ud;

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	@Override
	public User login(User user) {
		HibernateUtils.getCurrentSession().beginTransaction();
		User existU = ud .getByUserCode(user.getUser_code());
		HibernateUtils.getCurrentSession().getTransaction().commit();
		if(existU==null){
			throw new RuntimeException("用户名不存在！");
		}
		if(!existU.getUser_password().equals(user.getUser_password())){
			throw new RuntimeException("密码错误！");
		}
		return existU;
	}

}
