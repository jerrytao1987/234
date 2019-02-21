package cn.itcast.demo4;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolDemo1 {

	public static void main(String[] args) throws Exception {
		ExecutorService es = Executors.newFixedThreadPool(2);
		Future<String> f = es.submit(new ThreadPoolCallable());
		String s = f.get();
		System.out.println(s);
	}

}
