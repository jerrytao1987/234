package cn.itcast.demo2;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

public class ReflectTest {

	public static void main(String[] args) throws Exception {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("a");
		Class c = arr.getClass();
		Method method = c.getMethod("add", Object.class);
		method.invoke(arr, 1);
		method.invoke(arr, 991);
		System.out.println(arr);
	}

}
