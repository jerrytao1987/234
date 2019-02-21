package cn.itcast.content;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String filename = request.getParameter("filename");
		response.setContentType(this.getServletContext().getMimeType(filename));
		response.setHeader("Content-Disposition", "attachment;filename="+filename);
		String path = this.getServletContext().getRealPath("download/"+filename);
		InputStream in = new FileInputStream(path);
		ServletOutputStream out = response.getOutputStream();
		byte[] b=new byte[1024];
		int len=0;
		while((len=in.read(b))!=-1){
			out.write(b, 0, len);
		}
//		out.close();
		in.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}