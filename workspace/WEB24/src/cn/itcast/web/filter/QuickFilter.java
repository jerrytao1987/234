package cn.itcast.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class QuickFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//获得web.xml的filter的名称<filter-name>QuickFilter</filter-name>
		System.out.println(filterConfig.getFilterName());
		System.out.println(filterConfig.getInitParameter("aaa"));
		System.out.println(filterConfig.getServletContext());	
		System.out.println("init...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("quick running....");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("destroy...");
	}

}
