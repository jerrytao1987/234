package cn.itcast.hotel;

public class ChuShi extends Employee implements VIP {

	public ChuShi() {
		super();
	}

	public ChuShi(String name, String id) {
		super(name, id);
	}

	@Override
	public void services() {
		System.out.println("VIP服务，厨师要加菜");
	}

	@Override
	public void work() {
		System.out.println("厨师在炒菜");
	}

}
