package cn.itcast.annotation;

import java.util.ArrayList;
import java.util.List;
@SuppressWarnings({ "rawtypes", "unused" })
public class AnnoDemo {

	public static void main(String[] args) {
		
		List list = new ArrayList();
		show();
	}
	@Override
	public String toString(){
		return super.toString();
	}
	@Deprecated
	public static void show(){
		
	}
	
	public static void show(String s){
		
	}

}
