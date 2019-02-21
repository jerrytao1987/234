package cn.itcast.xml.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class TestDom4j {
	
	@Test
	public void testReadWebXML(){
		SAXReader saxReader = new SAXReader();
		try {
			Document doc = saxReader.read("src/cn/itcast/xml/schema/web.xml");
			Element rootElement = doc.getRootElement();
//			System.out.println(rootElement.getName());
//			System.out.println(rootElement.attributeValue("version"));
			List<Element> elements = rootElement.elements();
			for (Element element : elements) {
				if("servlet".equals(element.getName())){
					Element servletName = element.element("servlet-name");
					Element servletClass = element.element("servlet-class");
					System.out.println(servletName.getText());
					System.out.println(servletClass.getText());
					
				}
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
