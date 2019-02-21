package cn.itcast.copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy {

	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("d:\\a.txt");
			fos = new FileOutputStream("e:\\a.txt");
			int len = 0;
			/*byte[] b = new byte[1024];
			while((len=fis.read(b))!=-1){
				fos.write(b, 0, len);
			}*/
			while((len = fis.read())!=-1){
				fos.write(len);
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
				// TODO Auto-generated catch block
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
	}

}
