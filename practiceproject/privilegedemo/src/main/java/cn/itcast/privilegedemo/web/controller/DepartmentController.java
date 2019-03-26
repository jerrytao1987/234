package cn.itcast.privilegedemo.web.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.privilegedemo.pojo.Department;
import cn.itcast.privilegedemo.service.DepartmentService;


@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@RequiresPermissions("department-list")//方法注解权限控制（基于代理技术实现，在action的方式上配置）
	@RequestMapping("/departmentList.action")
	@ResponseBody
	public List<Department> find(){
		//代码级别权限控制（基于代理技术实现，在action方法中使用）
		//Subject subject = SecurityUtils.getSubject();
		//检查当前用户是否具有一个department-list的权限
		//subject.checkPermission("department-list");
		
		List<Department> list = departmentService.find();
		return list;
	}
}
