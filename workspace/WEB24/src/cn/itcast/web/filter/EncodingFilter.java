package cn.itcast.web.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Servlet Filter implementation class EncodingFilter
 */
public class EncodingFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncodingFilter() {
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
		final HttpServletRequest req = (HttpServletRequest)request;
		HttpServletRequest enhanceRequest = (HttpServletRequest) Proxy.newProxyInstance(
				req.getClass().getClassLoader(),
				req.getClass().getInterfaces(),//new Class[]{HttpServletRequest.class},
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						String name = method.getName();
						//对指定方法进行增强
						if("getParameter".equals(name)){
							//执行方法获得返回值
							String invoke = (String) method.invoke(req, args);
							invoke = new String(invoke.getBytes("iso8859-1"),"UTF-8");
							return invoke;
						}
						//放行
						return method.invoke(req,args);
					}
				}
			);
		chain.doFilter(enhanceRequest, response);
		/*HttpServletRequest req = (HttpServletRequest)request;
//		request.setCharacterEncoding("UTF-8");
//		parameter = new String(parameter.getBytes("iso8859-1"),"UTF-8");
		EnhanceRequest enhanceRequest = new EnhanceRequest(req);
		chain.doFilter(enhanceRequest, response);*/
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

class EnhanceRequest extends HttpServletRequestWrapper{
	private HttpServletRequest request;
	public EnhanceRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	public String getParameter(String name){
		String parameter = request.getParameter(name);
		System.out.println(parameter);
		try {
			parameter = new String(parameter.getBytes("iso8859-1"),"UTF-8");
			System.out.println(parameter);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return parameter;
	}
}
