package com.itheima.bos.web.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.entity.Staff;
import com.itheima.bos.service.IStaffService;
import com.itheima.bos.utils.PageBean;
import com.itheima.bos.web.action.base.BaseAction;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff> {
	@Resource(name="staffServiceImpl")
	private IStaffService staffService;
	private String ids;
	public void setIds(String ids) {
		this.ids = ids;
	}

	public String add() throws Exception {
		staffService.save(model);
		return "list";
	}
	
	public String pageQuery() throws Exception {
		staffService.pageQuery(pageBean);
		java2Json(pageBean, new String[]{"currentPage","pageSize","detachedCriteria","decidedzones"});
		return NONE;
	}
	@RequiresPermissions("staff-delete")
	public String deleteBatch() throws Exception {
		staffService.deleteBatch(ids);
		return "list";
	}

	public String edit() throws Exception {
		Subject subject = SecurityUtils.getSubject();
		subject.checkPermission("staff-edit");
		
		
		Staff staff = staffService.findById(model.getId());
		staff.setName(model.getName());
		staff.setTelephone(model.getTelephone());
		staff.setHaspda(model.getHaspda());
		staff.setStandard(model.getStandard());
		staffService.update(staff);
		return "list";
	}

	public String listajax() throws Exception {
		List<Staff> list = staffService.findListNotDelete();
		this.java2Json(list, new String[]{"telephone","haspda","deltag","station","standard","decidedzones"});
		return NONE;
	}
	
}
