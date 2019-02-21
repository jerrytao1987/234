package cn.itcast.demo1;

public abstract class Maintainer extends Employee {
	public Maintainer(String name,String id){
		super(name,id);
	}
	@Override
	public abstract void work();

}
