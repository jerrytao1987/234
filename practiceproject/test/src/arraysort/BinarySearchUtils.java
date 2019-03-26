package arraysort;

import java.util.Comparator;

public class BinarySearchUtils {
	public static <T extends Comparable<T>> int binarySearch(T[] arr, T key) {
		return binarySearch(0, arr.length-1, arr, key);
	}
	/**
	 * 递归检索
	 * @param start
	 * @param end
	 * @param arr
	 * @param key
	 * @return
	 */
	public static <T extends Comparable<T>> int binarySearch(Integer start, Integer end, T[] arr, T key) {
		if (start <= end) {
			int center = start+(end-start)>>1;
			if (key.compareTo(arr[center]) > 0) {
				return binarySearch(center+1, end, arr, key);
			} else if (key.compareTo(arr[center]) < 0) {
				return binarySearch(start, center-1, arr, key);
			} else {
				return center;
			}
		}
		return -1;

	}
	/**
	 * 循环检索
	 * @param arr
	 * @param key
	 * @param comp
	 * @return
	 */
	public static <T> int binarySearch(T[] arr,T key,Comparator<T> comp){
		int start=0;
		int end=arr.length-1;
		int center=0;
		while(start<=end){
			center=start+(end-start)>>1;
			if(comp.compare(key, arr[center])>0){
				start=center+1;
			}else if(comp.compare(key, arr[center])<0){
				end=center-1;
			}else{
				return center;
			}
		}
		return -1;
		
	}
}
