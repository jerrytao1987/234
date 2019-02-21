package cn.itcast.demo;

public class ExceptionDemo {

	public static void main(String[] args) throws Exception {
		int[] arr = null;
		int i = getArray(arr);
		System.out.println(i);
	}
	public static int getArray(int[] arr) throws Exception{
		if(arr==null){
			throw new Exception("传递的数组不存在");
		}
		if(arr.length==0){
			throw new Exception("传递的数组没有任何元素");
		}
		int i = arr[arr.length-1];
		return i*2;
	}
}
