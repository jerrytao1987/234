package cn.itcast.a_generator;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.domain.Customer;
import cn.itcast.utils.HibernateUtils;

public class Demo {
	
	@Test
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction ta = session.beginTransaction();
		
		Customer c = new Customer();
		c.setCust_name("联想");
		
		session.save(c);
		
		ta.commit();
		session.close();
		
	}
}
