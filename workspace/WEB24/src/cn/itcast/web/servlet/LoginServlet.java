package cn.itcast.web.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		UserService service = new UserService();
		User user=null;
		try {
			user = service.login(username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(user!=null){
			String username_code = URLEncoder.encode(username, "UTF-8");
			String autoLogin = request.getParameter("autoLogin");
			if(autoLogin!=null){
				Cookie cookie_username = new Cookie("cookie_username", username_code);
				Cookie cookie_password = new Cookie("cookie_password", user.getPassword());
				cookie_username.setMaxAge(60*60);
				cookie_password.setMaxAge(60*60);
				cookie_username.setPath(request.getContextPath());
				cookie_password.setPath(request.getContextPath());
				response.addCookie(cookie_username);
				response.addCookie(cookie_password);
			}else{
				Cookie cookie_username = new Cookie("cookie_username", "");
				Cookie cookie_password = new Cookie("cookie_password", "");
				cookie_username.setMaxAge(0);
				cookie_password.setMaxAge(0);
				cookie_username.setPath(request.getContextPath());
				cookie_password.setPath(request.getContextPath());
				response.addCookie(cookie_username);
				response.addCookie(cookie_password);
			}
			session.setAttribute("user", user);
			response.sendRedirect(request.getContextPath());
		}else{
			request.setAttribute("loginInfo", "用户名或密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}