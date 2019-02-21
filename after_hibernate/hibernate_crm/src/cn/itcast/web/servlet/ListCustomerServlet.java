package cn.itcast.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cn.itcast.domain.Customer;
import cn.itcast.service.CustomerService;
import cn.itcast.service.impl.CustomerServiceImpl;

public class ListCustomerServlet extends HttpServlet {

	private CustomerService cs=new CustomerServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cust_name = request.getParameter("cust_name");
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		if(cust_name!=null&&!"".equals(cust_name)){
			dc.add(Restrictions.like("cust_name", "%"+cust_name+"%"));
		}
		List<Customer> list = cs.getAll(dc);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/customer/list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}