package com.myservlet.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends BaseServlet  {

	public void print(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletName = this.getServletName();
		System.out.println(servletName);
		String servletInfo = this.getServletInfo();
		System.out.println(servletInfo);
		long lastModified = this.getLastModified(req);
		System.out.println(lastModified);
		String value = this.getInitParameter("name");
		System.out.println(value);
		ServletContext sc = this.getServletConfig().getServletContext();
		ServletContext sc1 = this.getServletContext();
		System.out.println(sc==sc1);
		sc.setAttribute("name", "jerry");
		Object value1 = sc.getAttribute("name");
		System.out.println(value1);
		String realPath = sc.getRealPath("/resource.properties");
		System.out.println(realPath);
		InputStream in = sc.getResourceAsStream("/resource.properties");
		Properties pro = new Properties();
		pro.load(in);
		String property = pro.getProperty("name");
		System.out.println(property);
		
		String method = req.getMethod();
		System.out.println(method);
		String uri = req.getRequestURI();
		System.out.println(uri);
		String path = req.getContextPath();
		System.out.println(path);
		String servletPath = req.getServletPath();
		System.out.println(servletPath);
		StringBuffer requestURL = req.getRequestURL();
		System.out.println(requestURL);
		String remoteAddr = req.getRemoteAddr();
		System.out.println(remoteAddr);
		String serverName = req.getServerName();
		System.out.println(serverName);
		String characterEncoding = req.getCharacterEncoding();
		System.out.println(characterEncoding);
		String protocol = req.getProtocol();
		System.out.println(protocol);
		int serverPort = req.getServerPort();
		System.out.println(serverPort);
		
		//resp.setStatus(404);
		//resp.sendError(500,"hello");
//		resp.getOutputStream().write("hello".getBytes());
//		resp.getOutputStream().print("haha");
		resp.getWriter().write("hello");
		resp.getWriter().println("haha");
	}
	
}
