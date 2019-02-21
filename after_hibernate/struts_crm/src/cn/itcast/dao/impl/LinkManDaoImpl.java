package cn.itcast.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.dao.LinkManDao;
import cn.itcast.domain.LinkMan;
import cn.itcast.utils.HibernateUtils;

public class LinkManDaoImpl implements LinkManDao {

	@Override
	public void save(LinkMan lm) {
		Session session = HibernateUtils.getCurrentSession();
		session.save(lm);

	}

	@Override
	public List<LinkMan> getAll() {
		Session session = HibernateUtils.getCurrentSession();
		Criteria c = session.createCriteria(LinkMan.class);
		List<LinkMan> list = c.list();
		return list;
	}

	@Override
	public List<LinkMan> getAll(DetachedCriteria dc) {
		Session session = HibernateUtils.getCurrentSession();
		Criteria c = dc.getExecutableCriteria(session);
		List<LinkMan> list = c.list();
		return list;
	}

}
