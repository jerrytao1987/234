package cn.itcast.crm.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.crm.entity.Customer;
import cn.itcast.crm.service.CustomerService;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	
	private Customer customer=new Customer();
	
	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public String findById(){
		Customer c = customerService.findById(customer.getCustId());
		ActionContext.getContext().put("customer", c);
		return SUCCESS;
	}

	@Override
	public Customer getModel() {
		return customer;
	}
}
