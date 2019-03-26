package com.struts2demo.web.action;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Demo2Action extends ActionSupport {
	private String name="tom";//2
	private String age="22";
	private String sex="女";
	private String addr="北京";
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String execute() throws Exception {
		Map<String, Object> parameters = ActionContext.getContext().getParameters();
		Set<String> keySet = parameters.keySet();
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()){
			String next = it.next();
			System.out.println(next);
			String[] arr = (String[]) parameters.get(next);
			System.out.println(arr[0]);
		}
		//ActionContext.getContext().put("name", "jerry");//3
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		//request.put("name", "jack");//1
		Map<String, Object> session = ActionContext.getContext().getSession();
		//session.put("name", "lucy");//4
		Map<String, Object> app = ActionContext.getContext().getApplication();
		//app.put("name", "lily");//5
		 HttpServletRequest request2 = ServletActionContext.getRequest();
		 HttpSession session2 = request2.getSession();
		 HttpServletResponse response = ServletActionContext.getResponse();
		 ServletContext servletContext = ServletActionContext.getServletContext();
		 System.out.println(1);
		 System.out.println(name);
		return SUCCESS;
	}
	
}
