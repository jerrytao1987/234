package cn.itcast.a_result;

import com.opensymphony.xwork2.ActionSupport;

public class Demo1Action extends ActionSupport {
	public String execute(){
		System.out.println("Demo1Action");
		return "success";
	}
	
}
