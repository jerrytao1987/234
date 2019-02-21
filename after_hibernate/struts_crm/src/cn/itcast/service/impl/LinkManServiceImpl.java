package cn.itcast.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.dao.CustomerDao;
import cn.itcast.dao.LinkManDao;
import cn.itcast.dao.impl.CustomerDaoImpl;
import cn.itcast.dao.impl.LinkManDaoImpl;
import cn.itcast.domain.Customer;
import cn.itcast.domain.LinkMan;
import cn.itcast.service.LinkManService;
import cn.itcast.utils.HibernateUtils;

public class LinkManServiceImpl implements LinkManService {

	private CustomerDao cd ;
	private LinkManDao lmd ;

	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}

	public void setLmd(LinkManDao lmd) {
		this.lmd = lmd;
	}

	@Override
	public void save(LinkMan lm) {
		Transaction tx = HibernateUtils.getCurrentSession().beginTransaction();
		try {
			Long cust_id = lm.getCust_id();
			Customer c = cd .getById(cust_id);
			
			lm.setCustomer(c);
			lmd .save(lm);
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		tx.commit();
	}

	@Override
	public List<LinkMan> getAll() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<LinkMan> list=null;
		try {
			list = lmd.getAll();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		tx.commit();
		return list;
	}

	@Override
	public List<LinkMan> getAll(DetachedCriteria dc) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<LinkMan> list=null;
		try {
			list = lmd.getAll(dc);
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		tx.commit();
		return list;
	}

}
