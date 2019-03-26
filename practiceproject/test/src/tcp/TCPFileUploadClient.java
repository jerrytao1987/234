package tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class TCPFileUploadClient {
	public static void main(String[] args) throws IOException {

		try (Socket s = new Socket("192.168.0.103", 8888);
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream("d:/t.jpg"));
				BufferedOutputStream bo = new BufferedOutputStream(s.getOutputStream());
				BufferedInputStream bi = new BufferedInputStream(s.getInputStream())) {

			byte[] buf = new byte[1024];
			int len = -1;
			while ((len = bis.read(buf)) != -1) {
				bo.write(buf, 0, len);
			}
			//bo.flush();
			s.shutdownOutput();

			/*
			 * byte[] buff = new byte[1024]; int length = bi.read(buff);
			 */
			len = bi.read(buf);
			String msg = new String(buf, 0, len);
			System.out.println(msg);
		}
	}
}
