package cn.itcast.LotteryDraw;

import java.util.ArrayList;

public class LotteryDraw {

	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(10);
		arrayList.add(5);
		arrayList.add(20);
		arrayList.add(50);
		arrayList.add(100);
		arrayList.add(200);
		arrayList.add(500);
		arrayList.add(800);
		arrayList.add(2);
		arrayList.add(80);
		arrayList.add(300);
		BonusPool bp = new BonusPool(arrayList);
		Thread t0 = new Thread(bp,"抽奖箱1");
		Thread t1 = new Thread(bp,"抽奖箱2");
		t0.start();
		t1.start();
	}

}
