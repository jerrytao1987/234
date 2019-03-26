package cn.itcast.springmvc.pojo;

import java.util.List;

public class QueryVo {
	private Integer[] ids;
	private List<Items> itemList;
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	public List<Items> getItemList() {
		return itemList;
	}
	public void setItemList(List<Items> itemList) {
		this.itemList = itemList;
	}
}
