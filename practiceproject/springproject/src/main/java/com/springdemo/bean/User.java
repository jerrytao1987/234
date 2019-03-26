package com.springdemo.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class User {
	private String name;
	private Integer age;
	private String[] arr;
	private List list;
	private Map map;
	private Properties prop;
	public String[] getArr() {
		return arr;
	}
	public void setArr(String[] arr) {
		this.arr = arr;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public Properties getProp() {
		return prop;
	}
	public void setProp(Properties prop) {
		this.prop = prop;
	}
	public User() {
		
	}
	public User(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void init(){
		System.out.println("对象初始化方法执行了");
	}
	public void destroy(){
		System.out.println("对象销毁方法执行了");
	}
}
