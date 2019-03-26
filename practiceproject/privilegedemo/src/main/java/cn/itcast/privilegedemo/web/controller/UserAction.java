package cn.itcast.privilegedemo.web.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import cn.itcast.privilegedemo.pojo.User;
import cn.itcast.privilegedemo.service.UserService;

@Controller
public class UserAction {
	/*@Autowired
	private UserService userService;*/
	@RequestMapping("/toLogin")
	public String toLogin(){
		return "login";
	}
	@RequestMapping("/login")
	public String login(User user,HttpSession session,Model model){
		if(user==null||StringUtils.isBlank(user.getUsername())||StringUtils.isBlank(user.getPassword())){
			model.addAttribute("msg", "用户名或者密码不能为空");
			return "login";
		}
		//获取shiro框架提供的subject对象
		Subject subject = SecurityUtils.getSubject();
		//创建一个用户名密码令牌
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
		try {
			//登录认证
			subject.login(token);
		} catch (AuthenticationException e) {
			model.addAttribute("msg", "用户名或者密码错误！");
			return "login";
		}
		//获取user对象
		User user1 = (User) subject.getPrincipal();
		session.setAttribute("user", user1);
		return "index";
	}
	@RequestMapping("/toUnauthorized")
	public String toUnauthorized(){
		return "unauthorizedUrl";
		
	}
	/*@RequestMapping("/loginOut")
	public String loginOut(HttpSession session){
		session.removeAttribute("user");
		return "login";
		
	}*/
}