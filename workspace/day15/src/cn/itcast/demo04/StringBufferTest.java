package cn.itcast.demo04;

public class StringBufferTest {

	public static void main(String[] args) {
		int[] arr =  {34,12,89,68};
		System.out.println(toString(arr));//toString(arr);
	}
	public static String toString(int[] arr){
		StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		for(int i=0;i<arr.length;i++){
			if(i==arr.length-1){
				buffer.append(arr[i]).append("]");
			}else{
				buffer.append(arr[i]).append(",");
			}
		}
		//System.out.println(buffer);
		return buffer.toString();
	}

}
