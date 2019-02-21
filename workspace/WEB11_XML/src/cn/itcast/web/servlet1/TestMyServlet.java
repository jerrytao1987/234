package cn.itcast.web.servlet1;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class TestMyServlet {
	
	@Test
	public void testMyServlet(){
		SAXReader saxReader = new SAXReader();
		try {
			Document doc = saxReader.read("src/cn/itcast/web/servlet1/web.xml");
			Element rootElement = doc.getRootElement();
			Element servletElement = rootElement.element("servlet");
			String servletClass = servletElement.element("servlet-class").getText();
			Class clazz = Class.forName(servletClass);
			MyServlet1 my = (MyServlet1)clazz.newInstance();
			my.init();
			my.serverce();
			my.destory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
