package cn.itcast.sevice.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.itcast.dao.CustomerDao;
import cn.itcast.dao.impl.CustomerDaoImpl;
import cn.itcast.domain.Customer;
import cn.itcast.service.CustomerService;
import cn.itcast.utils.HibernateUtils;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao customerDao=new CustomerDaoImpl();

	@Override
	public void save(Customer c) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			customerDao.save(c);
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		tx.commit();
	}

	@Override
	public List<Customer> getAll() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Customer> list=null;
		try {
			list=customerDao.getAll();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		tx.commit();
		return list;
	}

}
