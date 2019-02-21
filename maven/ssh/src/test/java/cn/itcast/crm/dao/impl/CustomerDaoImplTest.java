package cn.itcast.crm.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.crm.dao.CustomerDao;
import cn.itcast.crm.entity.Customer;


public class CustomerDaoImplTest {

	@Test
	public void test() {
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		CustomerDao cd = (CustomerDao) app.getBean("customerDao");
		Customer c = cd.findById(23L);
		System.out.println(c.getCustName());
	}

}
