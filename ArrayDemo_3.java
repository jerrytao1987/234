public class ArrayDemo_3{
	
	public static void main(String[] args){
		int[] arr = {5,1,12,4,6,8,0,3};
		int max = arr[0];
		for(int i = 1;i<arr.length;i++){
			
			if(max<arr[i]){
				max = arr[i];
			}
		}
		System.out.println(max);
	}
}