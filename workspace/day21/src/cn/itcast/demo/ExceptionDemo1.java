package cn.itcast.demo;

public class ExceptionDemo1 {

	public static void main(String[] args){
		int[] arr = null;
		try {
			int i = getArray(arr);
			System.out.println(i);
		} catch (NullPointerException e) {
			System.out.println(e);
		} catch (ArrayIndexOutOfBoundsException e){
			System.out.println(e);
		}
		System.out.println("game over!");
	}

	public static int getArray(int[] arr) throws NullPointerException,ArrayIndexOutOfBoundsException {
		if (arr == null) {
			throw new NullPointerException("数组不存在");
		}
		if (arr.length <= 3) {
			 throw new ArrayIndexOutOfBoundsException("数组没有3索引");
		}
		return arr[3] + 1;
	}
}
