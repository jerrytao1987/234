package cn.itcast.privilegedemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.privilegedemo.mapper.DepartmentMapper;
import cn.itcast.privilegedemo.pojo.Department;
@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentMapper departmentMapper;
	@Override
	public List<Department> find() {
		List<Department> list = departmentMapper.selectByExample(null);
		return list;
	}

}
