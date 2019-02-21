package cn.itcast.demo2;

import java.io.File;

public class FileDemo {

	public static void main(String[] args) {
		//File file = new File("d:\\demo");
		File file = new File("D:\\develop\\eclipse-java-mars-2-win32\\eclipse");
		getAllDir(file);
	}
	public static void getAllDir(File file){
		System.out.println(file);
		File[] fileArr = file.listFiles();
		for (File file2 : fileArr) {
			if(file2.isDirectory()){
				getAllDir(file2);
			}else{
				System.out.println(file2);
			}
		}
	}
}
