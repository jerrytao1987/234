package cn.itcast.d_springaop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {

	//前置通知
		//|-目标方法运行之前调用
	//后置通知(如果出现异常将不会调用)
		//|-目标方法运行之后调用
	//环绕通知
		//|-目标方法之前和之后都调用
	//异常拦截通知
		//|-如果出现异常，就会调用
	//后置通知(无论是否出现异常都会调用)
		//|-目标方法运行之后调用
	
	public void before(){
		System.out.println("这是前置通知！！");
	}
	public void afterReturning(){
		System.out.println("这是后置通知(如果出现异常不会调用)！！");
	}
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("这是环绕通知(之前部分）！！");
		Object proceed = pjp.proceed();//调用目标方法
		System.out.println("这是环绕通知(之后部分）！！");
		return proceed;
	}
	public void afterException(){
		System.out.println("这是异常拦截通知！！");
	}
	public void after(){
		System.out.println("后置通知(无论是否出现异常都会调用)");
	}
}
