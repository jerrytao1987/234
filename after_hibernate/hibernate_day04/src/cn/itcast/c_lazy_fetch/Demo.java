package cn.itcast.c_lazy_fetch;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import cn.itcast.domain.Customer;
import cn.itcast.domain.LinkMan;
import cn.itcast.utils.HibernateUtils;

public class Demo {
	
	@Test
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer c = session.get(Customer.class, 2l);
		Set<LinkMan> linkMen = c.getLinkMen();//关联级别
		System.out.println(linkMen);
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void fun2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Customer c = session.get(Customer.class, 2l);
		Set<LinkMan> linkMen = c.getLinkMen();
		System.out.println(linkMen);
		
		tx.commit();
		session.close();
	}
	
	
}
