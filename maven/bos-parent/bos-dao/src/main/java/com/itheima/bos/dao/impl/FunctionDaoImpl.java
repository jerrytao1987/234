package com.itheima.bos.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itheima.bos.dao.IFunctionDao;
import com.itheima.bos.entity.Function;
@Repository
public class FunctionDaoImpl extends BaseDaoImpl<Function> implements IFunctionDao {

	@Override
	public List<Function> findAll() {
		String hql = "FROM Function f WHERE f.parentFunction IS NULL";
		List<Function> list = (List<Function>) this.getHibernateTemplate().find(hql);
		return list;
	}

	@Override
	public List<Function> findFunctionListByUserId(String id) {
		String hql = "SELECT DISTINCT f FROM Function f LEFT OUTER JOIN f.roles r LEFT OUTER JOIN r.users u WHERE u.id = ?";
		List<Function> list = (List<Function>) this.getHibernateTemplate().find(hql, id);
		return list;
	}

	@Override
	public List<Function> findAllMenu() {
		String hql = "FROM Function f WHERE f.generatemenu='1' ORDER BY f.zindex";
		List<Function> list = (List<Function>) this.getHibernateTemplate().find(hql);
		return list;
	}

	@Override
	public List<Function> findMenuByUserId(String id) {
		String hql = "SELECT DISTINCT f FROM Function f LEFT OUTER JOIN f.roles r LEFT OUTER JOIN r.users u WHERE u.id = ? AND f.generatemenu = '1' ORDER BY f.zindex DESC";
		List<Function> list = (List<Function>) this.getHibernateTemplate().find(hql, id);
		return list;
	}
	
}
