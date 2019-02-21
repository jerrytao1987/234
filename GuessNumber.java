import java.util.Random;
import java.util.Scanner;

public class GuessNumber{
	public static void main(String[] args){
		//1.创建Random对象
		Random r = new Random();
		//2.生成一个1-100的随机数
		int i = r.nextInt(100)+1;
		System.out.println("随机数已生成！");
		//3.循环输入一个数
		int sum = 0,j;
		Scanner sc = new Scanner(System.in);
		do{
			System.out.print("请输入1-100的数字：");
			if(sc.hasNextInt()){		
				j = sc.nextInt();
				sum++;
				//4.根据输入的数与随机数的比较来输出提示内容
				if(j>i){
					System.out.println("sorry，您猜大了!");
				}else if(j<i){
					System.out.println("sorry，您猜小了!");
				}else{
					System.out.println("恭喜您猜中了！您总共猜了"+sum+"次，您太厉害了！");		
				}
			}else{
				System.out.println("您输入的不是数字，请重新输入!");
				j=101;
				//sc = new Scanner(System.in);
				sc.next();
			}
		}while(j!=i);
	}
}