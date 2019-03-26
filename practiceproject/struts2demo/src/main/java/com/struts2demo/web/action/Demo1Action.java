package com.struts2demo.web.action;

import com.opensymphony.xwork2.ActionSupport;

public class Demo1Action extends ActionSupport {

	public String hello() throws Exception {
		System.out.println("demo1action");
		return SUCCESS;
	}

}
