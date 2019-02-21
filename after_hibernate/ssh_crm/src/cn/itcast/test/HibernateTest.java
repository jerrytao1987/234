package cn.itcast.test;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {
	@Resource(name="sessionFactory")
	private SessionFactory sf;
	@Test
	public void fun1(){
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		User u = new User();
		u.setUser_code("tom");
		u.setUser_name("汤姆");
		u.setUser_password("123456");
		
		session.save(u);
		
		tx.commit();
		session.close();
		sf.close();
	}
	
	@Test
	public void fun2(){
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		User u = new User();
		u.setUser_code("jerry");
		u.setUser_name("吉瑞");
		u.setUser_password("123456");
		
		session.save(u);
		
		tx.commit();
		session.close();
	}
	@Test
	public void fun3(){
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		User u = new User();
		u.setUser_code("jack");
		u.setUser_name("杰克");
		u.setUser_password("123456");
		
		session.save(u);
		
		tx.commit();
		session.close();
	}
	@Test
	public void fun4(){
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		User u = new User();
		u.setUser_code("rose");
		u.setUser_name("肉丝");
		u.setUser_password("123456");
		
		session.save(u);
		
		tx.commit();
		session.close();
	}
	
	@Resource(name="userDao")
	private UserDao ud;
	@Test
	public void fun5(){
		User u = ud.getByUserCode("tom");
		System.out.println(u);
	}
	
	@Resource(name="userService")
	private UserService us;
	@Test
	public void fun6(){
		User u = new User();
		u.setUser_code("rose2");
		u.setUser_name("肉丝2");
		u.setUser_password("123456");
		us.saveUser(u);
	}
	@Test
	public void fun7(){
		User u = new User();
		u.setUser_code("rose3");
		u.setUser_name("肉丝3");
		u.setUser_password("123456");
		us.saveUser(u);
	}
}
