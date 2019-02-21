package cn.itcast.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class QuickStartServlet implements Servlet {
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		//1.获得servlet的name
		String servletName = config.getServletName();
		System.out.println(servletName);
		//2.获得该servlet的初始化参数
		String initParameter = config.getInitParameter("url");
		System.out.println(initParameter);
		//3.获得ServletContext对象
		ServletContext servletContext = config.getServletContext();
		System.out.println(servletContext);
		System.out.println("init running...");
		
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("QuickStratServlet running....");
		res.getWriter().write("QuickStratServlet running....");
	}

	@Override
	public void destroy() {
		System.out.println("destroy running...");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}


	@Override
	public String getServletInfo() {
		return null;
	}

	

}
