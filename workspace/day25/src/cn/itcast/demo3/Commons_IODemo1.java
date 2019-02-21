package cn.itcast.demo3;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Commons_IODemo1 {

	public static void main(String[] args) throws IOException {
		function3();
	}

	//复制目录，同时也复制目录里的文件
	public static void function3() throws IOException {
		FileUtils.copyDirectoryToDirectory(new File("d:\\demo"), new File("e:"));
	}


	public static void function2() throws IOException {
		FileUtils.copyFile(new File("d:\\热烈祝贺.psd"), new File("e:\\热烈祝贺.psd"));
	}


	public static void function1() throws IOException {
		FileUtils.writeStringToFile(new File("d:\\6.txt"),"我爱JAVA");
	}


	public static void function() throws IOException {
		String str = FileUtils.readFileToString(new File("d:\\5.txt"));
		System.out.println(str);
	}

}
