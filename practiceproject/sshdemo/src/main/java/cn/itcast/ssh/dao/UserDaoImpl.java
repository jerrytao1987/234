package cn.itcast.ssh.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.itcast.ssh.pojo.Users;
@Repository
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	@Autowired
	public void setSF(SessionFactory sf){
		super.setSessionFactory(sf);
	}
	public Users findByUsername(final String username) {
		Users user = this.getHibernateTemplate().execute(new HibernateCallback<Users>() {

			public Users doInHibernate(Session session) throws HibernateException {
				String hql="from Users where username=?";
				Query query = session.createQuery(hql);
				query.setParameter(0, username);
				List<Users> list = query.list();
//				Users user = (Users) query.uniqueResult();
				return list.get(0);
			}
			
		});
		return user;
	}
	public Users login(Users user) {
		List<Users> list = (List<Users>) this.getHibernateTemplate().find("from Users where username = ? and password = ?", user.getUsername(),user.getPassword());
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
