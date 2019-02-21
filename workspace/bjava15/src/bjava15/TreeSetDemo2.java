package bjava15;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetDemo2 {
	
	public static void main(String[] args) {
		TreeSet<Student> ts = new TreeSet<Student>(new MyCompare());
		ts.add(new Student("lisi02", 22));
		ts.add(new Student("lisi007", 20));
		ts.add(new Student("lisi009", 19));
		ts.add(new Student("lisi008", 19));
		ts.add(new Student("lisi007", 29));
		for (Student student : ts) {
			System.out.println(student);
		}
	}
}
class Student implements Comparable {
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
	
}
class MyCompare implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Student s1 = (Student) o1;
		Student s2 = (Student) o2;
		int num = s1.getName().compareTo(s2.getName());
		if(num==0){
			/*if(s1.getAge()>s2.getAge())
				return 1;
			if(s1.getAge()==s2.getAge())
				return 0;
			return -1;*/
			return new Integer(s1.getAge()).compareTo(s2.getAge());
		}
		return num;
	}
	
}