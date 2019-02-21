package cn.itcast.demo1;

public class Net extends Maintainer {
	public Net(String name,String id){
		super(name,id);
	}
	@Override
	public void work() {
		System.out.println("员工号为 " + getId() + " 的 " + getName() + " Net员工，正在检查网络是否畅通");
	}

}
