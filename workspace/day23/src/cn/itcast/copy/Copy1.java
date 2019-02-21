package cn.itcast.copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy1 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("d:\\热烈祝贺.psd");
			fos = new FileOutputStream("e:\\热烈祝贺.psd");
			byte[] b = new byte[1024*20];
			int len = 0;
			while((len=fis.read(b))!=-1){
				fos.write(b, 0, len);
			}
		} catch (IOException e) {
			System.out.println(e);
			throw new RuntimeException("文件复制失败");
		} finally {
			try {
				if(fos != null){
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("释放资源失败");
			} finally {
				try{
				if (fis != null) {
					fis.close();
				}
				}catch(IOException e){
					e.printStackTrace();
					throw new RuntimeException("释放资源失败");
				}
			}
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}

}
