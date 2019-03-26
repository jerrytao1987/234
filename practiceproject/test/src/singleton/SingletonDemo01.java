package singleton;
/**
 * 饿汉模式
 * @author dengting
 *
 */
public class SingletonDemo01 {
	private SingletonDemo01(){};
	private static SingletonDemo01 sd=new SingletonDemo01();
	public SingletonDemo01 getInstance(){
		return sd;
	}
}
