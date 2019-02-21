package bjava21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class StudentInfoTest {
	
	public static void main(String[] args) throws Exception {
		Comparator<Student> cmp = Collections.reverseOrder();
		Set<Student> stus = StudentInfoTool.getStudents(cmp);
		StudentInfoTool.write2File(stus);
	}
	
}
class StudentInfoTool{
	public static Set<Student> getStudents() throws Exception{
		return getStudents(null);
	}
	public static Set<Student> getStudents(Comparator<Student> cmp) throws Exception{
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		Set<Student> stus= null;
		if(cmp==null){
			stus = new TreeSet<Student>();
		}else{
			stus = new TreeSet<Student>(cmp);
		}
		while((line=bufr.readLine())!=null){
			if("over".equals(line)){
				break;
			}
			String[] info  = line.split(",");
			Student stu = new Student(info[0], Integer.parseInt(info[1]), Integer.parseInt(info[2]), Integer.parseInt(info[3]));
			stus.add(stu);
		}
		bufr.close();
		return stus;
	}
	public static void write2File(Set<Student> stus) throws IOException{
		BufferedWriter bufw = new BufferedWriter(new FileWriter("stuinfo.txt"));
		for (Student stu : stus) {
			bufw.write(stu.toString()+"\t");
			bufw.write(stu.getSum()+"");
			bufw.newLine();
			bufw.flush();
		}
		bufw.close();
	}
}
class Student implements Comparable<Student>{
	private String name;
	private int ma,cn,en;
	private int sum;
	
	@Override
	public int hashCode() {
		return name.hashCode()+sum*78;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Student)){
			throw new ClassCastException("类型不匹配");
		}
		Student s = (Student)obj;
		return this.name.equals(s.name) && this.sum==s.sum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMa() {
		return ma;
	}

	public void setMa(int ma) {
		this.ma = ma;
	}

	public int getCn() {
		return cn;
	}

	public void setCn(int cn) {
		this.cn = cn;
	}

	public int getEn() {
		return en;
	}

	public void setEn(int en) {
		this.en = en;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public Student(String name, int ma, int cn, int en) {
		super();
		this.name = name;
		this.ma = ma;
		this.cn = cn;
		this.en = en;
		this.sum = ma+cn+en;
	}

	@Override
	public int compareTo(Student s) {
		int num = new Integer(this.sum).compareTo(new Integer(s.sum));
		if(num==0){
			return this.name.compareTo(s.name);
		}
		return num;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", ma=" + ma + ", cn=" + cn + ", en=" + en + "]";
	}

}