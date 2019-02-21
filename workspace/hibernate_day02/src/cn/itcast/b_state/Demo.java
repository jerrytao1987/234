package cn.itcast.b_state;

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
		
		Customer c = new Customer();//没有id，没有session关联=>瞬时状态
		c.setCust_name("联想");//瞬时状态
		
		session.save(c);//持久化状态，有id,有关联
		c.setCust_name("nihao");
		ta.commit();
		session.close();//游离|托管状态,有id，没有关联
		
	}
	@Test
	public void fun3(){
		Session session = HibernateUtils.openSession();
		Transaction ta = session.beginTransaction();
		
		Customer c = session.get(Customer.class, 1l);//持久化状态对象
		c.setCust_name("微软公司2");
		
		ta.commit();
		session.close();//游离|托管状态,有id，没有关联
		
	}
}
