package com.itheima.bos.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.IRoleDao;
import com.itheima.bos.entity.Function;
import com.itheima.bos.entity.Role;
import com.itheima.bos.service.IRoleService;
import com.itheima.bos.utils.PageBean;
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
	@Autowired
	private IRoleDao roleDao;
	@Override
	public void save(Role model, String functionIds) {
		/*roleDao.save(model);
		if(StringUtils.isNotBlank(functionIds)){
			String[] fIds = functionIds.split(",");
			for (String functionId : fIds) {
				Function function = new Function(functionId);
				model.getFunctions().add(function);
			}
		}*/
		
		roleDao.saveOrUpdate(model);
		if(StringUtils.isNotBlank(functionIds)){
			String[] fIds = functionIds.split(",");
			for (String functionId : fIds) {
				Function function = new Function(functionId);
				model.getFunctions().add(function);
			}
		}
	}
	@Override
	public void pageQuery(PageBean pageBean) {
		roleDao.pageQuery(pageBean);
	}
	@Override
	public List<Role> findAll() {
		List<Role> list = roleDao.findAll();
		return list;
	}
	@Override
	public Role findById(String id) {
		if(StringUtils.isNotBlank(id)){
			Role role = roleDao.findById(id);
			return role;
		}
		return null;
	}

}
