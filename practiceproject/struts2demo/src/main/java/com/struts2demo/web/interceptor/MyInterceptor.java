package com.struts2demo.web.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class MyInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		/*HttpServletRequest request = ServletActionContext.getRequest();
		String name = request.getParameter("name");
		System.out.println(name);
		if(name==null||name.equals("")){
			return "error";
		}*/
		return invocation.invoke();
	}

}
