package cn.itcast.line;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LineServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();
		String requestURI = request.getRequestURI();
		StringBuffer requestURL = request.getRequestURL();
		String contextPath = request.getContextPath();
		String queryString = request.getQueryString();
		String remoteAddr = request.getRemoteAddr();
		
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("method:"+method);
		response.getWriter().write("<br/>URI:"+requestURI);
		response.getWriter().write("<br/>URL:"+requestURL.toString());
		response.getWriter().write("<br/>web应用:"+contextPath);
		response.getWriter().write("<br/>"+queryString);
		response.getWriter().write("<br/>IP:"+remoteAddr);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}