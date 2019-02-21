package cn.itcast.crm.dao.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.crm.dao.CustomerDao;
import cn.itcast.crm.entity.Customer;

@ContextConfiguration(locations={"classpath:applicationContext-dao.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerDaoImplTest {
	
	/*@Test
	public void test() {
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext-dao.xml");
		CustomerDao cd = (CustomerDao) app.getBean("customerDao");
		Customer c = cd.findById(23L);
		System.out.println(c.getCustName());
	}*/
	
	@Resource(name="customerDao")
	private CustomerDao cd;
	
	@Test
	public void test() {
		Customer c = cd.findById(23L);
		System.out.println(c.getCustName());
	}

}
