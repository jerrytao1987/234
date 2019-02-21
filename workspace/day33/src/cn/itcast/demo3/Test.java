package cn.itcast.demo3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.lang.reflect.Method;
import java.util.Properties;

public class Test {

	public static void main(String[] args) throws Exception {
		Properties p = new Properties();
		Reader r = new FileReader("config.properties");
		p.load(r);
		r.close();
		Class c = Class.forName(p.getProperty("className"));
		Object obj = c.newInstance();
		Method method = c.getMethod(p.getProperty("method"));
		method.invoke(obj);
	}

}
