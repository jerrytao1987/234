package arraysort;

import java.util.Comparator;

public class BubbleSorter implements Sorter {
	@Override
	public <T extends Comparable<T>> void sort(T[] arr) {
		Boolean swapped=true;
		
		for(int i=1,len = arr.length;i<len&&swapped;++i){
			swapped=false;
			for(int j=0;j<len-i;++j){
				if(arr[j].compareTo(arr[j+1])>0){
					T temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					swapped=true;
				}
			}
		}
		
	}

	@Override
	public <T> void sort(T[] arr, Comparator<T> comp) {
		boolean swapped = true;
		for(int i=1,len=arr.length;i<len&&swapped;++i){
			swapped=false;
			for(int j=0;j<len-i;++j){
				if(comp.compare(arr[j], arr[j+1])>0){
					T temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swapped=true;
				}
			}
		}
	}


}
