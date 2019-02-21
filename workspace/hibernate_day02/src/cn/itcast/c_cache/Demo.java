package cn.itcast.c_cache;

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
		
		Customer c1 = session.get(Customer.class, 1l);
		Customer c2 = session.get(Customer.class, 1l);
		Customer c3 = session.get(Customer.class, 1l);
		Customer c4 = session.get(Customer.class, 1l);
		Customer c5 = session.get(Customer.class, 1l);
		
		System.out.println(c3==c5);
		
		ta.commit();
		session.close();
		
	}
	@Test
	public void fun2(){
		Session session = HibernateUtils.openSession();
		Transaction ta = session.beginTransaction();
		
		Customer c1 = session.get(Customer.class, 1l);
		c1.setCust_name("哈哈");
		c1.setCust_name("传智播客");
		
		
		ta.commit();
		session.close();
		
	}
	@Test
	public void fun3(){
		Session session = HibernateUtils.openSession();
		Transaction ta = session.beginTransaction();
		
		Customer c1 = new Customer();
		c1.setCust_id(1l);
		session.update(c1);
		
		Customer c2 = session.get(Customer.class, 1l);
		
		ta.commit();
		session.close();
		
	}
}
