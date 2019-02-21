package cn.itcast.annotation;

public class MyAnnoTest {
	@SuppressWarnings("all")
	@MyAnno(name="zhangsan")
//	@MyAnno("xxx")
//	@MyAnno(value={"aa","bb"})
//	@MyAnno({"aa","bb"})
	public void show(String str){
		System.out.println("show running....");
	}
}
