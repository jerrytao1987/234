package cn.itcast.demo;

public class ArrayTool {

	public static void main(String[] args) {
		int[] arr= {1,2,3};
		int i = getArray(arr);
		System.out.println(i);
	}
	public static int getArray(int[] arr){
		int i = arr[3];
		return i+1;
	}
}
