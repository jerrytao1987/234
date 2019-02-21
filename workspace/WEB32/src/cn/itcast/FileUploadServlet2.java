package cn.itcast;

import java.io.File;
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
import org.apache.commons.io.IOUtils;

public class FileUploadServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tempPath = this.getServletContext().getRealPath("temp");
//		DiskFileItemFactory factory = new DiskFileItemFactory(1024*1024, tempPath);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(1024*1024);
		factory.setRepository(new File(tempPath));
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		boolean multipartContent = upload.isMultipartContent(request);
		if(multipartContent){
			try {
				List<FileItem> parseRequest = upload.parseRequest(request);
				if(parseRequest!=null){
					for (FileItem fileItem : parseRequest) {
						boolean formField = fileItem.isFormField();
						if(formField){
							String fieldName = fileItem.getFieldName();
							String fieldValue = fileItem.getString("UTF-8");
							System.out.println(fieldName+":"+fieldValue);
						}else{
							String fileName = fileItem.getName();
							InputStream in = fileItem.getInputStream();
							String path = this.getServletContext().getRealPath("upload");
							OutputStream out = new FileOutputStream(path+"/"+fileName);
							IOUtils.copy(in, out);
							out.close();
							in.close();
							
							//删除临时文件
							fileItem.delete();
							
						}
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		}else{
			
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}