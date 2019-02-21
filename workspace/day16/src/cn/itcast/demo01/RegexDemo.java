package cn.itcast.demo01;

public class RegexDemo {

	public static void main(String[] args) {
		//checkQQ();
		checkTel();
		//split_1();
		replaceALL_1();
		checkMail();
	}
	public static void checkMail(){
		String mail = "309505550@qq.com.cn";
		boolean b = mail.matches("[a-zA-Z1-9_][a-zA-Z0-9_]*@[a-z1-9]+(\\.[a-z]+)+");
		System.out.println(b);
	}
	public static void replaceALL_1(){
		String str = "Hello12345World6789012";
		String str1 = str.replaceAll("\\d+", "#");
		System.out.println(str1);
	}
	public static void split_1(){
		String str = "18-22-40-65";
		String[] result = str.split("-");
		for (String string : result) {
			System.out.println(string);
		}
	}
	public static void checkTel(){
		String tel = "13333333333";
		boolean b = tel.matches("1[34578]\\d{9}");
		System.out.println(b);
	}
	public static void checkQQ() {
		String QQ = "111111111";
		boolean b = QQ.matches("[1-9][\\d]{4,9}");
		System.out.println(b);
	}

}
