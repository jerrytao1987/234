package bjava25;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.TreeSet;

import org.junit.Test;

public class RegexTest {
	@Test
	public void test_1() throws Exception {
		String str = "我我...我我...我要..要要...要要...学学学....学学...编编编...编程..程.程程...程...程";
		str=str.replaceAll("\\.+", "");
		System.out.println(str);
		str=str.replaceAll("(.)\\1+", "$1");
		System.out.println(str);
	}
	@Test
	public void ipSort() throws Exception {
		String ip = "192.68.1.254 102.49.23.013 10.10.10.10 2.2.2.2 8.109.90.30";
		ip = ip.replaceAll("(\\d+)", "00$1");
		System.out.println(ip);
		ip = ip.replaceAll("0*(\\d{3})", "$1");
		System.out.println(ip);
		String[] arr = ip.split(" ");
		TreeSet<String> ts = new TreeSet<String>(Arrays.asList(arr));
		System.out.println(ts);
	}
	@Test
	public void checkMail() throws Exception {
		String mail = "ab12@sina.com";
		String reg = "[a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-zA-Z]+)+";//较为精确的匹配
		reg = "\\w+@\\w+(\\.\\w+)+";//相对不太精确的匹配
		System.out.println(mail.matches(reg));
	}
}
