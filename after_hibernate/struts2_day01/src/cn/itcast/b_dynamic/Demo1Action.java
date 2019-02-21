package cn.itcast.b_dynamic;

public class Demo1Action {
	
	public String add(){
		System.out.println("添加用户!");
		return "success";
	}
	public String delete(){
		System.out.println("删除用户!");
		return "success";
	}
	public String update(){
		System.out.println("修改用户!");
		return "success";
	}
	public String select(){
		System.out.println("查看用户!");
		return "success";
	}
}
