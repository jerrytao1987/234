import java.util.Scanner;
public class Shopp{
	public static void main(String[] args){
		String[] brand = {"MacBookAir","ThinkpadT450"};
		double[] size = {13.3,15.6};
		double[] price = {9998.97,6789.56};
		int[] count = {0,0};
		int choose;
		while(true){
			choose = chooseFunction();
			switch(choose){
				case 1:
				printStore(brand,size,price,count);
				break;
				case 2:
				update(brand,count);
				break;
				case 3:
				exit();
				return;
				default:
				System.out.println("----------------------------------");
				System.out.println("����ѡ��������������ȷ�Ĺ������!");			
			}
		}
	}
	public static void exit(){
		System.out.println("----------------�˳�---------------");
		System.out.println("�����˳�ϵͳ");
	}
	public static void update(String[] brand,int[] count){
		System.out.println("------------�޸���Ʒ�������-----------");
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<brand.length; i++){
			System.out.println("������"+ brand[i] +"��Ʒ�����");
			count[i]= sc.nextInt();
		}
	}
	public static void printStore(String[] brand,double[] size,double[] price,int[] count){
		System.out.println("---------------------------�鿴����嵥--------------------------");
		System.out.println("Ʒ���ͺ�		�ߴ�	�۸�	�����");
		int totalCount = 0;
		int totalMoney = 0;
		for(int i=0;i<brand.length;i++){
			System.out.println(brand[i]+"              "+size[i]+"     "+price[i]+"     "+count[i]);
			totalCount += count[i];
			totalMoney += count[i]*price[i];
		}
		System.out.println("-------------------------------------------------------------");
		System.out.println("�ܿ������"+totalCount); 
		System.out.println("�����Ʒ�ܽ�"+totalMoney);
	}
	public static int chooseFunction(){
		System.out.println("-------------������------------");
		System.out.println("1.�鿴����嵥");
		System.out.println("2.�޸���Ʒ�������");
		System.out.println("3.�˳�");
		System.out.println("������Ҫִ�еĲ�����ţ�");
		Scanner sc = new Scanner(System.in);
		int chooseNumber = sc.nextInt();
		return chooseNumber;
	}
}