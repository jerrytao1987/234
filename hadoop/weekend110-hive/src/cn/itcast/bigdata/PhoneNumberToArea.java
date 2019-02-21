package cn.itcast.bigdata;

import java.util.HashMap;

import org.apache.hadoop.hive.ql.exec.UDF;

public class PhoneNumberToArea extends UDF {
	
	private static HashMap<String, String> areaMap = new HashMap<>();
	static{
		areaMap.put("1388", "beijing");
		areaMap.put("1399", "tianjin");
		areaMap.put("1366", "nanjing");
	}
	//一定要Public修饰才能被hive调用
	public String evaluate(String phonenumber) {
		String result = areaMap.get(phonenumber.substring(0, 4))==null?(phonenumber+"   huoxing"):(phonenumber+"   "+areaMap.get(phonenumber.substring(0, 4)));
		return result;
	}
}
