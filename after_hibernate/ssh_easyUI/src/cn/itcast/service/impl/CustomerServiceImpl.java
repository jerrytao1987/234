package cn.itcast.service.impl;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import cn.itcast.service.CustomerService;
import cn.itcast.utils.PageBean;

@Service("customerService")
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class CustomerServiceImpl implements CustomerService {
	private CustomerDao cd;
	@Resource(name="customerDao")
	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}
	@Override
	public PageBean<Customer> getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		int totalCount = cd.getTotalCount(dc);
		PageBean<Customer> pageBean= new PageBean(currentPage, totalCount, pageSize);
		List<Customer> list = cd.getPageList(dc,pageBean.getStart(),pageBean.getPageSize());
		pageBean.setList(list);
		return pageBean;
	}
	@Override
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void save(Customer customer) {
		cd.saveOrUpdate(customer);
		
	}
	@Override
	public Customer getById(Long cust_id) {
		
		return cd.getById(cust_id);
	}
	@Override
	public List<Object[]> getIndustryCount() {
		
		return cd.getIndustryCount();
	}
	
}
