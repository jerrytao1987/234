package cn.itcast.a_one2many;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.domain.Customer;
import cn.itcast.domain.LinkMan;
import cn.itcast.utils.HibernateUtils;

public class Demo2 {
	
	@Test
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer c = new Customer();
		c.setCust_name("传智播客");
		
		LinkMan lm1 = new LinkMan();
		lm1.setLkm_name("黎活明");
		
		LinkMan lm2 = new LinkMan();
		lm2.setLkm_name("刘悦东");
		
		c.getLinkMen().add(lm1);
		c.getLinkMen().add(lm2);
		
		lm1.setCustomer(c);
		lm2.setCustomer(c);
		
		session.save(c);
		
		tx.commit();
		session.close();
	}
	@Test
	public void fun2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer c = session.get(Customer.class, 1l);
		session.delete(c);
		
		tx.commit();
		session.close();
	}
	@Test
	public void fun3(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer c = new Customer();
		c.setCust_name("北大青鸟");
		
		LinkMan lm1 = new LinkMan();
		lm1.setLkm_name("刘总");
		
		
		c.getLinkMen().add(lm1);
		
		lm1.setCustomer(c);
		
		session.save(lm1);
		
		tx.commit();
		session.close();
	}
	
}
