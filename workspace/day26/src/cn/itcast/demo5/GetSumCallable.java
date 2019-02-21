package cn.itcast.demo5;

import java.util.concurrent.Callable;

public class GetSumCallable implements Callable<Integer> {
	private int a;
	public GetSumCallable(int a) {
		this.a =a;
	}
	@Override
	public Integer call() {
		
		return a+a*(a-1)/2;
	}

}
