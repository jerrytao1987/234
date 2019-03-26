package test;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestIntrospector {
	public static void main(String[] args) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		PropertyDescriptor pd = new PropertyDescriptor("username", UserInfo.class);
		String name = pd.getName();
		System.out.println(name);
		Method wm = pd.getWriteMethod();
		UserInfo ui=new UserInfo();
		wm.invoke(ui, "abc");
		System.out.println(ui.getUsername());
		Method rm = pd.getReadMethod();
		Object invoke = rm.invoke(ui);
		System.out.println(invoke.toString());
	}
}
