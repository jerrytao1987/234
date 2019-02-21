package cn.itcast.demo4;

import java.util.concurrent.Callable;

public class ThreadPoolCallable implements Callable<String> {

	@Override
	public String call() {
		return "abc";
	}

}
