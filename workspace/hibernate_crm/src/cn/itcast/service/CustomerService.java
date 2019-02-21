package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.Customer;

public interface CustomerService {

	void save(Customer c);

	List<Customer> getAll();

}
