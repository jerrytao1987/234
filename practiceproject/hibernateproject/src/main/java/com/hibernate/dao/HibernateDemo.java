package com.hibernate.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.hibernate.pojo.Customer;
import com.hibernate.pojo.Linkman;
import com.hibernate.utils.HibernateUtils;

public class HibernateDemo {
	
	@Test
	public void fun1() throws Exception {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer c = session.get(Customer.class, 6l);
		System.out.println(c.getCustMobile());
		c.setCustMobile("13433333336");
		
		tx.commit();
		session.close();
		sf.close();
	}
	@Test
	public void fun2() throws Exception {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Customer c = new Customer();
		Linkman lm1 = new Linkman();
		Linkman lm2 = new Linkman();
		
		c.setCustName("abc");
		lm1.setLkmName("aaa");
		lm2.setLkmName("bbb");
		
		lm1.setCustomer(c);
		lm2.setCustomer(c);
		
		session.save(lm1);
		session.save(lm2);
		
		tx.commit();
	}
	@Test
	public void func3() throws Exception {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Customer c where c.custId=?");
		query.setLong(0, 9l);
		List<Customer> list = query.list();
		for (Customer c : list) {
			System.out.println(c.getCustName());
		}
		tx.commit();
	}
	@Test
	public void func4() throws Exception {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);
		//criteria.add(Restrictions.idEq(9l));
		criteria.add(Restrictions.eq("custId", 9l));
		List<Customer> list = criteria.list();
		String custName = list.get(0).getCustName();
		System.out.println(custName);
		tx.commit();
	}
	@Test
	public void fun5() throws Exception {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select * from cst_customer where cust_id=?");
		query.setParameter(0, 9l);
		query.addEntity(Customer.class);
		List<Customer> list = query.list();
		String custName = list.get(0).getCustName();
		System.out.println(custName);
		tx.commit();
	}
	@Test
	public void fun6() throws Exception {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.getNamedQuery("selectaaa");
		query.setParameter(0, 9l);
		List<Object[]> list = query.list();
		for (Object[] o : list) {
			System.out.println(o[1]);
		}
		tx.commit();
	}
}
