package cn.itcast.g_sql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
		
		String sql = "select * from cst_customer";
		SQLQuery query = session.createSQLQuery(sql);
		List<Object[]> list = query.list();
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}
//		query.uniqueResult();
		
		
		ta.commit();
		session.close();
		
	}
	
	@Test
	public void fun2(){
		Session session = HibernateUtils.openSession();
		Transaction ta = session.beginTransaction();
		
		String sql = "select * from cst_customer";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Customer.class);
		List<Customer> list = query.list();
		System.out.println(list);
//		query.uniqueResult();
		
		
		ta.commit();
		session.close();
		
	}
	
	@Test
	public void fun3(){
		Session session = HibernateUtils.openSession();
		Transaction ta = session.beginTransaction();
		
		String sql = "select * from cst_customer where cust_id = ?";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter(0, 1l);
		query.addEntity(Customer.class);
//		List<Customer> list = query.list();
		Customer c = (Customer) query.uniqueResult();
		System.out.println(c);
//		query.uniqueResult();
		
		
		ta.commit();
		session.close();
		
	}
	
	@Test
	public void fun4(){
		Session session = HibernateUtils.openSession();
		Transaction ta = session.beginTransaction();
		
		String sql = "select * from cst_customer limit ?,?";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter(0, 0);
		query.setParameter(1, 1);
		query.addEntity(Customer.class);
		List<Customer> list = query.list();
		System.out.println(list);
//		query.uniqueResult();
		
		
		ta.commit();
		session.close();
		
	}
}
