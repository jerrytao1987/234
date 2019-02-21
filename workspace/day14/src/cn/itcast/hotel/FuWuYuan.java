package cn.itcast.hotel;

public class FuWuYuan extends Employee implements VIP {

	public FuWuYuan() {
		super();
	}

	public FuWuYuan(String name, String id) {
		super(name, id);
	}

	@Override
	public void services() {
		System.out.println("VIP服务，服务员在倒酒");
	}

	@Override
	public void work() {
		System.out.println("服务员在上菜");
	}

}
