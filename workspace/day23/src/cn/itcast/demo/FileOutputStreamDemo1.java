package cn.itcast.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo1 {

	public static void main(String[] args) throws IOException {
		File file = new File("d:\\a.txt");
		FileOutputStream fos = new FileOutputStream(file,true);
		fos.write("hello\r\n".getBytes());
		fos.write("world".getBytes());
		fos.close();
	}

}
