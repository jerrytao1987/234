package cn.itcast.b_tag;

import com.opensymphony.xwork2.ActionSupport;

public class Demo3Action extends ActionSupport {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(name);
		this.addActionError("添加的错误信息");
		return SUCCESS;
	}
	
}
