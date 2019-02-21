package cn.itcast.demo2;

import cn.itcast.demo.Zi;

public class Test {
	public static void main(String[] args) {
/*		Outer.Inner i = new Outer().new Inner();
		i.inner();
		Outer o = new Outer();
		o.outer();*/
		Outer.Inner i = new Outer.Inner();
		i.inner();
		//Zi z= new Zi();
		
	}
}
