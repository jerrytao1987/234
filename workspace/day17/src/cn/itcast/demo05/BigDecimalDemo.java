package cn.itcast.demo05;

import java.math.BigDecimal;

public class BigDecimalDemo {

	public static void main(String[] args) {
		/*System.out.println(0.09 + 0.01);
	    System.out.println(1.0 - 0.32);
	    System.out.println(1.015 * 100);
	    System.out.println(1.301 / 100);
*/
		function1();
	}
	public static void function1(){
		BigDecimal b6 = new BigDecimal("1.301");
		BigDecimal b7 = new BigDecimal("100");
		BigDecimal bigDiv = b6.divide(b7,2,BigDecimal.ROUND_UP);
		BigDecimal bigDiv1 = b6.divide(b7,2,BigDecimal.ROUND_DOWN);
		BigDecimal bigDiv2 = b6.divide(b7,2,BigDecimal.ROUND_HALF_UP);
		BigDecimal bigDiv3 = b6.divide(b7,2,BigDecimal.ROUND_HALF_DOWN);
		System.out.println(bigDiv);
		System.out.println(bigDiv1);
		System.out.println(bigDiv2);
		System.out.println(bigDiv3);
	}
	public static void function(){
		BigDecimal b = new BigDecimal("0.09");
		BigDecimal b1 = new BigDecimal("0.01");
		BigDecimal bigAdd = b.add(b1);
		System.out.println(bigAdd);
		
		BigDecimal b2 = new BigDecimal("1.0");
		BigDecimal b3 = new BigDecimal("0.32");
		BigDecimal bigSub = b2.subtract(b3);
		System.out.println(bigSub);
		
		BigDecimal b4 = new BigDecimal("1.015");
		BigDecimal b5 = new BigDecimal("0.01");
		BigDecimal bigMul = b4.multiply(b5);
		System.out.println(bigMul);
		
		BigDecimal b6 = new BigDecimal("1.301");
		BigDecimal b7 = new BigDecimal("100");
		BigDecimal bigDiv = b6.divide(b7);
		System.out.println(bigDiv);
	}
}
