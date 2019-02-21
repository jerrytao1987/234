import java.util.ArrayList;
import java.util.Scanner;

public class GoodsStore {

	public static void main(String[] args) {
		ArrayList<GoodsItem> array = new ArrayList<GoodsItem>();
		// 1.初始化商品
		init(array);
		//2.创建Scanner类
		Scanner sc = new Scanner(System.in);
		// 3.选择的序号进行相应的功能操作
		chooseOperater(array,sc);
	}

	/*
	 * 修改货物
	 */
	public static void updateGood(ArrayList<GoodsItem> arr,Scanner sc) {
		System.out.print("请输入您要修改信息的水果编号:");
		int id = sc.nextInt();
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).ID == id) {
				System.out.print("请输入新的水果ID:");
				arr.get(i).ID = sc.nextInt();
				System.out.print("请输入新的水果名称:");
				arr.get(i).name = sc.next();
				System.out.print("请输入新的水果单价:");
				arr.get(i).price = sc.nextDouble();
				System.out.println("水果信息更新完毕!");
				return;
			}
		}
		System.out.println("对不起，没有这个编号的水果!");
	}

	/*
	 * 删除货物
	 */
	public static void deleteGood(ArrayList<GoodsItem> arr,Scanner sc) {
		System.out.print("请输入您要删除的水果编号:");
		int id = sc.nextInt();
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).ID == id) {
				arr.remove(i);
				System.out.println("水果信息删除完毕!");
				return;
			}
		}
		System.out.println("对不起，没有这个编号的水果!");
	}

	/*
	 * 添加货物
	 */
	public static void addGood(ArrayList<GoodsItem> arr,Scanner sc) {
		GoodsItem g = new GoodsItem();
		System.out.print("请输入新水果的名称:");
		g.name = sc.next();
		System.out.print("请输入新水果的编号:");
		g.ID = sc.nextInt();
		System.out.print("请输入新水果单价:");
		g.price = sc.nextDouble();
		arr.add(g);
	}

	/*
	 * 查询货物
	 */
	public static void showGoods(ArrayList<GoodsItem> arr) {
		System.out.println("=======================商品库存清单=======================");
		System.out.println("商品编号\t商品名称\t\t商品单价");
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i).ID + "\t" + arr.get(i).name + "\t\t" + arr.get(i).price);
		}
	}

	/*
	 * 选择的序号进行相应的功能操作
	 */
	public static void chooseOperater(ArrayList<GoodsItem> arr,Scanner sc) {
		while (true) {
			showMenu();
			System.out.println("请您输入要操作的功能序号：");
			String choose = sc.next();
			switch (choose) {
			case "1":// 查询货物
				showGoods(arr);
				break;
			case "2":// 添加新货物
				addGood(arr,sc);
				break;
			case "3":// 删除货物
				deleteGood(arr,sc);
				break;
			case "4":// 修改货物
				updateGood(arr,sc);
				break;
			case "5":// 退出系统
				sc.close();
				System.out.println("退出系统");
				return;
			default:
				System.out.println("对不起，没有您输入的功能，请重新选择");
			}
		}
	}

	/*
	 * 展示菜单
	 */
	public static void showMenu() {
		System.out.println("=========================欢迎光临itcast超市=========================");
		System.out.println("1:查询货物  2：添加新货物 3:删除货物 4：修改货物");
		System.out.println("5：退出系统");
	}

	/*
	 * 初始化商品的方法
	 */
	public static void init(ArrayList<GoodsItem> arr) {
		GoodsItem item = new GoodsItem();
		item.name = "少林寺酥饼核桃";
		item.ID = 9001;
		item.price = 120;

		GoodsItem item2 = new GoodsItem();
		item2.name = "尚康杂粮牡丹饼";
		item2.ID = 9002;
		item2.price = 20;

		GoodsItem item3 = new GoodsItem();
		item3.name = "新疆原产哈密瓜";
		item3.ID = 3;
		item3.price = 9007;

		arr.add(item);
		arr.add(item2);
		arr.add(item3);
	}
	/*
	 * 
	 */

}
