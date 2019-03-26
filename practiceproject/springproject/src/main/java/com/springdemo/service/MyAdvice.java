package com.springdemo.service;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {
	public void before() {
		System.out.println("这是前置通知");
	}
	public void afterReturning() {
		System.out.println("这是后置通知（如果出现异常不会调用）");
	}
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("这是环绕通知前置部分");
		Object proceed = pjp.proceed();
		System.out.println("这是环绕通知后置部分");
		return proceed;
	}
	public void afterException() {
		System.out.println("这是异常通知");
	}
	public void after() {
		System.out.println("这是后置通知（如果出现异常也会调用）");
	}
}
