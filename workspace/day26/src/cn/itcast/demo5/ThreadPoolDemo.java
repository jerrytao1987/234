package cn.itcast.demo5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolDemo {

	public static void main(String[] args) throws Exception {
		ExecutorService es = Executors.newFixedThreadPool(2);
		Future<Integer> f = es.submit(new GetSumCallable(100));
		System.out.println(f.get());
		Future<Integer> f1 = es.submit(new GetSumCallable(200));
		System.out.println(f1.get());
		es.shutdown();
	}

}
