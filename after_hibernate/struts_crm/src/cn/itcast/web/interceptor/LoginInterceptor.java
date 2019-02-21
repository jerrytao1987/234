package cn.itcast.web.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		
		//1.获得session
		Map<String, Object> session = ActionContext.getContext().getSession();
		//2.获得登录标识
		Object object = session.get("user");
		//3.判断登录标识是否存在
		if(object == null){
			return "toLogin";
		}else{
			return invocation.invoke();
		}
	}

}
