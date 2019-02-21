package com.itheima.bos.service;

import java.util.List;

import com.itheima.bos.entity.Subarea;
import com.itheima.bos.utils.PageBean;

public interface ISubareaService {

	public void save(Subarea model);

	public void pageQuery(PageBean pageBean);

	public List<Subarea> findAll();

	public List<Subarea> findListNotAssociation();

	public List<Subarea> findListByDecidedzoneId(String id);

	public List<Object> findSubareasGroupByProvince();

}
