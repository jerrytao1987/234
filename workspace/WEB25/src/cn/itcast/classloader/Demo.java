package cn.itcast.classloader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Demo {

	public static void main(String[] args) throws IOException {
		Class clazz = Demo.class;
		ClassLoader classLoader = clazz.getClassLoader();
		URL resource = classLoader.getResource("jdbc.properties");//获得classPath(classes(src))下的任何资源；
		System.out.println(resource);
		String path = resource.getPath();
		System.out.println(path);
		InputStream is = classLoader.getResourceAsStream("jdbc.properties");
		System.out.println(is);
		byte[] b=new byte[1024];
		int len=0;
		while((len=is.read(b))!=-1){
			System.out.println(new String(b,0,len));
		}
		is.close();
	}

}
