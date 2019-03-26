package test;

import java.io.File;
import java.io.IOException;
import java.time.Clock;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestNewFunction {
	public static void main(String[] args) throws IOException {
		//jdk1.8新特性练习
		BeanFactory<UserInfo> bf = ()->new UserInfo(1l,"abc");
		UserInfo userInfo = bf.get();
		System.out.println(userInfo);
		
		Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
		Integer converted = converter.convert("123");
		System.out.println(converted);    // 123
		
		Converter<String, Integer> converter1 = Integer::valueOf;
		Integer converted1 = converter1.convert("123");
		System.out.println(converted1);   // 123
		//接口方法参数要和引用的一个对象的方法参数一致
		Converter<String, Integer> converter2 = new Person()::paseStringToInt;
		Integer converted2 = converter2.convert("456");
		System.out.println(converted2);    // "J"
		
		Map<Integer, String> map = new HashMap<>();
		for (int i = 0; i < 10; i++) {
		    map.putIfAbsent(i, "val" + i);
		}
		map.forEach((id,val)->System.out.println(val));
		
		Integer a = new Integer(3);
        Integer b = 3;                  // 将3自动装箱成Integer类型
        int c = 3;
        System.out.println(a == b);     // false 两个引用没有引用同一对象
        System.out.println(a == c);
        
        char d='0';
        System.out.println(d+0);
        
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s1.intern());
        
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime minusDays = now.minusDays(1);
        System.out.println(minusDays);
        System.out.println(now.getYear());
        System.out.println(now.getMonth());
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getDayOfWeek());
        System.out.println(now.getHour());
        System.out.println(now.getMinute());
        System.out.println(now.getSecond());
        System.out.println(now.getMonthValue());
        System.out.println(now);
        //格式化日期jdk1.8
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = now.format(ofPattern);
        System.out.println(format);
        DateTimeFormatter ofPattern2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate now2 = LocalDate.now();
        String format2 = now2.format(ofPattern2);
        System.out.println(format2);
        //获得当前毫秒数
        System.out.println(System.currentTimeMillis());
        System.out.println(Clock.systemDefaultZone().millis());
        System.out.println(Calendar.getInstance().getTimeInMillis());
        //获取某月的最后天
        System.out.println(Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH));
        //打印昨天的这个时候
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        System.out.println(cal.getTime());
        
        /*LocalDateTime now = LocalDateTime.now();
        LocalDateTime minusDays = now.minusDays(1);
        System.out.println(minusDays);*/
        //需先开启断言,断言在软件开发中是一种常用的调试方式，很多开发语言中都支持这种机制
        //断言是一个包含布尔表达式的语句，在执行这个语句时假定该表达式为true；如果表达式的值为false，那么系统会报告一个AssertionError。
        //assert(c>5);
        //assert(c>5):"abc";
        File file = new File("d:/PowerEnterABC32.exe");
        boolean file2 = file.isFile();
        System.out.println(file2);
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getParent());
        File parentFile = file.getParentFile();
        File[] listFiles = parentFile.listFiles();
        /*String[] list = parentFile.list();
        for (String string : list) {
			System.out.println(string);
		}
        for (File file3 : listFiles) {
			System.out.println(file3.getName());
		}*/
	}
	
}

