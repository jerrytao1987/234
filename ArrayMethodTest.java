
public class ArrayMethodTest{
	public static void main(String[] args){
		int[] arr = {4,5,7,8,9,5,4};
		printArray(arr);
		int[] arr1 = {4,2,7,8,9,3,4};
		printArray(arr1);
	}
	/*public static void printArray(int[] array){
		String str = "[";
		for(int i=0;i<array.length;i++){
			if(i!=array.length-1){
				str +=array[i]+",";
			}else{
				str +=array[i]+"]";
			}
		}
		System.out.println(str);
		
	}*/
	public static void printArray(int[] array){
		System.out.print("[");
		for(int i =0;i<array.length;i++){
			if(i==array.length-1){
				System.out.println(array[i]+"]");
			}else{
				System.out.print(array[i]+",");
			}
		}
	}
}