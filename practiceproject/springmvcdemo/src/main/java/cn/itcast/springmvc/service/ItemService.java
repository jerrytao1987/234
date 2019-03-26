package cn.itcast.springmvc.service;

import java.util.List;

import cn.itcast.springmvc.pojo.Items;

public interface ItemService {

	public List<Items> queryItemList();

	public Items queryItemById(Integer id);

	public void updateItem(Items item);
}
