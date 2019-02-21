package cn.itcast.b_criteria;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import cn.itcast.domain.Customer;
import cn.itcast.utils.HibernateUtils;

public class Demo2 {
	
	@Test
	public void fun1(){
		
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		dc.add(Restrictions.idEq(3l));
		
		
		//---------------------------------------------
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		
		Criteria c = dc.getExecutableCriteria(session);
		List list = c.list();
		System.out.println(list);
		
		
		tx.commit();
		session.close();
	}
	
}
