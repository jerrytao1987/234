package com.itheima.bos.web.action;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.entity.Role;
import com.itheima.bos.service.IRoleService;
import com.itheima.bos.utils.BOSUtils;
import com.itheima.bos.web.action.base.BaseAction;
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {
	
	private String functionIds;
	public void setFunctionIds(String functionIds) {
		this.functionIds = functionIds;
	}
	@Autowired
	private IRoleService roleService;
	public String add() throws Exception {
		String id = model.getId();
		if(StringUtils.isNotBlank(id)){
			Role role = roleService.findById(id);
			role.setCode(model.getCode());
			role.setName(model.getName());
			role.setDescription(model.getDescription());
			role.setFunctions(model.getFunctions());
			roleService.save(role,functionIds);
		}else{
			model.setId(null);
			roleService.save(model, functionIds);
		}
		return "list";
	}
	public String pageQuery() throws Exception {
		roleService.pageQuery(pageBean);
		java2Json(pageBean, new String[]{"functions","users"});
		return NONE;
	}
	public String listajax() throws Exception {
		List<Role> list = roleService.findAll();
		java2Json(list, new String[]{"functions","users"});
		return NONE;
	}
	public String findById() throws Exception {
		Role role = roleService.findById(model.getId());
		java2Json(role, new String[]{"users","parentFunction","roles"});
		return NONE;
	}
}
