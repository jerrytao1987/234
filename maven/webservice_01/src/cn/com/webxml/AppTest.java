package cn.com.webxml;

public class AppTest {
	public static void main(String[] args) {
		MobileCodeWS ss = new MobileCodeWS();
		MobileCodeWSSoap soap = ss.getMobileCodeWSSoap();
		String ret = soap.getMobileCodeInfo("18555225555", null);
		System.out.println(ret);
	}
}
