package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.Customer;

public interface CustomerDao {

	void save(Customer c);

	List<Customer> getAll();

}
