package cn.itcast.gjp.view;

import java.util.List;
import java.util.Scanner;

import cn.itcast.gjp.controller.ZhangWuController;
import cn.itcast.gjp.domain.ZhangWu;

public class MainView {
	private ZhangWuController controller = new ZhangWuController();
	public void run(){
		while(true){
			Scanner sc = new Scanner(System.in);
			System.out.println("---------------管家婆家庭记账软件---------------");
			System.out.println("1.添加账务　2.编辑账务　3.删除账务　4.查询账务　5.退出系统");
			System.out.println("请输入要操作的功能序号[1-5]:");
			int choose = sc.nextInt();
			switch(choose){
			case 1:
				addZhangWu();
				break;
			case 2:
				editZhangWu();
				break;
			case 3:
				deleteZhangWu();
				break;
			case 4:
				selectZhangWu();
				break;
			case 5:
				//return;
				System.exit(0);
			}
		}
	}
	private void deleteZhangWu() {
		selectAll();
		Scanner sc = new Scanner(System.in);
		System.out.println("选择的是删除功能，请输入需要删除的ID");
		int id = sc.nextInt();
		System.out.println("您确定要删除ID为"+id+"的记录吗？yes or no?");
		if(sc.next().equals("yes")){
			if(controller.deleteZhangWu(id)>0){
				System.out.println("删除成功");
			}else{
				System.out.println("删除失败");
			}
		}else{
			run();
		}
	}
	private void editZhangWu() {
		selectAll();
		System.out.println("选择的是编辑功能,请输入需要修改的ID");
		Scanner sc = new Scanner(System.in);
		ZhangWu zw = new ZhangWu();
		zw.setZwid(sc.nextInt());
		System.out.println("请输入分类名称");
		zw.setFlname(sc.next());
		System.out.println("请输入账户");
		zw.setZhanghu(sc.next());
		System.out.println("请输入金额");
		zw.setMoney(sc.nextDouble());
		System.out.println("请输入时间");
		zw.setCreatetime(sc.next());
		System.out.println("请输入具体描述");
		zw.setDescription(sc.next());
		if(controller.editZhangWu(zw)>0){
			System.out.println("修改成功！");
		}else{
			System.out.println("修改失败");
		}
	}
	private void addZhangWu() {
		System.out.println("您选择的是账务的添加功能");
		Scanner sc = new Scanner(System.in);
		ZhangWu zw = new ZhangWu();
		System.out.println("请输入分类名称");
		zw.setFlname(sc.next());
		System.out.println("请输入账户");
		zw.setZhanghu(sc.next());
		System.out.println("请输入金额");
		zw.setMoney(sc.nextDouble());
		System.out.println("请输入时间");
		zw.setCreatetime(sc.next());
		System.out.println("请输入具体描述");
		zw.setDescription(sc.next());
		if(controller.addZhangWu(zw)>0){
			System.out.println("添加成功！");
		}else{
			System.out.println("添加失败");
		}
	}
	private void selectZhangWu(){
		Scanner sc = new Scanner(System.in);
		System.out.println("1.查询所有,2.条件查询");
		int selectChoose = sc.nextInt();
		switch(selectChoose){
		case 1:
			selectAll();
			break;
		case 2:
			select();
			break;	
		}
	}
	private void selectAll(){
		List<ZhangWu> list = controller.selectAll();
		print(list);
	}
	public void print(List<ZhangWu> list) {
		System.out.println("ID\t类别\t账户\t金额\t时间\t\t说明");
		for (ZhangWu zhangWu : list) {
			System.out.println(zhangWu.getZwid()+"\t"+zhangWu.getFlname()+"\t"+zhangWu.getZhanghu()+"\t"+zhangWu.getMoney()+"\t"+zhangWu.getCreatetime()+"\t"+zhangWu.getDescription());
		}
	}
	private void select() {
		Scanner sc = new Scanner(System.in);
		System.out.println("查询日期格式为xxxx-xx-xx");
		System.out.print("请输入查询起始时间：");
		String startDate = sc.nextLine();
		System.out.print("请输入查询结束时间：");
		String endDate = sc.nextLine();
		List<ZhangWu> list = controller.select(startDate,endDate);
		if(list.size()>0){
			print(list);
		}else{
			System.out.println("没有查询到数据");
		}
	}
}
