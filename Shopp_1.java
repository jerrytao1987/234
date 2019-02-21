import java.util.ArrayList;
import java.util.Scanner;
public class Shopp_1{
	public static void main(String[] args){
		ArrayList<Goods> array = new ArrayList<Goods>();
		addGoods(array);
		int choose;
		while(true){
			choose = chooseFunction();
			switch(choose){
				case 1:
				printStore(array);
				break;
				case 2:
				update(array);
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
	public static void exit(){
		System.out.println("----------------�˳�---------------");
		System.out.println("�����˳�ϵͳ");
	}
	public static void update(ArrayList<Goods> array){
		System.out.println("------------�޸���Ʒ�������-----------");
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<array.size();i++){
			Goods g = array.get(i);
			System.out.println("������"+ g.brand +"��Ʒ�����");
			int newCount = sc.nextInt();
			g.count = newCount;
		}
	}
	public static void printStore(ArrayList<Goods> array){
		System.out.println("---------------------------�鿴����嵥--------------------------");
		System.out.println("Ʒ���ͺ�		�ߴ�	�۸�	�����");
		int totalCount = 0;
		double totalMoney = 0;
		for(int i=0;i<array.size();i++){
			Goods g = array.get(i);
			System.out.println(g.brand+"              "+g.size+"     "+g.price+"     "+g.count);
			totalCount +=g.count;
			totalMoney +=g.count*g.price;
		}
		System.out.println("-------------------------------------------------------------");
		System.out.println("�ܿ������"+totalCount); 
		System.out.println("�����Ʒ�ܽ�"+totalMoney);
	}
	public static void addGoods(ArrayList<Goods> array){
		
		Goods g1 = new Goods();
		Goods g2 = new Goods();
		g1.brand = "MacBook";
		g1.size = 13.3;
		g1.price = 9999.99;
		g1.count =3;
		
		g2.brand = "ThinkPad";
		g2.size = 15.6;
		g2.price = 7999.99;
		g2.count =1;
		
		array.add(g1);
		array.add(g2);
		
	}
}