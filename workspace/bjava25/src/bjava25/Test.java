package bjava25;

public class Test {
	public static void main(String[] args) {
		int[] arr = {12,2,22,10,33,5,7};
		//selectSort(arr);
		//bubbleSort(arr);
		reverse(arr);
		printArr(arr);
		/*int i = findValue(arr,11);
		int halfFind = halfFind(arr,2);
		System.out.println(halfFind);*/
	}
	public static void printArr(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	public static void selectSort(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i]>arr[j]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	public static void bubbleSort(int[] arr){
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-1-i; j++) {
				if(arr[j]>arr[j+1]){
					int temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
	public static int findValue(int[] arr,int val){
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==val){
				return i;
			}
		}
		return -1;
	}
	public static int halfFind(int[] arr,int val){
		int start = 0;
		int end = arr.length-1;
		while(start<=end){
			int mid = (start+end)/2;
			if(arr[mid]>val){
				end = mid-1;
			}else if(arr[mid]<val){
				start = mid+1;
			}else{
				return mid;
			}
		}
		return -1;
	}
	public static void reverse(int[] arr){
		for (int i = 0; i < arr.length/2; i++) {
			int temp = arr[i];
			arr[i]=arr[arr.length-1-i];
			arr[arr.length-1-i]=temp;
		}
	}
}
