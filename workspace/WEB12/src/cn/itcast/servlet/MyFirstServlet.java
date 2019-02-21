package cn.itcast.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class MyFirstServlet implements Servlet {
	/**
	 * 专门向客服端提供响应的方法
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		HttpServletResponse response = (HttpServletResponse) res;
		//response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("This is my first servlet!!");
		response.getWriter().write("<h1 style='color:red'>This is my first servlet!!</h1>");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	
	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {
	}
	
}
