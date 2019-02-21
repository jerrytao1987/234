package cn.itcast.lastaccesstime;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LastAccessTimeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String currentTime = format.format(date);
		Cookie cookie = new Cookie("lastAccessTime", currentTime);
		cookie.setMaxAge(60*10*500);
		response.addCookie(cookie);
		
		String lastAccessTime = null;
		response.setContentType("text/html;charset=UTF-8");
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for (Cookie coo : cookies) {
				if("lastAccessTime".equals(coo.getName())){
					lastAccessTime = coo.getValue();
					response.getWriter().write("您上次的访问时间是："+lastAccessTime);
				}
			}
		}else{
			response.getWriter().write("您是第一次访问");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}