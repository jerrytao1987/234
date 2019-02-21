package cn.itcast.web.filter;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.utils.CookiesUtils;

/**
 * Servlet Filter implementation class AutoLoginFilter
 */
public class AutoLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AutoLoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String servletPath = req.getServletPath();
		if(servletPath.endsWith("/login.jsp")){
			chain.doFilter(req, resp);
			return;
		}
		User userSession = (User) req.getSession().getAttribute("user");
		if(userSession!=null){
			chain.doFilter(req, resp);
			return;
		}
		Cookie cookie_username = CookiesUtils.getCookie(req.getCookies(), "cookie_username");
		Cookie cookie_password = CookiesUtils.getCookie(req.getCookies(), "cookie_password");
		if(cookie_username==null||cookie_password==null){
			chain.doFilter(req, resp);
			return;
		}
		String username = URLDecoder.decode(cookie_username.getValue(), "UTF-8");
		UserService service = new UserService();
		User user = service.findUser(username,cookie_password.getValue());
		if(user==null){
			chain.doFilter(req, resp);
			return;
		}
		req.getSession().setAttribute("user", user);
		chain.doFilter(req, resp);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
