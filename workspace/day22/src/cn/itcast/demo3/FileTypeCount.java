package cn.itcast.demo3;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FileTypeCount {

	public static void main(String[] args) {
//		File file = new File("D:\\develop\\eclipse-java-mars-2-win32\\eclipse");
		File file = new File("D:\\demo");
		Map<String, Integer> map = new HashMap<String,Integer>();
		fileTypeCount(file,map);
		Set<String> typeSet = map.keySet();
		for (String Name : typeSet) {
			System.out.println(Name+"的类型的文件有"+map.get(Name)+"个");
		}
	}
	public static void fileTypeCount(File file,Map<String, Integer> map){
		File[] fileArr = file.listFiles();
		for (File file2 : fileArr) {
			if(file2.isDirectory()){
				fileTypeCount(file2,map);
			}else{
				int index=-1;
				if((index = file2.getName().lastIndexOf("."))!=-1){
					String typeName = file2.getName().substring(index+1);
					if(map.containsKey(typeName.toLowerCase())){
						map.put(typeName.toLowerCase(), map.get(typeName.toLowerCase())+1);
					}else{
						map.put(typeName.toLowerCase(), 1);
					}
					
				}else{
					if(map.containsKey("无后缀名")){
						map.put("无后缀名", map.get("无后缀名")+1);
					}else{
						map.put("无后缀名", 1);
					}
				}
			}
		}
	}
}
