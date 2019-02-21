package cn.itcast.demo1;

public class ExceptionDemo2 {

	public static void main(String[] args){
		int avg = getAvg(50,60,-70,80);
		System.out.println(avg);
	}

	public static int getAvg(int...arr) {
		int sum = 0;
		for(int i:arr){
			if(i<=0){
				throw new FuShuException("异常了！");
			}
			sum += i;
		}
		return sum/arr.length;
	}
}
