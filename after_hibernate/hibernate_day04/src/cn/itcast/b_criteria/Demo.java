package cn.itcast.b_criteria;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import cn.itcast.domain.Customer;
import cn.itcast.utils.HibernateUtils;

public class Demo {
	
	@Test
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Customer.class);
		List<Customer> list = c.list();
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void fun2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Customer.class);
//		c.add(Restrictions.idEq(2l));
		c.add(Restrictions.eq("cust_id", 2l));
		List<Customer> list = c.list();
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void fun3(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Customer.class);
		c.setFirstResult(0);
		c.setMaxResults(2);
		List<Customer> list = c.list();
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void fun4(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Customer.class);
//		c.addOrder(Order.asc("cust_id"));
		c.addOrder(Order.desc("cust_id"));
		List<Customer> list = c.list();
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void fun5(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Customer.class);
		c.setProjection(Projections.rowCount());
		List<Long> list = c.list();
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
	
}
