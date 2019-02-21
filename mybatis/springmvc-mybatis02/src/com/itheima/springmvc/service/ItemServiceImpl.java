package com.itheima.springmvc.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.springmvc.dao.ItemsMapper;
import com.itheima.springmvc.pojo.Items;
@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemsMapper itemsMapper;
	
	public List<Items> selectItemsList(){
		return itemsMapper.selectByExampleWithBLOBs(null);
	}

	@Override
	public Items selectItemsById(Integer id) {
		return itemsMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateItemsById(Items items) {
		items.setCreatetime(new Date());
		itemsMapper.updateByPrimaryKeyWithBLOBs(items);
		
	}
}
