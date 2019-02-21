package cn.itcast.demo2;

public class Test {

	public static void main(String[] args) {
		Animal a1 = new Dog();
		Animal a2 = new Cat();
		a1.eat();
		a2.eat();
		boolean b = a1 instanceof Cat;
		System.out.println(b);
		if(a1 instanceof Dog){
			Dog d = (Dog) a1;
			d.lookHome();
		}
		if(a2 instanceof Cat){
			Cat c = (Cat) a2;
			c.catchMouse();
		}
	}

}
