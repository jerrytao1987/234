package cn.itcast.demo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPSend {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		InetAddress inet = InetAddress.getByName("127.0.0.1");
		DatagramSocket ds = new DatagramSocket();
		while(true){
			String message = sc.nextLine();
			byte[] data = message.getBytes();
			DatagramPacket dp = new DatagramPacket(data, data.length, inet, 6000);
			ds.send(dp);
		}
		//ds.close();
	}

}
