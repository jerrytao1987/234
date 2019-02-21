package cn.itcast.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.domain.User;
import cn.itcast.jdbc.utils.C3P0Utils;

public class LoginServlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		int count=0;
		this.getServletContext().setAttribute("count", count);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "select * from user where username=? and password=?";
		User user=null;
		try {
			user = qr.query(sql, new BeanHandler<User>(User.class), username,password);
			if(user!=null){
				Integer count = (Integer)this.getServletContext().getAttribute("count");
				count++;
				response.getWriter().write(user.toString()+"---you are success login person:"+count);
				this.getServletContext().setAttribute("count", count);
			}else{
				response.getWriter().write("sorry your username or password is wrong!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}