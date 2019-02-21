package cn.itcast.demo;

public class StaticClass {
	private static ThreadLocal<TestClass> t = new ThreadLocal<>();
	public static TestClass getTestClass(){
		if(t.get()==null){
			t.set(new TestClass("jame"));
		}
		return t.get();
	}
}
