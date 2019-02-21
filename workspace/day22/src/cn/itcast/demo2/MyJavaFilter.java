package cn.itcast.demo2;

import java.io.File;
import java.io.FileFilter;

public class MyJavaFilter implements FileFilter {

	@Override
	public boolean accept(File pathname) {
		if(pathname.isDirectory()){
			return true;
		}
		return pathname.getName().toLowerCase().endsWith(".java");
	}

}
