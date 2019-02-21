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
				System.out.println("功能选择有误，请输入正确的功能序号!");			
			}
		}
	}
	public static void exit(){
		System.out.println("----------------退出---------------");
		System.out.println("您已退出系统");
	}
	public static void update(String[] brand,int[] count){
		System.out.println("------------修改商品库存数量-----------");
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<brand.length; i++){
			System.out.println("请输入"+ brand[i] +"商品库存数");
			count[i]= sc.nextInt();
		}
	}
	public static void printStore(String[] brand,double[] size,double[] price,int[] count){
		System.out.println("---------------------------查看库存清单--------------------------");
		System.out.println("品牌型号		尺寸	价格	库存数");
		int totalCount = 0;
		int totalMoney = 0;
		for(int i=0;i<brand.length;i++){
			System.out.println(brand[i]+"              "+size[i]+"     "+price[i]+"     "+count[i]);
			totalCount += count[i];
			totalMoney += count[i]*price[i];
		}
		System.out.println("-------------------------------------------------------------");
		System.out.println("总库存数："+totalCount); 
		System.out.println("库存商品总金额："+totalMoney);
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
}