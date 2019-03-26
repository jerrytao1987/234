package tcp;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	/*
	 * TCP 服务器端
	 * 
	 * 1,创建服务器ServerSocket对象（指定服务器端口号）
	 * 2，开启服务器了，等待客户端的连接，当客户端连接后，可以获取到连接服务器的客户端Socket对象
	 * 3,给客户端反馈信息
	 * 4,关闭流资源
	 */
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(8888);
		Socket socket = serverSocket.accept();
		InputStream in = socket.getInputStream();
		BufferedInputStream bi = new BufferedInputStream(in);
		byte[] buf = new byte[1024];
		int len = bi.read(buf);
		System.out.println(new String(buf,0,len));
		
		OutputStream out = socket.getOutputStream();
		out.write("你已经连接上了服务器".getBytes());
		out.close();
		bi.close();
		socket.close();
	}
}
