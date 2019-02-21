package cn.itcast.e_hql;

import java.util.List;

import org.hibernate.Query;
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
		
//		String hql = "from cn.itcast.domain.Customer";
		String hql = "from Customer";//查询所有Customer对象
		Query query = session.createQuery(hql);
		List<Customer> list = query.list();//返回list结果
//		query.uniqueResult();//接收唯一的查询结果
		System.out.println(list);
		
		ta.commit();
		session.close();
		
	}
	
	@Test
	public void fun2(){
		Session session = HibernateUtils.openSession();
		Transaction ta = session.beginTransaction();
		
		String hql = "from Customer where cust_id=1";//查询属性名
		Query query = session.createQuery(hql);
		Customer c = (Customer) query.uniqueResult();//接收唯一的查询结果
		System.out.println(c);
		
		ta.commit();
		session.close();
		
	}
	
	@Test
	public void fun3(){
		Session session = HibernateUtils.openSession();
		Transaction ta = session.beginTransaction();
		
		String hql = "from Customer where cust_id=?";//查询属性名
		Query query = session.createQuery(hql);
//		query.setLong(0, 1l);
		query.setParameter(0, 1l);
		Customer c = (Customer) query.uniqueResult();//接收唯一的查询结果
		System.out.println(c);
		
		ta.commit();
		session.close();
		
	}
	
	@Test
	public void fun4(){
		Session session = HibernateUtils.openSession();
		Transaction ta = session.beginTransaction();
		
		String hql = "from Customer where cust_id=:cust_id";//查询属性名
		Query query = session.createQuery(hql);
		query.setParameter("cust_id", 1l);
		Customer c = (Customer) query.uniqueResult();//接收唯一的查询结果
		System.out.println(c);
		
		ta.commit();
		session.close();
		
	}
	
	@Test
	public void fun5(){
		Session session = HibernateUtils.openSession();
		Transaction ta = session.beginTransaction();
		
		String hql = "from Customer ";//查询属性名
		Query query = session.createQuery(hql);
		query.setFirstResult(1);
		query.setMaxResults(1);
		List<Customer> list = query.list();
		
		System.out.println(list);
		
		ta.commit();
		session.close();
		
	}
	
}
