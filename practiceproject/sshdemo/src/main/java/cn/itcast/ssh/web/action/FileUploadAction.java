package cn.itcast.ssh.web.action;

import java.io.File;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
@Controller
@Scope("prototype")
public class FileUploadAction extends ActionSupport {
	
	private File fileupload;
	private String fileuploadFileName;
	private String fileuploadContentType;
	
	public String upload() throws Exception {
		System.out.println(222);
		if(fileupload!=null){
			System.out.println(fileuploadFileName);
			System.out.println(fileuploadContentType);
			String path = ServletActionContext.getRequest().getRealPath("/upload");
			fileupload.renameTo(new File(path+File.separator+fileuploadFileName));
		}
		return SUCCESS;
	}
	public File getFileupload() {
		return fileupload;
	}
	public void setFileupload(File fileupload) {
		this.fileupload = fileupload;
	}
	public String getFileuploadFileName() {
		return fileuploadFileName;
	}
	public void setFileuploadFileName(String fileuploadFileName) {
		this.fileuploadFileName = fileuploadFileName;
	}
	public String getFileuploadContentType() {
		return fileuploadContentType;
	}
	public void setFileuploadContentType(String fileuploadContentType) {
		this.fileuploadContentType = fileuploadContentType;
	}
}
