package cn.itcast.web.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String methodName = req.getParameter("method");
		if(methodName==null){
			methodName="execute";
		}
		Class<? extends BaseServlet> clazz = this.getClass();
		try {
			Method method = clazz.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, req,resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void execute(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		request.getRequestDispatcher("").forward(request, response);
	}
}