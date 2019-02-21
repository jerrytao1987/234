package cn.itcast.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo2 {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		try{
			fos = new FileOutputStream("d:\\a.txt");
			fos.write(100);
		}catch(IOException ex){
//			System.out.println(ex.getMessage());
//			System.out.println(ex.toString());
			ex.printStackTrace();
			throw new RuntimeException("文件写入失败，请重试");
		}finally{
			try {
				if(fos != null){
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("文件关闭失败");
			}
			
		}
	}

}
