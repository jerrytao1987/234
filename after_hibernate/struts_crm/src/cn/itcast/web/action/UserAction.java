package cn.itcast.web.action;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.User;
import cn.itcast.service.CustomerService;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private User user= new User();
	private UserService us;
	{
		//获得spring容器=>从Application域获得即可
				//1.获得servletContext对象
				ServletContext sc = ServletActionContext.getServletContext();
				//2.从sc中获得ac容器
				WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
				//3.从容器中获得CustomerService
				us = (UserService) ac.getBean("userService");
	}
	

	public String login() throws Exception {
		User u = us.login(user);
		ActionContext.getContext().getSession().put("user", u);
		return "tohome";
	}



	@Override
	public User getModel() {
		return user;
	}
	
}
