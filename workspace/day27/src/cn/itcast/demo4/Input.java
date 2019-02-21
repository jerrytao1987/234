package cn.itcast.demo4;

public class Input implements Runnable {
	private Resource r;

	public Input(Resource r) {
		this.r = r;
	}

	public void run() {
		int i = 0;
		while (true) {
			synchronized (r) {
				if (r.flag) {
					try {
						r.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (i % 2 == 0) {
					r.name = "zhangsan";
					r.sex = "nan";
				} else {
					r.name = "李四";
					r.sex = "女";
				}
				r.flag = true;
				r.notify();

			}
			i++;
		}
	}

}
