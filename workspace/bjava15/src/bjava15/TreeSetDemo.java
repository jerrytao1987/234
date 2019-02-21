package bjava15;

import java.util.TreeSet;
/**
 *排序时，当主要条件相同时，一定判断一下次要条件
 * @author dengting
 *
 */
public class TreeSetDemo {
	public static void main(String[] args) {
		TreeSet<Student> ts = new TreeSet<Student>();
		ts.add(new Student("lisi02", 22));
		ts.add(new Student("lisi007", 20));
		ts.add(new Student("lisi009", 19));
		ts.add(new Student("lisi008", 19));
		for (Student student : ts) {
			System.out.println(student);
		}
	}
}
/*class Student implements Comparable {
	private String name;
	private int age;
	public Student(String name, int age) {
		super();
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
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	@Override
	public int compareTo(Object obj) {
		//return 1;
		if(!(obj instanceof Student)){
			throw new RuntimeException("不是学生对象");
		}
		Student s = (Student) obj;
		System.out.println(this.name+"..."+s.name);
		if(this.age>s.age){
			return 1;
		}
		if(this.age==s.age){
			return this.name.compareTo(s.name);
		}
		return -1;
	}
	
}*/
