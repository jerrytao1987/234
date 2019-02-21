package cn.itcast.demo4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Random;

public class Upload implements Runnable {
	private Socket socket;
	public Upload(Socket socket){
		this.socket=socket;
	}
	public void run() {
		try {
			InputStream in = socket.getInputStream();
			File upload = new File("e:\\upload");
			if(!upload.exists()){
				upload.mkdirs();
			}
			String fileName = "itcast"+System.currentTimeMillis()+new Random().nextInt(999999)+".jpg";
			FileOutputStream fos = new FileOutputStream(upload+File.separator+fileName);
			byte[] b = new byte[1024];
			int len = 0;
			while((len=in.read(b))!=-1){
				fos.write(b, 0, len);
			}
			socket.getOutputStream().write("上传成功".getBytes());
			fos.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
