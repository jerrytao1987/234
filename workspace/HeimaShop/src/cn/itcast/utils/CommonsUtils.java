package cn.itcast.utils;

import java.util.UUID;

public class CommonsUtils {
	
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
