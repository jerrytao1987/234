package cn.itcast.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("name", "zhangsan");
		String id = session.getId();
		Cookie cookie = new Cookie("JSESSIONID", id);
		cookie.setPath("/WEB16");
		cookie.setMaxAge(60*10);
		response.addCookie(cookie);
		response.getWriter().write("JSESSIONID:"+id);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}