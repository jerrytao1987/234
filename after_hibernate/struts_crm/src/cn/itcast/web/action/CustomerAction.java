package cn.itcast.web.action;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.Customer;
import cn.itcast.service.CustomerService;
import cn.itcast.service.impl.CustomerServiceImpl;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	private Customer customer = new Customer();
	private CustomerService cs;
	{
		//获得spring容器=>从Application域获得即可
				//1.获得servletContext对象
				ServletContext sc = ServletActionContext.getServletContext();
				//2.从sc中获得ac容器
				WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
				//3.从容器中获得CustomerService
				cs = (CustomerService) ac.getBean("customerService");
	}
	public String list() throws Exception {
		
		
		String cust_name = ServletActionContext.getRequest().getParameter("cust_name");
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		if(StringUtils.isNotEmpty(cust_name)){
			dc.add(Restrictions.like("cust_name", "%"+cust_name+"%"));
		}
		List<Customer> list = cs.getAll(dc);
//		ServletActionContext.getRequest().setAttribute("list", list);
		ActionContext.getContext().put("list", list);
		return "list";
	}
	
	
	public String add() throws Exception {
		cs.save(customer);
		return "toList";
	}


	@Override
	public Customer getModel() {
		return customer ;
	}
	
}
