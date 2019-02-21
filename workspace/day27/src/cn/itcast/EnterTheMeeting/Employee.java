package cn.itcast.EnterTheMeeting;

import java.util.Random;

/**
 * 此类实现了员工入会场发彩票和记录前后门进入员工数
 * @author dengting
 *
 */
public class Employee implements Runnable {
	private int Count;
	private int front;
	private int back;
	private int num=1;
	/**
	 * 构造方法传递员工入场总人数int参数
	 * @param count
	 */
	public Employee(int count) {
		super();
		Count = count;
	}
	/**
	 * 实现接口Runnable的run方法，打印员工入场人数情况和各自入场的入口以及各自拿的彩票号码
	 */
	public void run() {
		while(true){
			synchronized (this) {
				if(num<Count+1){
					if("前门".equals(Thread.currentThread().getName())){
						front++;
					}
					if("后门".equals(Thread.currentThread().getName())){
						back++;
					}
					System.out.println("编号为："+num+" 的员工 从"+Thread.currentThread().getName()+"入场! 拿到的双色球彩票号码是:"+/*Lottery.getNumber()*/getNumber());
					num++;
				}else if(num==Count+1){
					System.out.println("从"+Thread.currentThread().getName()+"入场的员工总共:"+("前门".equals(Thread.currentThread().getName())?front:back));
					break;
				}
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}
	public static String getNumber(){
		int[] arr = new int[7];
		Random r = new Random();
		for(int i = 0;i<arr.length-1;i++){
			arr[i] = r.nextInt(33)+1;
			for(int j=0;j<i;j++){
				if(arr[j]==arr[i]){
					i--;
					break;
				}
			}
		}
		arr[arr.length-1]=r.nextInt(16)+1;
		String str = "[";
		for(int i=0;i<arr.length;i++){
			if(i==arr.length-1){
				str = str+arr[i]+"]";
			}else{
				str = str+arr[i]+",";
			}
		}
		return str;
		
	}

}
