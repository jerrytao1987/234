package cn.itcast.demo1;

public abstract class Developer extends Employee {
	public Developer(String name,String id){
		super(name,id);
	}
	public abstract void work();
}
