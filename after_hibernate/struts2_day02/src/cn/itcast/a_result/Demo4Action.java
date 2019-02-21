package cn.itcast.a_result;

import com.opensymphony.xwork2.ActionSupport;

public class Demo4Action extends ActionSupport {
	public String execute(){
		System.out.println("Demo4Action");
		return "success";
	}
	
}
