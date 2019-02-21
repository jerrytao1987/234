package cn.itcast.attribute;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MyServletContextAttributeListener implements ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent scab) {
		System.out.println(scab.getName());
		System.out.println(scab.getValue());
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scab) {
		System.out.println(scab.getName());
		System.out.println(scab.getValue());
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scab) {
		System.out.println(scab.getName());//获得修改前的name
		System.out.println(scab.getValue());//获得修改前的value
	}

}
