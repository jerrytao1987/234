package com.itheima.bos.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.IStaffDao;
import com.itheima.bos.entity.Staff;
import com.itheima.bos.service.IStaffService;
import com.itheima.bos.utils.PageBean;
@Service
@Transactional
public class StaffServiceImpl implements IStaffService {
	@Resource(name="staffDaoImpl")
	private IStaffDao staffDao;
	@Override
	public void save(Staff model) {
		staffDao.save(model);
	}
	@Override
	public void pageQuery(PageBean pageBean) {
		staffDao.pageQuery(pageBean);
		
	}
	@Override
	public void deleteBatch(String ids) {
		if(StringUtils.isNotBlank(ids)){
			String[] staffIds = ids.split(",");
			for (String id : staffIds) {
				staffDao.executeUpdate("staff.delete", id);
			}
		}
	}
	@Override
	public Staff findById(String id) {
		Staff staff = staffDao.findById(id);
		return staff;
	}
	@Override
	public void update(Staff staff) {
		staffDao.update(staff);
		
	}
	@Override
	public List<Staff> findListNotDelete() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Staff.class);
		detachedCriteria.add(Restrictions.eq("deltag", "0"));
		List<Staff> list = staffDao.findByCriteria(detachedCriteria);
		return list;
	}

}
