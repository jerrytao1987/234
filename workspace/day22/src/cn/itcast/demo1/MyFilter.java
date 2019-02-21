package cn.itcast.demo1;

import java.io.File;
import java.io.FileFilter;

public class MyFilter implements FileFilter {

	@Override
	public boolean accept(File pathname) {
		/*String name = pathname.getName();
		if(name.endsWith(".java")){
			return true;
		}
		return false;*/
		return pathname.getName().endsWith(".java");
	}
	
}
