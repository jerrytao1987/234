package test;

import java.util.UUID;

public class TestMD5Utils {
	public static void main(String[] args) {
		String md5 = MD5Utils.md5("abc");
		System.out.println(md5);
		System.out.println(md5.length());
	}
}
