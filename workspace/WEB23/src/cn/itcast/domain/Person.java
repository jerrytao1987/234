package cn.itcast.domain;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Person implements HttpSessionBindingListener {
	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("person被session绑定了");
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("person被session解绑了");
	}
}
