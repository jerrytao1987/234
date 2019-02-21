package cn.itcast.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.Customer;

public interface CustomerDao {

	void save(Customer c);

	List<Customer> getAll();

	Customer getById(Long cust_id);

	List<Customer> getAll(DetachedCriteria dc);

}
