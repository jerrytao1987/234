package cn.e3mall.freemarker;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreeMarkerTest {
	
	@Test
	public void testFreeMarker() throws Exception {
		//1、创建一个模板文件
		//2、创建一个Configuration对象
		Configuration configuration = new Configuration(Configuration.getVersion());
		//3、设置模板文件保存的目录
		configuration.setDirectoryForTemplateLoading(new File("D:/234/template/e3-parent/e3-item-web/src/main/webapp/WEB-INF/ftl"));
		//4、模板文件的编码格式，一般是utf-8
		configuration.setDefaultEncoding("UTF-8");
		//5、加载一个模板文件，创建一个模板对象
		//Template template = configuration.getTemplate("hello.ftl");
		Template template = configuration.getTemplate("student.ftl");
		//6、创建一个数据集，可以是pojo也可以是map,推荐使用map
		Map data = new HashMap<>();
		data.put("hello", "hello freemarker!");
		//创建一个pojo对象
		Student student  = new Student(1, "小明", 18, "较场口");
		data.put("student", student);
		//创建一个list
		List<Student> stuList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			stuList.add(new Student(i+1, "小明"+(i+1), 18+i, "较场口"+(i+1)));
		}
		data.put("stuList", stuList);
		//添加日期类型
		data.put("date", new Date());
		//添加null值
		//data.put("val", null);
		data.put("val", "123");
		//7、创建一个Writer对象，指定输出文件的路径及文件名
		//Writer out = new FileWriter(new File("D:/temp/JavaEE32/freemarker/hello.txt"));
		Writer out = new FileWriter(new File("D:/temp/JavaEE32/freemarker/student.html"));
		//8、生成静态页面
		template.process(data, out);
		//9、关闭流
		out.close();
	}
}
