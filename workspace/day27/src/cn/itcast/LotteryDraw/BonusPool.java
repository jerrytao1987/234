package cn.itcast.LotteryDraw;

import java.util.ArrayList;
import java.util.Random;
/**
 * 奖金池类实现了抽奖
 * @author dengting
 *
 */
public class BonusPool implements Runnable {
	private ArrayList<Integer> arrayList;
	private int index;
	/**
	 * 构造方法需要传递一个ArrayList<Integer>奖金池数组
	 * @param arrayList
	 */
	public BonusPool(ArrayList<Integer> arrayList) {
		super();
		this.arrayList = arrayList;
	}
	/**
	 * 实现了Runnable接口重写run方法，实现抽奖方法
	 */
	public void run() {
		while(true){
			synchronized (this) {
				if(arrayList.size()>0){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Random r = new Random();
					index = r.nextInt(arrayList.size());
					System.out.println(Thread.currentThread().getName()+" 又产生了一个 "+arrayList.get(index)+" 元大奖");
					arrayList.remove(index);
				}else{
					break;
				}
			}
		}
	}

}
