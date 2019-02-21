package cn.itcast.demo4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPThreadServer {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8000);
		ExecutorService pool = Executors.newFixedThreadPool(10);
		while(true){
			Socket socket = server.accept();
			pool.submit(new Upload(socket));
			//new Thread(new Upload(socket)).start();
		}
		
	}

}
