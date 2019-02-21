package cn.itcast.annotation;

import java.lang.reflect.Method;

public class MyAnnoParser {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		//解析show方法上面的@MyAnno
		Class clazz = MyAnnoTest.class;
		Method method = clazz.getMethod("show", String.class);
		MyAnno myAnno = method.getAnnotation(MyAnno.class);
		System.out.println(myAnno.name());
		System.out.println(myAnno.age());
	}

}
