package com.itheima.bos.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.ISubareaDao;
import com.itheima.bos.entity.Subarea;
import com.itheima.bos.service.ISubareaService;
import com.itheima.bos.utils.PageBean;
@Service
@Transactional
public class SubareaServiceImpl implements ISubareaService {
	@Resource
	private ISubareaDao subareaDao;
	@Override
	public void save(Subarea model) {
		subareaDao.save(model);
		
	}
	@Override
	public void pageQuery(PageBean pageBean) {
		subareaDao.pageQuery(pageBean);
		
	}
	@Override
	public List<Subarea> findAll() {
		return subareaDao.findAll();
	}
	@Override
	public List<Subarea> findListNotAssociation() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Subarea.class);;
		detachedCriteria.add(Restrictions.isNull("decidedzone"));
		List<Subarea> list = subareaDao.findByCriteria(detachedCriteria );
		return list;
	}
	@Override
	public List<Subarea> findListByDecidedzoneId(String id) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Subarea.class);
		detachedCriteria.add(Restrictions.eq("decidedzone.id", id));
		List<Subarea> list = subareaDao.findByCriteria(detachedCriteria);
		return list;
	}
	@Override
	public List<Object> findSubareasGroupByProvince() {
		List<Object> list = subareaDao.findSubareasGroupByProvince();
		return list;
	}

}
