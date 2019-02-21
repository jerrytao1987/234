package cn.itcast.e_config;

import com.opensymphony.xwork2.ActionSupport;

public class Demo3Action extends ActionSupport{
	
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String execute() throws Exception {
		name="jerry";
		return SUCCESS;
	}
	
}
