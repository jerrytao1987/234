package cn.itcast.demo4;

public class Output implements Runnable {
	private Resource r;

	public Output(Resource r) {
		this.r = r;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (r) {
				if (!r.flag) {
					try {
						r.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(r.name + "..." + r.sex);
				r.flag = false;
				r.notify();
			}
		}
	}

}
