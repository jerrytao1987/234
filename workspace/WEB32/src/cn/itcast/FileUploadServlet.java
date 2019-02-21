package cn.itcast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> parseRequest = upload.parseRequest(request);
			for (FileItem fileItem : parseRequest) {
				boolean formField = fileItem.isFormField();
				if(formField){
					String fieldName = fileItem.getFieldName();
					String fieldValue = fileItem.getString();
					System.out.println(fieldName+":"+fieldValue);
				}else{
					String fileName = fileItem.getName();
					InputStream inputStream = fileItem.getInputStream();
					String path = this.getServletContext().getRealPath("upload");
					OutputStream out = new FileOutputStream(path+"/"+fileName);
					byte[] b = new byte[1024];
					int len = 0;
					while((len=inputStream.read(b))!=-1){
						out.write(b, 0, len);
					}
					out.close();
					inputStream.close();
					
					
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}