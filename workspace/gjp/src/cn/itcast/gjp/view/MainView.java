package cn.itcast.gjp.view;

import java.util.Scanner;

import cn.itcast.gjp.controller.ZhangWuController;

public class MainView {
	private ZhangWuController controller = new ZhangWuController();
	public void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("---------------管家婆家庭记账软件---------------");
			System.out.println("1.添加账务　2.编辑账务　3.删除账务　4.查询账务　5.退出系统");
			System.out.println("请输入要操作的功能序号[1-5]:");
			int choose = sc.nextInt();
			switch(choose){
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				System.exit(0);
				break;
			}

		}
	}
	public void selectZhangWu(){
		System.out.println("1.查询所有  2.条件查询");
		Scanner sc = new Scanner(System.in);
		int selectChooser = sc.nextInt();
		switch(selectChooser){
		case 1:
			selectAll();
			break;
		case 2:
			select();
			break;
		}
	}
	public void selectAll(){
		
	}
	public void select(){
		
	}
}
