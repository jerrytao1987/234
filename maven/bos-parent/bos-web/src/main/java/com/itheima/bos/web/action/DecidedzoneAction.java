package com.itheima.bos.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.entity.Decidedzone;
import com.itheima.bos.service.IDecidedzoneService;
import com.itheima.bos.web.action.base.BaseAction;
import com.itheima.crm.Customer;
import com.itheima.crm.ICustomerService;

@Controller
@Scope("prototype")
public class DecidedzoneAction extends BaseAction<Decidedzone> {
	
	private List<Integer> customerIds;
	
	public void setCustomerIds(List<Integer> customerIds) {
		this.customerIds = customerIds;
	}
	@Autowired
	private ICustomerService proxy;
	
	private String[] subareaid;
	public void setSubareaid(String[] subareaid) {
		this.subareaid = subareaid;
	}
	@Autowired
	private IDecidedzoneService decidedzoneService;
	public String add() throws Exception {
		decidedzoneService.save(model,subareaid);
		return "list";
	}
	public String pageQuery() throws Exception {
		decidedzoneService.pageQuery(pageBean);
		java2Json(pageBean, new String[]{"currentPage","pageSize","detachedCriteria","subareas","decidedzones"});
		return NONE;
	}
	public String findListNotAssociation() throws Exception {
		List<Customer> list = proxy.findListNotAssociation();
		java2Json(list, new String[]{});
		return NONE;
	}
	public String findListHasAssociation() throws Exception {
		String id = model.getId();
		List<Customer> list = proxy.findListHasAssociation(id);
		java2Json(list, new String[]{});
		return NONE;
	}
	public String assigncustomerstodecidedzone() throws Exception {
		String id = model.getId();
		proxy.assigncustomerstodecidedzone(id, customerIds);
		return "list";
	}
	
}
