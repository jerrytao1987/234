package cn.itcast.f_criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import cn.itcast.domain.Customer;
import cn.itcast.utils.HibernateUtils;

public class Demo {
	
	@Test
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction ta = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Customer.class);//查询所有的Customer对象
		List<Customer> list = criteria.list();
		
//		Customer c = (Customer) criteria.uniqueResult();
		System.out.println(list);
		
		ta.commit();
		session.close();
		
	}
	
	@Test
	public void fun2(){
		Session session = HibernateUtils.openSession();
		Transaction ta = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Customer.class);//查询所有的Customer对象
		criteria.add(Restrictions.eq("cust_id", 1l));
		
		Customer c = (Customer) criteria.uniqueResult();
		System.out.println(c);
		
		ta.commit();
		session.close();
		
	}
	
	@Test
	public void fun3(){
		Session session = HibernateUtils.openSession();
		Transaction ta = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Customer.class);//查询所有的Customer对象
		criteria.setFirstResult(0);
		criteria.setMaxResults(1);
		List<Customer> list = criteria.list();
		System.out.println(list);
		
		ta.commit();
		session.close();
		
	}
	
	@Test
	public void fun4(){
		Session session = HibernateUtils.openSession();
		Transaction ta = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Customer.class);//查询所有的Customer对象
		criteria.setProjection(Projections.rowCount());
		Long count = (Long) criteria.uniqueResult();
		System.out.println(count);
		
		ta.commit();
		session.close();
		
	}
	
	
	
}
