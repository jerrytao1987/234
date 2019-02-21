package cn.itcast.case1;

import org.junit.Test;

public class TestDemo {
	
	@Test
	public void test1(){
		System.out.println("test1 running...");
	}
	@MyTest
	public void test2(){
		System.out.println("test2 running...");
	}
	@MyTest
	public void test3(){
		System.out.println("test3 running...");
	}
}
