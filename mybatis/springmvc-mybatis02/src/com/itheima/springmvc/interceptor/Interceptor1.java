package com.itheima.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor1 implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("页面渲染后1");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("方法后1");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("方法前1");
		//判断用户是否登录 如果没有登录 重定向到登录页面 不放行 如果登录了就放行
		//URL http://localhost:8080/springmvc-mybatis/login.action
		//URI /login.action
		String requestURI = request.getRequestURI();
		if(!requestURI.contains("/login")){
			String username = (String) request.getSession().getAttribute("USER_SESSION");
			if(null == username){
				response.sendRedirect(request.getContextPath() + "/login.action");
				return false;
			}
		}
		return true;
	}

}
