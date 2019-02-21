package cn.itcast.gjp.view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import cn.itcast.gjp.controller.ZhangWuController;
import cn.itcast.gjp.domain.ZhangWu;

public class MainView {
	private ZhangWuController zc = new ZhangWuController();
	public void run(){
		boolean flag = true;
		while(flag){
			Scanner sc = new Scanner(System.in);
			System.out.println("---------------管家婆家庭记账软件---------------");
			System.out.println("1.添加账务　2.编辑账务　3.删除账务　4.查询账务　5.退出系统");
			System.out.println("请输入要操作的功能序号[1-5]:");
			int option = sc.nextInt();
			myChoice(sc,option);
		}
	}
	public void myChoice(Scanner sc,int option){
		switch(option){
		case 1:
			break;
		case 2:
			try {
				updateZhangWu(sc);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			break;
		case 3:
			break;
		case 4:
			selectZhangWu(sc);
			break;
		case 5:
			System.exit(0);
			break;
		default:
			System.out.println("您输入的选项不正确，请输入要操作的功能序号[1-5]:");
			int op = sc.nextInt();
			myChoice(sc,op);
			break;
		}
	}
	private void updateZhangWu(Scanner sc) throws ParseException {
		selectAll();
		ZhangWu zw = new ZhangWu();
		System.out.println("请输入要修改的ID");
		//先要判断ID是否存在,这里省略
		zw.setZwid(sc.nextInt());
		System.out.println("请输入分类名称");
		zw.setFlname(sc.next());
		System.out.println("请输入账户");
		zw.setZhanghu(sc.next());
		System.out.println("请输入金额");
		zw.setMoney(sc.nextDouble());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		zw.setCreatetime(df.parse(df.format(new Date())));
		System.out.println("请输入具体描述");
		zw.setDescription(sc.next());
		int flag = zc.updateZhangWu(zw);
		if(flag>0){
			System.out.println("修改成功！");
		}else{
			System.out.println("修改失败！");
		}
	}
	private void selectZhangWu(Scanner sc) {
		System.out.println("1.查询所有,2.条件查询");
		int op = sc.nextInt();
		selectChoice(sc,op);
	}
	private void selectChoice(Scanner sc, int op) {
		switch(op){
		case 1:
			selectAll();
			break;
		case 2:
			select();
			break;
		default:
			System.out.println("您输入的选项不正确，请输入要操作的功能序号[1-2]:");
			int choice = sc.nextInt();
			selectChoice(sc,choice);
		}
	}
	private void select() {
		System.out.println("查询日期格式为xxxx-xx-xx");
		System.out.print("请输入查询起始时间：");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate=null;
		Scanner sc = new Scanner(System.in);
		String startString = sc .nextLine();
		try {
			startDate = df.parse(startString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.print("请输入查询结束时间：");
		Date endDate=null;
		String endString = sc.nextLine();
		try {
			endDate = df.parse(endString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<ZhangWu> list = zc.select(startDate,endDate);
		printList(list);
	}
	private void selectAll() {
		List<ZhangWu> list = zc.selectAll();
		printList(list);
	}
	public void printList(List<ZhangWu> list) {
		System.out.println("ID\t类别\t账户\t金额\t时间\t\t说明");
		if(list!=null){
			for (ZhangWu zhangWu : list) {
				System.out.println(zhangWu);
			}
		}
	}
}
