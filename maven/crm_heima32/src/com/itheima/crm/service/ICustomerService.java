package com.itheima.crm.service;

import java.util.List;

import javax.jws.WebService;

import com.itheima.crm.entity.Customer;
@WebService
public interface ICustomerService {
	public List<Customer> findAll();
	public List<Customer> findListNotAssociation();
	public List<Customer> findListHasAssociation(String decidedzoneId);
	public void assigncustomerstodecidedzone(String decidedzoneId,Integer[] customerIds);
	public Customer findCustomerByTelephone(String telephone);
	public String findDecidedzoneIdByAddress(String address);
}
