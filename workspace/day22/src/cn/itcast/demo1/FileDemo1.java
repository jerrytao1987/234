package cn.itcast.demo1;

import java.io.File;

public class FileDemo1 {

	public static void main(String[] args) {
		function();
	}


	private static void function() {
		File file = new File("D:\\demo");
		File[] fileList = file.listFiles(new MyFilter());
		for (File file2 : fileList) {
			System.out.println(file2);
		}
	}

}
