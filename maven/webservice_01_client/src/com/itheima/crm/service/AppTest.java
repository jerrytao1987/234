package com.itheima.crm.service;

import java.util.List;

public class AppTest {
	public static void main(String[] args) {
		CustomerServiceImplService ss = new CustomerServiceImplService();
		ICustomerService proxy = ss.getCustomerServiceImplPort();
		List<Customer> list = proxy.findAll();
		for (Customer customer : list) {
			System.out.println(customer);
		}
	}
}
