package cn.itcast.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import cn.itcast.domain.Category;
import cn.itcast.domain.Product;
import cn.itcast.utils.BeanFactory;
import cn.itcast.utils.CommonsUtils;

public class AdminAddProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product product = new Product();
		Map<String, Object> map = new HashMap<String, Object>();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		boolean multipartContent = upload.isMultipartContent(request);
		if(multipartContent){
			try {
				List<FileItem> FileItemList = upload.parseRequest(request);
				for (FileItem fileItem : FileItemList) {
					if(fileItem.isFormField()){
						String fieldName = fileItem.getFieldName();
						String fileValue = fileItem.getString("UTF-8");
						map.put(fieldName, fileValue);
						
					}else{
						String fileNameStr = fileItem.getName();
						int index = fileNameStr.lastIndexOf(".");
						String extendName = fileNameStr.substring(index, fileNameStr.length());
						String path = this.getServletContext().getRealPath("upload");
						String fileName = CommonsUtils.getUUID()+extendName;
						InputStream in = fileItem.getInputStream();
						OutputStream out = new FileOutputStream(path+"/"+fileName);
						IOUtils.copy(in, out);
						map.put("pimage", "upload/"+fileName);
						out.close();
						in.close();
						fileItem.delete();
					}
					
				}
				
				BeanUtils.populate(product, map);
				
				product.setPid(CommonsUtils.getUUID());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date = sdf.parse(sdf.format(new Date()));
				product.setPdate(date);
				product.setPflag(0);
				Category category = new Category();
				category.setCid(map.get("cid").toString());
				product.setCategory(category);
				
				AdminService service = (AdminService) BeanFactory.getBean("adminService");
				service.saveProduct(product);
				
			} catch (FileUploadException | IllegalAccessException | InvocationTargetException | ParseException e) {
				e.printStackTrace();
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}