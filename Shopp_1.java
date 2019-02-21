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
				System.out.println("功能选择有误，请输入正确的功能序号!");			
			}
		}
	}
	public static int chooseFunction(){
		System.out.println("-------------库存管理------------");
		System.out.println("1.查看库存清单");
		System.out.println("2.修改商品库存数量");
		System.out.println("3.退出");
		System.out.println("请输入要执行的操作序号：");
		Scanner sc = new Scanner(System.in);
		int chooseNumber = sc.nextInt();
		return chooseNumber;
	}
	public static void exit(){
		System.out.println("----------------退出---------------");
		System.out.println("您已退出系统");
	}
	public static void update(ArrayList<Goods> array){
		System.out.println("------------修改商品库存数量-----------");
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<array.size();i++){
			Goods g = array.get(i);
			System.out.println("请输入"+ g.brand +"商品库存数");
			int newCount = sc.nextInt();
			g.count = newCount;
		}
	}
	public static void printStore(ArrayList<Goods> array){
		System.out.println("---------------------------查看库存清单--------------------------");
		System.out.println("品牌型号		尺寸	价格	库存数");
		int totalCount = 0;
		double totalMoney = 0;
		for(int i=0;i<array.size();i++){
			Goods g = array.get(i);
			System.out.println(g.brand+"              "+g.size+"     "+g.price+"     "+g.count);
			totalCount +=g.count;
			totalMoney +=g.count*g.price;
		}
		System.out.println("-------------------------------------------------------------");
		System.out.println("总库存数："+totalCount); 
		System.out.println("库存商品总金额："+totalMoney);
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