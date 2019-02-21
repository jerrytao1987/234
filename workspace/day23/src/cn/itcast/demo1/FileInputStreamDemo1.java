package cn.itcast.demo1;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo1 {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("d:\\a.txt");
		byte[] b = new byte[1024];
		int len = 0;
		while((len = fis.read(b))!=-1){
			System.out.print(new String(b,0,len));
		}
		fis.close();
	}

}
