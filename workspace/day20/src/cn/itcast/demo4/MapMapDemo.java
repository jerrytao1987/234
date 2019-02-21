package cn.itcast.demo4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapMapDemo {

	public static void main(String[] args) {
		HashMap<String, String> javase = new HashMap<String,String>();
		HashMap<String, String> javaee = new HashMap<String,String>();
		javase.put("001","张三");
		javase.put("002","李四");
		javaee.put("001","王五");
		javaee.put("002","赵六");
		HashMap<String, HashMap<String,String>> czbk =
				new HashMap<String, HashMap<String,String>>();
		czbk.put("java基础班", javase);
		czbk.put("java就业班", javaee);
		keySet(czbk);
		entrySet(czbk);
	}
	public static void keySet(HashMap<String, HashMap<String,String>> czbk){
		Set<String> classNameSe = czbk.keySet();
		Iterator<String> classNameIt = classNameSe.iterator();
		while(classNameIt.hasNext()){
			String classNameKey = classNameIt.next();
			System.out.print(classNameKey+"  ");
			HashMap<String, String> classMap = czbk.get(classNameKey);
			Set<String> studentNum = classMap.keySet();
			Iterator<String> studentIt = studentNum.iterator();
			while(studentIt.hasNext()){
				String numKey = studentIt.next();
				String nameValue = classMap.get(numKey);
				System.out.print(numKey+":"+nameValue+"  ");
			}
			System.out.println();
		}
	}
	public static void entrySet(HashMap<String, HashMap<String,String>> czbk){
		Set<Map.Entry<String, HashMap<String, String>>> classNameEntrySet = czbk.entrySet();
		Iterator<Map.Entry<String, HashMap<String, String>>> classNameIt =
				classNameEntrySet.iterator();
		while(classNameIt.hasNext()){
			Map.Entry<String, HashMap<String, String>> classNameEntry = classNameIt.next();
			String classNameKey = classNameEntry.getKey();
			System.out.print(classNameKey+"  ");
			HashMap<String, String> classMap = classNameEntry.getValue();
			Set<Map.Entry<String, String>> studentEntrySet = classMap.entrySet();
			Iterator<Map.Entry<String, String>> studentIt = studentEntrySet.iterator();
			while(studentIt.hasNext()){
				Map.Entry<String, String> studentEntry = studentIt.next();
				String numKey = studentEntry.getKey();
				String nameValue = studentEntry.getValue();
				System.out.print(numKey+":"+nameValue+"  ");
			}
			System.out.println();
		}
	}

}
