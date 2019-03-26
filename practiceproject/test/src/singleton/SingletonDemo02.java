package singleton;
/**
 * 懒汉式单例
 * @author dengting
 *
 */
public class SingletonDemo02 {
	private SingletonDemo02(){};
	private static SingletonDemo02 sd=null;
	public static synchronized SingletonDemo02 getInstance(){
		if(sd==null){
			return new SingletonDemo02();
		}else{
			return sd;
		}
	}
}
