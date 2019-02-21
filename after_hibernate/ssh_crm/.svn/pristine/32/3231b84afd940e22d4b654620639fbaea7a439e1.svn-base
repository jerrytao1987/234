package cn.itcast.web.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.SaleVisit;
import cn.itcast.domain.User;
import cn.itcast.service.SaleVisitService;
import cn.itcast.utils.PageBean;

@Controller("saleVisitAction")
@Scope("prototype")
public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit> {
	
	private SaleVisit saleVisit = new SaleVisit();
	
	private SaleVisitService svs;
	
	private Integer currentPage;
	private Integer pageSize;
	
	public String add() throws Exception {
		User u = (User) ActionContext.getContext().getSession().get("user");
		saleVisit.setUser(u);
		svs.save(saleVisit);
		return "toList";
	}

	

	public String list() throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(SaleVisit.class);
		if(saleVisit.getCustomer()!=null && saleVisit.getCustomer().getCust_id()!=null){
			dc.add(Restrictions.eq("customer.cust_id", saleVisit.getCustomer().getCust_id()));
		}
		if(saleVisit.getUser()!=null && saleVisit.getUser().getUser_id()!=null){
			dc.add(Restrictions.eq("user.user_id", saleVisit.getUser().getUser_id()));
		}
		PageBean<SaleVisit> pb = svs.getPageBean(dc,currentPage,pageSize);
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}



	public String toEdit() throws Exception {
		SaleVisit sv = svs.getById(saleVisit.getVisit_id());
		ActionContext.getContext().put("saleVisit", sv);
		return "add";
	}



	@Override
	public SaleVisit getModel() {
		return saleVisit;
	}
	@Resource(name="saleVisitService")
	public void setSvs(SaleVisitService svs) {
		this.svs = svs;
	}



	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}



	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}
