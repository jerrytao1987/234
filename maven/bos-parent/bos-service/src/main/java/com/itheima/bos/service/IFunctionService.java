package com.itheima.bos.service;

import java.util.List;

import com.itheima.bos.entity.Function;
import com.itheima.bos.utils.PageBean;

public interface IFunctionService {

	public List<Function> findAll();

	public void save(Function model);

	public void pageQuery(PageBean pageBean);

	public List<Function> findMenu();

}
