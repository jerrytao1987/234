package cn.itcast.crm.dao;

import cn.itcast.crm.entity.Customer;

public interface CustomerDao {
	/**
	 * 根据客户Id 返回customer对象
	 * @param id
	 * @return
	 */
	public Customer findById(Long id);
}
