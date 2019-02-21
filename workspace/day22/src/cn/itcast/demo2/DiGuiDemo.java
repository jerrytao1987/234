package cn.itcast.demo2;

public class DiGuiDemo {

	public static void main(String[] args) {
		//int sum = getSum(100);
		//int sum = getMul(10);
		int sum = getFBNQ(12);
		System.out.println(sum);
	}
	public static int getFBNQ(int m){
		if(m==1){
			return 1;
		}
		if(m==2){
			return 1;
		}
		return getFBNQ(m-1)+getFBNQ(m-2);
	}
	public static int getMul(int n){
		if(n==1){
			return 1;
		}
		return n*getMul(--n);
	}
	public static int getSum(int n){
		if(n==1){
			return 1;
		}else{
			return n+getSum(--n);
		}
	}
}
