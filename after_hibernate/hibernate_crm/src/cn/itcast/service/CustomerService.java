package cn.itcast.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.Customer;

public interface CustomerService {

	void save(Customer c);

	List<Customer> getAll();

	List<Customer> getAll(DetachedCriteria dc);

}
