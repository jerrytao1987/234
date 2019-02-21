package cn.itcast.c_param;


import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

//如何在action中获得原生servletApi
public class Demo11Action extends ActionSupport {

	private List<String> list;
	private Map<String, String> map;

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public String execute() throws Exception {
		System.out.println("list:"+list);
		System.out.println("map:"+map);
		return "success";
	}

}
