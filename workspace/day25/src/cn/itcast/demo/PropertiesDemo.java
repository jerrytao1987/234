package cn.itcast.demo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {

	public static void main(String[] args) throws IOException {
		function1();
	}

	private static void function2() throws IOException {
		Properties p = new Properties();
		p.setProperty("name", "zhangsan");
		p.setProperty("age", "28");
		p.setProperty("email", "123456@qq.com");
		FileWriter fw = new FileWriter("d:\\pro.properties");
		p.store(fw,"");
		fw.close();
	}

	private static void function1() throws IOException {
		Properties p = new Properties();
		FileReader fr = new FileReader("d:\\pro.properties");
		p.load(fr);
		fr.close();
		System.out.println(p);
	}

	private static void function() {
		Properties p = new Properties();
		p.setProperty("a", "1");
		p.setProperty("b", "2");
		p.setProperty("c", "3");
		p.setProperty("d", "4");
		System.out.println(p);
		String value = p.getProperty("c");
		System.out.println(value);
		
		Set<String> set = p.stringPropertyNames();
		for (String key : set) {
			System.out.println(p.getProperty(key));
		}
	}

}
