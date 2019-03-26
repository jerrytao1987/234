package com.myservlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDemo implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String name = filterConfig.getInitParameter("name");
		System.out.println(name);
		System.out.println(filterConfig.getFilterName());
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.getRequestDispatcher("").forward(request, response);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}
