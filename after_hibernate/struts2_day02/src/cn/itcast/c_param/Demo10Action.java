package cn.itcast.c_param;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.User;

//如何在action中获得原生servletApi
public class Demo10Action extends ActionSupport implements ModelDriven<User> {

	private User user=new User();

	public String execute() {
		System.out.println(user);
		return "success";
	}

	@Override
	public User getModel() {
		return user;
	}

}
