package cn.itcast.demo2;

import java.io.File;

public class FileDemo1 {

	public static void main(String[] args) {
		File file = new File("d:\\demo");
		//File file = new File("D:\\develop\\eclipse-java-mars-2-win32\\eclipse");
		getAllJava(file);
	}
	public static void getAllJava(File file){
		File[] files = file.listFiles(new MyJavaFilter());
		for (File file2 : files) {
			if(file2.isDirectory()){
				getAllJava(file2);
			}else{
				System.out.println(file2);
			}
		}
	}
}
