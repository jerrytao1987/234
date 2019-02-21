package cn.itcast.case1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyTestParster {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class clazz = TestDemo.class;
		Method[] methods = clazz.getMethods();
		if(methods!=null){
			for (Method method : methods) {
				boolean b = method.isAnnotationPresent(MyTest.class);
				if(b){
					method.invoke(clazz.newInstance(), null);
				}
			}
		}
	}

}
