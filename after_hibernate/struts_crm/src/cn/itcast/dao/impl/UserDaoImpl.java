package cn.itcast.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.utils.HibernateUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public User getByUserCode(String user_code) {
		Session session = HibernateUtils.getCurrentSession();
		String hql = "from User where user_code = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, user_code);
		User user = (User) query.uniqueResult();
		return user;
	}

}
