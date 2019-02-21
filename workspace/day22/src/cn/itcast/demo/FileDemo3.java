package cn.itcast.demo;

import java.io.File;
import java.io.IOException;

public class FileDemo3 {

	public static void main(String[] args) throws IOException {
		function();
	}
	private static void function3() {
		File file = new File("D:\\develop\\eclipse-java-mars-2-win32\\eclipse\\eclipse.exe");
		File parent = file.getParentFile().getParentFile().getParentFile().getParentFile();
		System.out.println(parent);
	}
	private static void function2() {
		File f = new File("src");
		File absolute = f.getAbsoluteFile();
		System.out.println(absolute);
	}
	private static void function1() {
		File f = new File("D:\\develop\\eclipse-java-mars-2-win32\\eclipse\\eclipse.exe");
		long l = f.length();
		System.out.println(l);
	}
	public static void function(){
		//File f = new File("D:\\develop\\eclipse-java-mars-2-win32\\eclipse\\eclipse.exe");
		File f = new File("abc");
		String b = f.getName();
		System.out.println(b);
		
		String path = f.getPath();
		System.out.println(path);
		
		String absolutePath = f.getAbsolutePath();
		System.out.println(absolutePath);
	}
}
