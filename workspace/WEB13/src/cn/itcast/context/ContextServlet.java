package cn.itcast.context;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得ServletContext对象
		ServletContext context = this.getServletContext();
		String initParameter = context.getInitParameter("driver");
		System.out.println(initParameter);
		//获得a b c d.txt绝对路径
		String realPath_A = context.getRealPath("/a.txt");
		System.out.println(realPath_A);
		String realPath_B = context.getRealPath("/WEB-INF/b.txt");
		System.out.println(realPath_B);
		String realPath_C = context.getRealPath("/WEB-INF/Classes/c.txt");
		System.out.println(realPath_C);
		//不能获取d.txt
		//通过类加载器获取classes路径
		String path = ContextServlet.class.getClassLoader().getResource("c.txt").getPath();
		System.out.println(path);
		
		context.setAttribute("name", "zhangsan");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}