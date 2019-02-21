package cn.itcast.a_hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.domain.Customer;
import cn.itcast.utils.HibernateUtils;

public class Demo2 {
	
	@Test
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		String hql = "from Customer c inner join c.linkMen";
		
		
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		for(Object[] arr:list){
			System.out.println(Arrays.toString(arr));
		}
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void fun2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		String hql = "from Customer c inner join fetch c.linkMen";
		
		
		Query query = session.createQuery(hql);
		List<Customer> list = query.list();
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void fun3(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		String hql = "from Customer c left join fetch c.linkMen";
		
		
		Query query = session.createQuery(hql);
		List<Customer> list = query.list();
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void fun4(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		String hql = "from Customer c right join fetch c.linkMen";
		
		
		Query query = session.createQuery(hql);
		List<Customer> list = query.list();
		System.out.println(list);
		
		tx.commit();
		session.close();
	}
	
}
