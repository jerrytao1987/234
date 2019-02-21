package com.itheima.bos.web.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.entity.User;
import com.itheima.bos.service.IUserService;
import com.itheima.bos.utils.BOSUtils;
import com.itheima.bos.utils.MD5Utils;
import com.itheima.bos.web.action.base.BaseAction;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	
	private String[] roleIds;
	
	public void setRoleIds(String[] roleIds) {
		this.roleIds = roleIds;
	}
	private String checkcode;

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	@Resource(name="userServiceImpl")
	private IUserService userService;
	
	public String login() throws Exception {
		String validateCode = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
		if(StringUtils.isNotBlank(checkcode) && checkcode.equals(validateCode)){
			Subject subject = SecurityUtils.getSubject();
			AuthenticationToken token = new UsernamePasswordToken(model.getUsername(),MD5Utils.md5(model.getPassword()));
			try {
				subject.login(token );
			} catch (Exception e) {
				StackTraceElement[] stackTrace = e.getStackTrace();
				String className = stackTrace[0].getClassName();
				if("org.apache.shiro.authc.pam.ModularRealmAuthenticator".equals(className) || "org.apache.shiro.realm.AuthenticatingRealm".equals(className)){
					this.addActionError("输入的用户名或者密码错误！");
					return LOGIN;
				}
				return LOGIN;
			}
			User user = (User) subject.getPrincipal();
			ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
			return SUCCESS;
		}else{
			this.addActionError("输入的验证码错误！");
			return LOGIN;
		}
	}
/*	public String login() throws Exception {
		String validateCode = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
		if(StringUtils.isNotBlank(checkcode) && checkcode.equals(validateCode)){
			User user = userService.login(model);
			if(user!=null){
				ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
				return SUCCESS;
			}else{
				this.addActionError("用户名或者密码输入错误！");
				return LOGIN;
			}
		}else{
			this.addActionError("输入的验证码错误！");
			return LOGIN;
		}
	}
*/
	public String logout() throws Exception {
		ServletActionContext.getRequest().getSession().invalidate();
		return LOGIN;
	}

	public String editPassword() throws Exception {
		String f="1";
		User user = BOSUtils.getLoginUser();
		try {
			userService.editPassword(user.getId(),model.getPassword());
		} catch (Exception e) {
			f="0";
			e.printStackTrace();
		}
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(f);
		return NONE;
	}
	public String add() throws Exception {
		
		userService.save(model,roleIds);
		return "list";
	}
	public String pageQuery() throws Exception {
		userService.pageQuery(pageBean);
		java2Json(pageBean, new String[]{"password","noticebills","roles"});
		return NONE;
	}
	
	
}
