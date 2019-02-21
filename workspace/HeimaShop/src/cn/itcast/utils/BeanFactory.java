package cn.itcast.utils;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class BeanFactory {

	public static Object getBean(String id) {
		String path = BeanFactory.class.getClassLoader().getResource("bean.xml").getPath();
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(path);
			//根据XPath表达式获得node节点
			Element element = (Element) document.selectSingleNode("//bean[@id='"+id+"']");
			String className = element.attributeValue("class");
			Class clazz = Class.forName(className);
			Object object = clazz.newInstance();
			return object;
		} catch (DocumentException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
