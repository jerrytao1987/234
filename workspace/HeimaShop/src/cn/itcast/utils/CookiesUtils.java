package cn.itcast.utils;

import javax.servlet.http.Cookie;

public class CookiesUtils {
	public static Cookie getCookie(Cookie[] cookies,String cookieName){
		if(cookieName==null){
			return null;
		}
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals(cookieName)){
					return cookie;
				}
			}
		}
		return null;
	}
}
