import java.util.ArrayList; 
import java.util.Random;
public class CallName_1{
	public static void main(String[] args){
		ArrayList<Student> array = new ArrayList<Student>();
		add(array);
		printArrayList(array);
		randomStudent(array);
	}
	public static void randomStudent(ArrayList<Student> array){
		Random ran = new Random();
		int number = ran.nextInt(array.size());
		Student stu = array.get(number);
		System.out.println(stu.name);
	}
	public static void printArrayList(ArrayList<Student> array){
		for(int i = 0; i<array.size();i++){
			Student stu = array.get(i);
			System.out.println(stu.name+" "+stu.age);
		}
	}
	public static void add(ArrayList<Student> array){
		Student stu1 = new Student();
		Student stu2 = new Student();
		Student stu3 = new Student();
		Student stu4 = new Student();
		Student stu5 = new Student();
		
		stu1.name = "张三1";
		stu1.age = 201;
		
		stu2.name = "张三2";
		stu2.age = 202;
		
		stu3.name = "张三3";
		stu3.age = 203;
		
		stu4.name = "张三4";
		stu4.age = 204;
		
		stu5.name = "张三5";
		stu5.age = 205;
		
		array.add(stu1);
		array.add(stu2);
		array.add(stu3);
		array.add(stu4);
		array.add(stu5);
		
	}
}