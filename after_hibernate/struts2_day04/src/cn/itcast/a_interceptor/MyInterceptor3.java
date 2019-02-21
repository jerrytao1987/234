package cn.itcast.a_interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class MyInterceptor3 extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//前处理
		System.out.println("MyInterceptor3的前处理！");
		//放行
		String result = invocation.invoke();
		//后处理
		System.out.println("MyInterceptor3的后处理！");
		return result;
	}

	
}
