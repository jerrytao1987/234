package tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPFileUploadServer {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(8888);
		while (true) {
			Socket s = ss.accept();
			new Thread(new MyFileUploadRunnable(s)).start();
		}
	}

}

class MyFileUploadRunnable implements Runnable {
	private Socket s;

	public MyFileUploadRunnable(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {

		try (BufferedInputStream bi = new BufferedInputStream(s.getInputStream());
				BufferedOutputStream bos = new BufferedOutputStream(
						new FileOutputStream("e:/t" + System.currentTimeMillis() + ".jpg"));
				BufferedOutputStream bo = new BufferedOutputStream(s.getOutputStream())) {
			byte[] buf = new byte[1024];
			int len = -1;
			while ((len = bi.read(buf)) != -1) {
				bos.write(buf, 0, len);
			}
			bo.write("文件上传成功".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}