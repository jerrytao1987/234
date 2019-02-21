package cn.itcast.demo4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {

	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1", 8000);
		OutputStream out = socket.getOutputStream();
		FileInputStream fis = new FileInputStream("d:\\t.jpg");
		byte[] b = new byte[1024];
		int len=0;
		while((len=fis.read(b))!=-1){
			out.write(b,0,len);
		}
		socket.shutdownOutput();
		InputStream in = socket.getInputStream();
		len = in.read(b);
		System.out.println(new String(b,0,len));
		fis.close();
		socket.close();
	}

}
