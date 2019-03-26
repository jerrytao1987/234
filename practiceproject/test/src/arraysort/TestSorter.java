package arraysort;

import java.util.Arrays;
import java.util.Comparator;

public class TestSorter {
	public static void main(String[] args) {
		Integer[] arr={12,2,55,33,22,44};
		BubbleSorter bs = new BubbleSorter();
		//bs.sort(arr);
		bs.sort(arr, new MyCompator());
		System.out.println(Arrays.toString(arr));
		String[] arr1 = {"abc","123","234"};
		bs.sort(arr1);
		System.out.println(Arrays.toString(arr1));
	}
}
class MyCompator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return o1-o2;
	}

	
}
