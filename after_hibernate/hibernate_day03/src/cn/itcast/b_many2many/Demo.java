package cn.itcast.b_many2many;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.domain.Customer;
import cn.itcast.domain.LinkMan;
import cn.itcast.domain.Role;
import cn.itcast.domain.User;
import cn.itcast.utils.HibernateUtils;

public class Demo {
	
	@Test
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		User u1 = new User();
		u1.setUser_name("郝强勇");
		User u2 = new User();
		u2.setUser_name("金家德");
		Role r1 = new Role();
		r1.setRole_name("保洁");
		Role r2 = new Role();
		r2.setRole_name("保安");
		
		u1.getRoles().add(r1);
		u1.getRoles().add(r2);
		u2.getRoles().add(r1);
		u2.getRoles().add(r2);
		r1.getUsers().add(u1);
		r1.getUsers().add(u2);
		r2.getUsers().add(u1);
		r2.getUsers().add(u2);
		
		session.save(u1);
		session.save(u2);
		session.save(r1);
		session.save(r2);
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void fun2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		User user = session.get(User.class, 1l);
		Role r = new Role();
		r.setRole_name("男公关");
		user.getRoles().add(r);
//		session.save(r);
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void fun3(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		User user = session.get(User.class, 1l);
		Role r1 = session.get(Role.class, 1l);
		Role r2 = session.get(Role.class, 2l);
		user.getRoles().remove(r1);
		user.getRoles().remove(r2);
		
		
		tx.commit();
		session.close();
	}
	
}
