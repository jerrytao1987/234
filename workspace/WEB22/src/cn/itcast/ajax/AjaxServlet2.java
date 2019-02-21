package cn.itcast.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
//		String nameStr = request.getParameter("name");
//		String name = new String(nameStr.getBytes("iso8859-1"),"UTF-8");
		String age = request.getParameter("age");
		System.out.println(name+"   "+age);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("{\"name\":\"汤姆\",\"age\":21}");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}