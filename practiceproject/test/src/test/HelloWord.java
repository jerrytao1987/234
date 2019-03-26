package test;

import java.io.File;
import java.time.Clock;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class HelloWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("hello world!");
		String lineSeparator = System.lineSeparator();
		System.out.print(lineSeparator);
		System.out.print("hello");
		System.out.print(File.pathSeparator);
		System.out.println(File.separator);
		//1.7新特性
		int one_million = 1_000_000;
		System.out.println(one_million);
		int binary = 0b1001_1001;
		System.out.println(binary);
		System.out.println(Integer.toBinaryString(binary));
		
		Child child = new Child();
		System.out.println(child.calculate(4));
		System.out.println(child.sqrt(4));
		
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

		/*Collections.sort(names, new Comparator<String>() {
		    @Override
		    public int compare(String a, String b) {
		        return b.compareTo(a);
		    }
		});*/
		/*Collections.sort(names, (String a, String b) -> {
		    return b.compareTo(a);
		});*/
		Collections.sort(names, (a, b) -> b.compareTo(a));
		System.out.println(names);
		
		Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
		Integer converted = converter.convert("123");
		System.out.println(converted);    // 123
		
		Converter<String, Integer> converter1 = Integer::valueOf;
		Integer converted1 = converter.convert("123");
		System.out.println(converted1);   // 123
		
		UserInfoFactory<UserInfo> uf = UserInfo::new;
		UserInfo userInfo = uf.create(1l, "hello");
		System.out.println(userInfo);
		
		Clock clock = Clock.systemDefaultZone();
		long millis = clock.millis();
		Instant instant = clock.instant();
		Date legacyDate = Date.from(instant);   // legacy java.util.Date
		System.out.println(millis);
		
	}

}
