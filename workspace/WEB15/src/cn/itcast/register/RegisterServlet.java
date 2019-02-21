package cn.itcast.register;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;

import cn.itcast.jdbc.utils.C3P0Utils;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//只适合post方式
		
		/*String username = request.getParameter("username");
		//get方式乱码解决
		 username = new String(username.getBytes("iso-8859-1"),"UTF-8");
		String password = request.getParameter("password");
		...
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		...*/
		User user = new User();
		Map<String, String[]> properties = request.getParameterMap();
		try {
			BeanUtils.populate(user, properties);
		} catch (IllegalAccessException|InvocationTargetException e) {
			e.printStackTrace();
		}
		user.setUid(UUID.randomUUID().toString());
		regist(user);
		
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public void regist(User user){
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
		try {
			qr.update(sql,user.getUid(),user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),null,user.getBirthday(),user.getSex(),null,null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}