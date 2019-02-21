package cn.itcast.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("car")
public class Car {
	private String name;
	private String color;
	public String getName() {
		return name;
	}
	@Value("玛莎拉蒂")
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	@Value("绿色")
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + "]";
	}
	
}
