package test;

public class testSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {11,2,33,44,22,55,23};
		System.out.println(System.currentTimeMillis());
		//selectSort(arr);
		bubbleSort(arr);
		System.out.println(System.currentTimeMillis());
		printArray(arr);
		int i = halfSearch(arr,22);
		System.out.println(i);
	}

	private static int halfSearch(int[] arr, int i) {
		int start=0;
		int end=arr.length-1;
		int mid=0;
		while(start<=end){
			mid=(start+end)/2;
			if(arr[mid]==i){
				return mid;
			}else if(arr[mid]<i){
				start=mid;
			}else{
				end=mid;
			}
			
		}
		return -1;
	}

	private static void bubbleSort(int[] arr) {
		int temp=0;
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length-1-i;j++){
				if(arr[j]>arr[j+1]){
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}

	private static void printArray(int[] arr) {
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}

	private static void selectSort(int[] arr) {
		int temp=0;
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]>arr[j]){
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}

}
