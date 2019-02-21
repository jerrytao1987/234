package cn.itcast.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import cn.itcast.utils.HibernateUtils;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void save(Customer c) {
		Session session = HibernateUtils.getCurrentSession();
		session.save(c);
	}

	@Override
	public List<Customer> getAll() {
		Session session = HibernateUtils.getCurrentSession();
		//方法1
		Criteria criteria = session.createCriteria(Customer.class);
		List<Customer> list = criteria.list();
		//方法二
		/*String hql = "from Customer";
		Query query = session.createQuery(hql);
		List<Customer> list = query.list();*/
		//方法三
	/*	String sql = "select * from cst_customer";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Customer.class);
		List<Customer> list = query.list();*/
		return list;
	}

	@Override
	public Customer getById(Long cust_id) {
		Session session = HibernateUtils.getCurrentSession();
		Customer c = session.get(Customer.class, cust_id);
		return c;
	}

	@Override
	public List<Customer> getAll(DetachedCriteria dc) {
		Session session = HibernateUtils.getCurrentSession();
		//方法1
		Criteria c = dc.getExecutableCriteria(session);
		List<Customer> list = c.list();
		return list;
	}

}
