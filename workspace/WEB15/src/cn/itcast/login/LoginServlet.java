package cn.itcast.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.jdbc.utils.C3P0Utils;
import cn.itcast.register.User;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User login = login(username, password);
		if(login!=null){
			response.sendRedirect(request.getContextPath());
		}else{
			request.setAttribute("loginInfo", "用户名或密码错误!");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
	
	public User login(String username,String password){
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from user where username=? and password=?";
		try {
			User rs = qr.query(sql, new BeanHandler<User>(User.class), username,password);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}