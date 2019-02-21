package cn.itcast.demo02;

public class SystemDemo {

	public static void main(String[] args) {
		function3();
	}
	public static void function4(){
		int[] src = {11,33,44,555,66,77};
		int[] desc ={88,99,0,22};
		System.arraycopy(src, 1, desc, 1, 2);
		for (int i : desc) {
			System.out.println(i);
		}
	}
	public static void function3(){
		System.out.println(System.getProperties());
	}
	public static void function2(){
		new Person();
		new Person();
		new Person();
		new Person();
		new Person();
		new Person();
		new Person();
		new Person();
		new Person();
		new Person();
		System.gc();
	}
	public static void function1(){
		while(true){
			System.out.println("循环体");
			System.exit(0);
		}
	}
	public static void function(){
		long start = System.currentTimeMillis();
		for(int i = 0;i<10000;i++){
			System.out.println(i);
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
}
