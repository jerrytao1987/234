package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPSend {
	/*
	* 发送端
	 * 1,创建DatagramSocket对象
	 * 2，创建DatagramPacket对象，并封装数据
	 * 3，发送数据
	 * 4，释放流资源
	 */
	public static void main(String[] args) throws IOException {
		while(true){
			Scanner sc = new Scanner(System.in);
			String content = sc.nextLine();
			byte[] buf = content.getBytes();
			DatagramSocket ds = new DatagramSocket();
			DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("localhost"), 6000);
			ds.send(dp);
			ds.close();
			sc.close();
		}
	}
}
