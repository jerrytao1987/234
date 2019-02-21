package cn.itcast.web.servlet;

import org.junit.Test;

public class TestMyServlet {
	
	@Test
	public void testMyServlet1(){
		String className = "cn.itcast.web.servlet.MyServletImpl";
		try {
			Class clazz = Class.forName(className);
			MyServletImpl my = (MyServletImpl)clazz.newInstance();
			my.init();
			my.serverce();
			my.destory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testMyServlet(){
		MyServletImpl my = new MyServletImpl();
		my.init();
		my.serverce();
		my.destory();
	}
}
