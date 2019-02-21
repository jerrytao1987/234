package cn.itcast.demo2;
/**
 * JDK1.5后新特性,静态导入
 * @author dengting
 *
 */
import static java.lang.System.out;
import static java.util.Arrays.sort;
public class StaticImportDemo {

	public static void main(String[] args) {
		out.println("hello");
		int[] arr = {1,3,7,3,4,9};
		sort(arr);
		for (int i : arr) {
			
			out.println(i);
		}
	}
	
}
