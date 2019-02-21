package cn.itcast.demo2;

public class VarArgumentsDemo {

	public static void main(String[] args) {
		getSum(1,2);
		getSum(1,2,5,6,7);
	}
	public static void function(int i,int j,int...arr){
		
	}
	private static void getSum(int...arr){
		int sum=0;
		for (int i : arr) {
			sum +=i;
		}
		System.out.println(sum);
	}
	/*private static void getSum(int i, int j) {
		System.out.println(i+j);
	}*/

}
