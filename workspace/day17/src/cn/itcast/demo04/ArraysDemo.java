package cn.itcast.demo04;

import java.util.Arrays;

public class ArraysDemo {

	public static void main(String[] args) {
		function1();
	}
	public static void function2(){
		int[] arr = {8,1,9,4,7,6,0,3};
		System.out.println(Arrays.toString(arr));
	}
	public static void function1(){
		int[] arr = {8,1,9,4,7,6,0,3};
		Arrays.sort(arr);
		int index = Arrays.binarySearch(arr, 7);
		System.out.println(index);
		for (int i : arr) {
			System.out.println(i);
		}
	}
	public static void function(){
		int[] arr = {8,1,9,4,7,6,0,3};
		Arrays.sort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
