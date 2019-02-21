package com.itheima.bos.web.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.entity.Workordermanage;
import com.itheima.bos.service.IWorkordermanageService;
import com.itheima.bos.web.action.base.BaseAction;
@Controller
@Scope("prototype")
public class WorkordermanageAction extends BaseAction<Workordermanage> {
	@Autowired
	private IWorkordermanageService workordermanageService;

	public String add() throws Exception {
		String f = "1";
		try {
			workordermanageService.save(model);
		} catch (Exception e) {
			f="0";
			e.printStackTrace();
		}
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(f);
		return NONE;
	}
	
}
