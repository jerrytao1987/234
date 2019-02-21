package cn.itcast.hotel;

import java.util.ArrayList;
import java.util.Iterator;

public class GenericTest {

	public static void main(String[] args) {
		ArrayList<ChuShi> arr1 = new ArrayList<ChuShi>();
		ArrayList<FuWuYuan> arr2 = new ArrayList<FuWuYuan>();
		ArrayList<JingLi> arr3 = new ArrayList<JingLi>();
		arr1.add(new ChuShi("李四","c001"));
		arr1.add(new ChuShi("张三","c002"));
		arr2.add(new FuWuYuan("翠花","f001"));
		arr2.add(new FuWuYuan("酸菜","f002"));
		arr3.add(new JingLi("小名","j001",1341234));
		arr3.add(new JingLi("小强","j002",1234324));
		iterator(arr1);
		iterator(arr2);
		iterator(arr3);
	}
	public static void iterator(ArrayList<? extends Employee > arr){
		Iterator<? extends Employee> it = arr.iterator();
		while(it.hasNext()){
			it.next().work();
		}
	}
}
