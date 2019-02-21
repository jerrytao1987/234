import java.util.Random;
import java.util.Scanner;
public class CallName{
	
	public static void main(String[] args){
		/*String[] names = {"张三","李四","王五","李蕾","韩梅梅","小名","老王","小华","约翰逊","爱丽丝"};
		for(int i=0;i<names.length;i++){
			System.out.println(names[i]);
		}
		System.out.println("=============================");
		Random ran = new Random();
		int index = ran.nextInt(names.length);
		System.out.println(names[index]);*/
		String[] names = new String[3];
		addStudentName(names);
		printStudentName(names);
		String name = randomStudentName(names);
		System.out.println("被点到的名字是："+name);
	}
	public static String randomStudentName(String[] students){
		Random ran = new Random();
		int index = ran.nextInt(3);
		return students[index];
	}
	public static void printStudentName(String[] students){
		for(String element:students){
			System.out.println(element);
		}
	}
	public static void addStudentName(String[] students){
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<students.length;i++){
			System.out.println("第"+(i+1)+"个学生姓名:");
			students[i]=sc.next();
		}
	}
}