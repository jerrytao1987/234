package arraysort;

import java.util.Arrays;

public class TestBinarySearch {
	public static void main(String[] args) {
		Integer[] arr = {43,22,11,44,23};
		System.out.println(Arrays.toString(arr));
		BubbleSorter bs = new BubbleSorter();
		bs.sort(arr);
		System.out.println(Arrays.toString(arr));
		//int index = BinarySearchUtils.binarySearch(arr, 22);
		int index = BinarySearchUtils.binarySearch(arr, 23, new MyCompator());
		System.out.println(index);
	}
}
