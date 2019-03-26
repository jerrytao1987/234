package cn.itcast.ssh.web.action;

import java.io.File;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.ssh.pojo.Users;
import cn.itcast.ssh.service.UserService;
@Controller
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<Users> {
	
	private Users user=new Users();
	
	private File fileupload;
	private String fileuploadFileName;
	private String fileuploadContentType;
	public File getFileupload() {
		return fileupload;
	}

	public String getFileuploadFileName() {
		return fileuploadFileName;
	}

	public String getFileuploadContentType() {
		return fileuploadContentType;
	}

	public void setFileupload(File fileupload) {
		this.fileupload = fileupload;
	}

	public void setFileuploadFileName(String fileuploadFileName) {
		this.fileuploadFileName = fileuploadFileName;
	}

	public void setFileuploadContentType(String fileuploadContentType) {
		this.fileuploadContentType = fileuploadContentType;
	}

	@Autowired
	private UserService us;
	public UserService getUs() {
		return us;
	}

	public void setUs(UserService us) {
		this.us = us;
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	public String findByUsername() throws Exception {
		//Users user = us.findByUsername(username);
		System.out.println(user.getId());
		return SUCCESS;
	}
	public String login() throws Exception {
		System.out.println(user.getUsername());
		Users user1 = us.login(user);
		if(user1==null){
			return LOGIN;
		}
		ActionContext.getContext().getSession().put("user", user1);
		return SUCCESS;
	}
	public String upload() throws Exception {
		if(fileupload!=null){
			System.out.println(fileuploadFileName);
			System.out.println(fileuploadContentType);
			String path = ServletActionContext.getRequest().getRealPath("/upload");
			fileupload.renameTo(new File(path+File.separator+fileuploadFileName));
		}
		return SUCCESS;
	}

	public Users getModel() {
		return user;
	}

}
