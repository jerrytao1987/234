package cn.itcast.demo;

import java.io.File;

public class FileDemo {

	public static void main(String[] args) {
		String path = File.pathSeparator;
		System.out.println(path);
		path = File.separator;
		System.out.println(path);
	}

}
