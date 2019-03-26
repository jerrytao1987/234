package cn.itcast.springmvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.springmvc.pojo.User;
import cn.itcast.springmvc.service.UserService;
@RequestMapping("user")
@Controller
public class UserController {
	@Autowired
	private UserService us;
	@RequestMapping("/toLogin")
	public String toLogin(String requestURL,Model model){
		model.addAttribute("requestURL", requestURL);
		return "login";
	}
	@RequestMapping("login")
	public String login(User user,String requestURL,HttpServletResponse response,HttpSession session) throws IOException{
		if(user==null){
			return "login";
		}
		User user1 = us.login(user);
		if(user1==null){
			return "login";
		}
		session.setAttribute("user", user1);
		if(!StringUtils.isEmpty(requestURL)){
			System.out.println(requestURL);
			response.sendRedirect(requestURL);
		}
		return "index";
	}
}
