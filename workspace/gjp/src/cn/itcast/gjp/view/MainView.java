package cn.itcast.gjp.view;

import java.util.Scanner;

import cn.itcast.gjp.controller.ZhangWuController;

public class MainView {
	private ZhangWuController controller = new ZhangWuController();
	public void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("---------------�ܼ��ż�ͥ�������---------------");
			System.out.println("1.�������2.�༭����3.ɾ������4.��ѯ����5.�˳�ϵͳ");
			System.out.println("������Ҫ�����Ĺ������[1-5]:");
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
		System.out.println("1.��ѯ����  2.������ѯ");
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
