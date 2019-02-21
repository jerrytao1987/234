package cn.itcast.demo05;

import java.math.BigInteger;

public class BigIntegerDemo {

	public static void main(String[] args) {
		function4();
	}
	public static void function4(){
		BigInteger bi = new BigInteger("11111111111111111111111111111111111");
		BigInteger bi1 = new BigInteger("1111111111111111111111111111111111");
		BigInteger bigDiv = bi.divide(bi1);
		System.out.println(bigDiv);
	}
	public static void function3(){
		BigInteger bi = new BigInteger("11111111111111111111111111111111111");
		BigInteger bi1 = new BigInteger("11111111111111111111111111111111111");
		BigInteger bigMul = bi.multiply(bi1);
		System.out.println(bigMul);
	}
	public static void function2(){
		BigInteger bi = new BigInteger("11111111111111111111111111111111111");
		BigInteger bi1 = new BigInteger("11111111111111111111111111111111111");
		BigInteger bigSub = bi.subtract(bi1);
		System.out.println(bigSub);
	}
	public static void function1(){
		BigInteger bi = new BigInteger("11111111111111111111111111111111111");
		BigInteger bi1 = new BigInteger("11111111111111111111111111111111111");
		BigInteger bigAdd = bi.add(bi1);
		System.out.println(bigAdd);
	}
	public static void function(){
		BigInteger bi = new BigInteger("11111111111111111111111111111111111");
		System.out.println(bi);
	}

}
