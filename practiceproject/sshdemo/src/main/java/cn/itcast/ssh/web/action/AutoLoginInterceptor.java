package cn.itcast.ssh.web.action;

import java.util.Map;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import cn.itcast.ssh.pojo.Users;

public class AutoLoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		Users u = (Users) ServletActionContext.getRequest().getSession().getAttribute("user");
		String name = invocation.getInvocationContext().getName();
		Map<String, Object> p = ActionContext.getContext().getParameters();
		Set<String> keys = p.keySet();
		for (String key : keys) {
			System.out.println(key+":"+p.get(key));
		}
		if(name.equals("userAction_login")){
			return invocation.invoke();
		}
		if(u!=null){
			return invocation.invoke();
		}
		return "toLogin";
	}

}
