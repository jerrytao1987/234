package com.itheima.bos.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.entity.Function;
import com.itheima.bos.service.IFunctionService;
import com.itheima.bos.web.action.base.BaseAction;
@Controller
@Scope("prototype")
public class FunctionAction extends BaseAction<Function> {
	@Autowired
	private IFunctionService functionService;
	public String listajax() throws Exception {
		List<Function> list = functionService.findAll();
		this.java2Json(list, new String[]{"parentFunction","code","description","page","generatemenu","zindex","roles"});
		return NONE;
	}
	public String add() throws Exception {
		functionService.save(model);
		return "list";
	}
	public String pageQuery() throws Exception {
		String page = model.getPage();
		pageBean.setCurrentPage(Integer.parseInt(page));
		functionService.pageQuery(pageBean);
		this.java2Json(pageBean, new String[]{"parentFunction","children","roles"});
		return NONE;
	}
	public String findMenu() throws Exception {
		List<Function> list = functionService.findMenu();
		java2Json(list, new String[]{"parentFunction","children","roles"});
		return NONE;
	}
	
}
