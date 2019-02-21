package cn.itcast.demo2;

public class Outer {
	public int i = 1;
	public static class Inner{
		public int i =2;
		public void inner(){
			int i = 3;
			//System.out.println(Outer.this.i);
			System.out.println(i);
		}
	}
	public class Inner1{
		
	}
	public void outer(){
		abstract class Inner2{//只能abstract和finnal修饰
			public void inner2(){
				System.out.println("局部内部类");
			}
		}
		new Inner2(){}.inner2();
	}
	public void outer1(){
		class Inner3{
			
		}
	}
}
