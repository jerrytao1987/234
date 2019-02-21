package cn.itcast.c_param;


import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.domain.User;

//如何在action中获得原生servletApi
public class Demo9Action extends ActionSupport {

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String execute() {
		System.out.println(user);
		return "success";
	}

}
