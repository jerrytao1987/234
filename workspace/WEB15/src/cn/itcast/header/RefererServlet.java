package cn.itcast.header;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RefererServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String header = request.getHeader("referer");
		response.setContentType("text/html;charset=UTF-8");
		if(header!=null&&header.startsWith("http://localhost")){
			response.getWriter().write("奥运会金牌100块");
		}else{
			response.getWriter().write("你是盗链者，可耻！！！");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
