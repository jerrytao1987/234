package cn.itcast.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.itcast.domain.Customer;
import cn.itcast.service.CustomerService;
import cn.itcast.service.impl.CustomerServiceImpl;

public class AddCustomerServlet extends HttpServlet {

	private CustomerService customerService=new CustomerServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer c = new Customer();
		try {
			BeanUtils.populate(c, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		customerService.save(c);
		response.sendRedirect(request.getContextPath()+"/listCustomer");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}