import java.util.Scanner;
public class ScannerDemo1{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		double sum = 0;
		int m = 0;
		while(sc.hasNextDouble()){
			double x = sc.nextDouble();
			m +=1;
			sum +=x;
		}
		System.out.println(m+"个数的和为"+sum);
		System.out.println(m+"个数的平均数为"+sum/m);
	}
}