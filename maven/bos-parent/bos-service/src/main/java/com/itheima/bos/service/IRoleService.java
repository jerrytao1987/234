package com.itheima.bos.service;

import java.util.List;

import com.itheima.bos.entity.Role;
import com.itheima.bos.utils.PageBean;

public interface IRoleService {

	public void save(Role model, String functionIds);

	public void pageQuery(PageBean pageBean);

	public List<Role> findAll();

	public Role findById(String id);

}