package cn.itcast.EnterTheMeeting;

import java.util.Random;
/**
 * 此类实现了发彩票功能
 * @author dengting
 *
 */
public class Lottery {
	/**
	 * 此方法为静态方法，返回值为String,实现了发彩票功能
	 * @return
	 */
	public static String getNumber(){
		int[] arr = new int[7];
		Random r = new Random();
		for(int i = 0;i<arr.length-1;i++){
			arr[i] = r.nextInt(33)+1;
			for(int j=0;j<i;j++){
				if(arr[j]==arr[i]){
					i--;
					break;
				}
			}
		}
		arr[arr.length-1]=r.nextInt(16)+1;
		String str = "[";
		for(int i=0;i<arr.length;i++){
			if(i==arr.length-1){
				str = str+arr[i]+"]";
			}else{
				str = str+arr[i]+",";
			}
		}
		return str;
		
	}
}
