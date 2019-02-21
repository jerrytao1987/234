package com.itheima.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.common.utils.Page;
import com.itheima.crm.mapper.CustomerDao;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	public Page<Customer> selectPageByQueryVo(QueryVo qv){
		
		Page<Customer> page = new Page<Customer>();
		qv.setSize(5);
		page.setSize(5);
		if(null != qv){
			if(null != qv.getPage()){
				page.setPage(qv.getPage());
				qv.setStartRow((qv.getPage()-1)*qv.getSize());
			}
			if(null != qv.getCustName() && !"".equals(qv.getCustName().trim())){
				qv.setCustName(qv.getCustName().trim());
			}
			if(null != qv.getCustSource() && !"".equals(qv.getCustSource().trim())){
				qv.setCustSource(qv.getCustSource().trim());
			}
			if(null != qv.getCustIndustry() && !"".equals(qv.getCustIndustry().trim())){
				qv.setCustIndustry(qv.getCustIndustry().trim());
			}
			if(null != qv.getCustLevel() && !"".equals(qv.getCustLevel().trim())){
				qv.setCustLevel(qv.getCustLevel().trim());
			}
			page.setTotal(customerDao.customerCountByQueryVo(qv));
			page.setRows(customerDao.selectCustomerListByQueryVo(qv));
		}
		
		return page;
	}

	@Override
	public Customer selectCustomerById(Integer id) {
		
		return customerDao.selectCustomerById(id);
	}

	@Override
	public void updateCustomerById(Customer customer) {
		customerDao.updateCustomerById(customer);
		
	}

	@Override
	public void deleteCustomerById(Integer id) {
		customerDao.deleteCustomerById(id);
		
	}
}
