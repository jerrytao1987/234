package cn.itcast.demo01;

public class Person {
	private String name;
	private int age;
	public String toString(){
		return name+age;
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if(obj == this)
			return true;
		if (obj instanceof Person) {
			Person p = (Person) obj;
			return this.age == p.age;
		}
		return false;
	}

	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
