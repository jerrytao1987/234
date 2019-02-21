package cn.itcast.hotel;

public class JingLi extends Employee {
	private double money;
	public JingLi() {
		super();
	}
	public JingLi(String name, String id,double money) {
		super(name, id);
		this.money=money;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	@Override
	public void work() {
		System.out.println("经理在管理员工");
	}

}
