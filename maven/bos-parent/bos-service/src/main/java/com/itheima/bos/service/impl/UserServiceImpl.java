package com.itheima.bos.service.impl;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.IUserDao;
import com.itheima.bos.entity.Role;
import com.itheima.bos.entity.User;
import com.itheima.bos.service.IUserService;
import com.itheima.bos.utils.MD5Utils;
import com.itheima.bos.utils.PageBean;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	@Resource(name="userDaoImpl")
	private IUserDao userDao;
	@Override
	public User login(User model) {
		String password = MD5Utils.md5(model.getPassword());
		User user = userDao.findByUsernameAndPassword(model.getUsername(),password);
		return user;
	}
	@Override
	public void editPassword(String id, String password) {
		password = MD5Utils.md5(password);
		userDao.executeUpdate("user.editpassword", password,id);
	}
	@Override
	public void save(User model, String[] roleIds) {
		String password = model.getPassword();
		String md5 = MD5Utils.md5(password);
		model.setPassword(md5);
		userDao.save(model);
		if(roleIds.length>0){
			for (String roleId : roleIds) {
				Role role = new Role();
				role.setId(roleId);
				model.getRoles().add(role);
			}
		}
		
	}
	@Override
	public void pageQuery(PageBean pageBean) {
		userDao.pageQuery(pageBean);
		
	}

}
