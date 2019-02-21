package cn.itcast.c_param;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
//如何在action中获得原生servletApi
public class Demo8Action extends ActionSupport{
	
	private String name;
	//自动类型转换只能转换8大基本类型以及对应包装类
	private Integer age;
	//支持特定类型字符串转换为Date,例如yyyy-MM-dd
	private Date birthday;

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Demo8Action() {
		super();
		System.out.println("action被创建了……");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String execute(){
		System.out.println("name参数值:"+name+",age参数值："+age+",生日："+birthday);
		return "success";
	}
	
}
