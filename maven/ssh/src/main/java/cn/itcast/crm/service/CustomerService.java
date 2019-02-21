package cn.itcast.crm.service;

import cn.itcast.crm.entity.Customer;

public interface CustomerService {
	/**
	 * 根据客户Id 返回customer对象
	 * @param id
	 * @return
	 */
	public Customer findById(Long id);
}
