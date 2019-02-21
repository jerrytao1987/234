package cn.itcast.demo3;

public class Test {
	public static void main(String[] args) {
		new Smoking(){
			public void smoking(){
				System.out.println("匿名内部类");
			}
		}.smoking();
		
	}
}
