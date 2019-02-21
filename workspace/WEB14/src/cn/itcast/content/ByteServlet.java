package cn.itcast.content;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ByteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream outputStream = response.getOutputStream();
		String realPath = this.getServletContext().getRealPath("a.jpg");
		InputStream in = new FileInputStream(realPath);
		byte[] buffer = new byte[1024];
		int len=0;
		while((len=in.read(buffer))!=-1){
			outputStream.write(buffer, 0, len);
		}
		in.close();
		outputStream.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}