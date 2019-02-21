
public class ArrayMethodTest_2{
	public static void main(String[] args){
		int[] arr = {3,8,4,1,2,5};
		//selectSort(arr);
		bubbleSort(arr);
		int index = binarySearch(arr,7);
		System.out.println(index);
		//printArray(arr);
	}
	public static int binarySearch(int[] arr,int number){
		int min=0,mid=0,max=arr.length-1;
		while(min<=max){
			mid =(min+max)/2;
			if(number>arr[mid]){
				min = mid+1;
			}else if(number<arr[mid]){
				max = mid-1;
			}else{
				return mid;
			}
		}
		return -1;
	}
	public static void bubbleSort(int[] arr){
		int temp = 0;
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-1-i;j++){
				if(arr[j]>arr[j+1]){
					temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
	public static void selectSort(int[] arr){
		int temp = 0;
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]>arr[j]){
					temp = arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}
	public static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
}