package cn.itcast.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.utils.CommonsUtils;
import cn.itcast.utils.CookiesUtils;
import cn.itcast.utils.MailUtils;

public class UserServlet extends BaseServlet {
	
	public void loginOut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user!=null){
			session.removeAttribute("user");
		}
		Cookie cookie_username = CookiesUtils.getCookie(request.getCookies(), "cookie_username");
		Cookie cookie_password = CookiesUtils.getCookie(request.getCookies(), "cookie_password");
		if(cookie_username!=null){
			Cookie username = new Cookie("cookie_username", "");
			username.setMaxAge(0);
			username.setPath(request.getContextPath());
			response.addCookie(username);
		}
		if(cookie_password!=null){
			Cookie password = new Cookie("cookie_password", "");
			password.setMaxAge(0);
			password.setPath(request.getContextPath());
			response.addCookie(password);
		}
		response.sendRedirect(request.getContextPath());
	}
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User userSession = (User) session.getAttribute("user");
		if(userSession!=null){
			response.sendRedirect(request.getContextPath());
		}
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rememberUsername = request.getParameter("rememberUsername");
		String autoLogin = request.getParameter("autoLogin");
		UserService service = new UserService();
		User user = service.findUser(username,password);
		if(user!=null){
			if("rememberUsername".equals(rememberUsername)){
				Cookie usernameCookie = new Cookie("username", user.getUsername());
				usernameCookie.setMaxAge(60*60*24*30);
				usernameCookie.setPath(request.getContextPath()+"/login.jsp");
				response.addCookie(usernameCookie);
			}else{
				Cookie usernameCookie = new Cookie("username", "");
				usernameCookie.setMaxAge(0);
				usernameCookie.setPath(request.getContextPath()+"/login.jsp");
				response.addCookie(usernameCookie);
			}
			if("autoLogin".equals(autoLogin)){
				String username_encode = URLEncoder.encode(user.getUsername(), "UTF-8");
				Cookie cookie_username = new Cookie("cookie_username", username_encode);
				Cookie cookie_password = new Cookie("cookie_password", user.getPassword());
				cookie_username.setMaxAge(60*60*24*7);
				cookie_password.setMaxAge(60*60*24*7);
				cookie_username.setPath(request.getContextPath());
				cookie_password.setPath(request.getContextPath());
				response.addCookie(cookie_username);
				response.addCookie(cookie_password);
			}else{
				Cookie cookie_username = new Cookie("cookie_username", "");
				Cookie cookie_password = new Cookie("cookie_password", "");
				cookie_username.setMaxAge(0);
				cookie_password.setMaxAge(0);
				cookie_username.setPath(request.getContextPath());
				cookie_password.setPath(request.getContextPath());
				response.addCookie(cookie_username);
				response.addCookie(cookie_password);
			}
			session.setAttribute("user", user);
			response.sendRedirect(request.getContextPath());
		}else{
			request.setAttribute("loginInfo", "用户名或密码错误！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		};
	}
	
	
	public void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Map<String, String[]> properties = request.getParameterMap();
		User user = new User();

		try {
			DateConverter converter = new DateConverter();
			converter.setPatterns(new String[] { "yyyy-MM-dd", "yyyy-MM-dd hh:mm:ss" });
			ConvertUtils.register(converter, Date.class);
			/*
			 * ConvertUtils.register(
			 * new Converter() {
			 * 
			 * @Override 
			 * public Object convert(Class arg0, Object arg1) {
			 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
			 * Date parse=null; 
			 * try { parse = sdf.parse(arg1.toString()); } catch (ParseException e) { e.printStackTrace(); }
			 *  return parse; } 
			 *  },
			 * Date.class);
			 */
			BeanUtils.populate(user, properties);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

		String activeCode = CommonsUtils.getUUID();
		user.setUid(activeCode);
		user.setTelephone(null);
		user.setState(0);
		user.setCode(activeCode);
		UserService service = new UserService();
		boolean isRegisterSuccess = service.regist(user);

		if (isRegisterSuccess) {
			String emailMsg = "恭喜您注册成功，请点击下面的连接进行激活账户" + "<a href='http://localhost/HeimaShop/user?method=active&activeCode="
					+ activeCode + "'>" + "http://localhost/HeimaShop/user?method=active&activeCode=" + activeCode + "</a>";
			try {
				MailUtils.sendMail(user.getEmail(), emailMsg);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			response.sendRedirect(request.getContextPath() + "/registerSuccess.jsp");
		} else {
			response.sendRedirect(request.getContextPath() + "/registerFail.jsp");

		}
	}

	public void checkCode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String checkCode = request.getParameter("checkCode");
		String checkcode_session = (String) request.getSession().getAttribute("checkcode_session");
		boolean isRight = checkCode.equals(checkcode_session) ? true : false;
		String json = "{\"isRight\":" + isRight + "}";
		response.getWriter().write(json);
	}

	public void checkUsername(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		UserService service = new UserService();
		boolean isExist = service.checkUsername(username);

		String json = "{\"isExist\":" + isExist + "}";
		response.getWriter().write(json);
	}

	public void active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String activeCode = request.getParameter("activeCode");

		UserService service = new UserService();
		service.active(activeCode);

		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}
}