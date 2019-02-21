package cn.itcast.demo;

import java.io.File;
import java.io.IOException;

public class FileDemo4 {

	public static void main(String[] args) throws IOException {
		function2();
	}
	private static void function2() {
		File file = new File("D:\\develop\\eclipse-jee-mars-2-win32\\eclipse\\eclipse.exe");
		boolean b = file.isFile();
		System.out.println(b);
		
	}
	private static void function1() {
		File file = new File("D:\\develop\\eclipse-jee-mars-2-win32\\eclipse");
		boolean b = file.isDirectory();
		System.out.println(b);
		
	}
	private static void function() {
		File file = new File("D:\\develop\\eclipse-jee-mars-2-win32\\eclipse\\eclipse.exe");
		boolean b = file.exists();
		System.out.println(b);
	}
}
