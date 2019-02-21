public class ArrayDemo_2{
	
	public	static void main(String[] args){
	
		int[] arr = {1,3,5,6,2,7,3,8};
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		for(Integer element:arr){
			System.out.println(element);
		}
	}
}