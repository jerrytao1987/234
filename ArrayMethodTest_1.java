
public class ArrayMethodTest_1{
	public static void main (String[] args){
		int[] arr = {1,3,6,8,9};
		invertedSequence(arr);
	}
	public static void invertedSequence(int[] array){
		int temp=0;
		/*for(int i=0;i<array.length/2;i++){
			temp=array[i];
			array[i]=array[array.length-1-i];
			array[array.length-1-i]=temp;
			
		}*/
		for(int min=0,max=array.length-1;min<max;min++,max--){
			temp=array[min];
			array[min]=array[max];
			array[max]=temp;
		}
		for(int j = 0;j<array.length;j++){
			System.out.println(array[j]);
		}
	}
}