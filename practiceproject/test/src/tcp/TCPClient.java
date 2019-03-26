package tcp;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPClient {
	/*
	 * TCP 客户端
	 * 
	 * 1，创建客户端Socket对象,（指定要连接的服务器地址与端口号）
	 * 2,获取服务器端的反馈回来的信息
	 * 3,关闭流资源
	 */
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("192.168.0.103", 8888);
		OutputStream out = socket.getOutputStream();
		out.write("请求连接服务端".getBytes());
		InputStream in = socket.getInputStream();
		BufferedInputStream bi = new BufferedInputStream(in);
		byte[] buf = new byte[1024];
		int len=bi.read(buf);
		System.out.println(new String(buf,0,len));
		out.close();
		bi.close();
		socket.close();
	}
}
