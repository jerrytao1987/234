package cn.itcast.crm.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.crm.entity.Customer;
import cn.itcast.crm.service.CustomerService;

public class CustomerServiceImplTest {

	@Test
	public void test() {
//		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext-service.xml","classpath:applicationContext-dao.xml");
		/*ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:applicationContext-*.xml");
		CustomerService cd = (CustomerService) ac.getBean("customerService");
		Customer c = cd.findById(23L);
		System.out.println(c.getCustName());*/
	}

}
