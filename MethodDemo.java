import java.util.Scanner;
public class MethodDemo{
	public static void main(String[] args){
		//printRect(getNumber());
		System.out.println(getAvg(1,3,5,6));
	}
	public static double getAvg(double...args){
		double sum=0.0;
		for(double element:args){
			sum +=element;
		}
		return sum/args.length;
	}
	/*
		��ȡ��������
	*/
	public static int getNumber(){
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	/*
		����һ��������������ӡ����
	*/
	public static void printRect(int n){
		for(int i =0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}