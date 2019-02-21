package cn.itcast.demo1;

import java.io.File;

public class FileDemo {

	public static void main(String[] args) {
		function();
	}

	private static void function2() {
		File[] file = File.listRoots();
		for (File file2 : file) {
			System.out.println(file2);
		}
	}

	private static void function1() {
		File file = new File("D:\\develop\\eclipse-jee-mars-2-win32\\eclipse");
		File[] fileList = file.listFiles();
		for (File file2 : fileList) {
			System.out.println(file2);
		}
	}

	private static void function() {
		File file = new File("D:\\develop\\eclipse-jee-mars-2-win32\\eclipse");
		String[] list = file.list();
		System.out.println(list.length);
		for(String i:list){
			System.out.println(i);
		}
	}

}
