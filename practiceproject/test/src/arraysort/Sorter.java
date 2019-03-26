package arraysort;

import java.util.Comparator;

public interface Sorter {
	public <T extends Comparable<T>> void sort(T[] arr);
	public <T> void sort(T[] arr,Comparator<T> comp);
}
