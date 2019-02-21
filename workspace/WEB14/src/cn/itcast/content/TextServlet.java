package cn.itcast.content;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TextServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setCharacterEncoding("UTF-8");//这两句不常用，直接写下一句即可
//		response.setHeader("Content-Type", "text/html;charset=UTF-8");//这两句不常用，直接写下一句即可
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
//		writer.write("hello response!!!");
		writer.write("你好");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}