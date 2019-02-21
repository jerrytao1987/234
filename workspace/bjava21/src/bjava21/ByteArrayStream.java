package bjava21;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

public class ByteArrayStream {
	public static void main(String[] args) {
		ByteArrayInputStream bis = new ByteArrayInputStream("ABCDEFG".getBytes());
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		int by = 0;
		while((by=bis.read())!=-1){
			bos.write(by);
		}
		System.out.println(bos.size());
		System.out.println(bos.toString());
		//bos.writeTo(new FileOutputStream(""));
	}
}
