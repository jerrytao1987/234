import java.util.Random;
import java.util.Scanner;

public class GuessNumber{
	public static void main(String[] args){
		//1.����Random����
		Random r = new Random();
		//2.����һ��1-100�������
		int i = r.nextInt(100)+1;
		System.out.println("����������ɣ�");
		//3.ѭ������һ����
		int sum = 0,j;
		Scanner sc = new Scanner(System.in);
		do{
			System.out.print("������1-100�����֣�");
			if(sc.hasNextInt()){		
				j = sc.nextInt();
				sum++;
				//4.�������������������ıȽ��������ʾ����
				if(j>i){
					System.out.println("sorry�����´���!");
				}else if(j<i){
					System.out.println("sorry������С��!");
				}else{
					System.out.println("��ϲ�������ˣ����ܹ�����"+sum+"�Σ���̫�����ˣ�");		
				}
			}else{
				System.out.println("������Ĳ������֣�����������!");
				j=101;
				//sc = new Scanner(System.in);
				sc.next();
			}
		}while(j!=i);
	}
}