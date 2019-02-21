package com.itheima.bos.web.inteceptor;

import org.apache.struts2.ServletActionContext;

import com.itheima.bos.entity.User;
import com.itheima.bos.utils.BOSUtils;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class BOSLoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		/*ActionProxy proxy = invocation.getProxy();
		String actionName = proxy.getActionName();
		String namespace = proxy.getNamespace();
		String url = namespace+actionName;
		System.out.println(url);*/
		User user = BOSUtils.getLoginUser();
		if(user == null){
			return "login";
		}
		return invocation.invoke();
	}

}
