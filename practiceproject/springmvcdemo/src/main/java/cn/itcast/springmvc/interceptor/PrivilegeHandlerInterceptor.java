package cn.itcast.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.springmvc.pojo.User;

public class PrivilegeHandlerInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		User user = (User) request.getSession().getAttribute("user");
		if(user!=null){
			return true;
		}
		StringBuffer requestURL = request.getRequestURL();
		System.out.println(requestURL);
		int index = requestURL.indexOf("/user/");
		if(index!=-1){
			return true;
		}
		System.out.println(request.getContextPath());
		response.sendRedirect(request.getContextPath()+"/user/toLogin?requestURL="+requestURL);
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
