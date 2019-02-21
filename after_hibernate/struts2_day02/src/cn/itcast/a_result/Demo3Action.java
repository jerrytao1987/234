package cn.itcast.a_result;

import com.opensymphony.xwork2.ActionSupport;

public class Demo3Action extends ActionSupport {
	public String execute(){
		System.out.println("Demo3Action");
		return "success";
	}
	
}
